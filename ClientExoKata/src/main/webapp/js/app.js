
/* global angular */
var host = "http://localhost:9090";
var myApp=  angular.module("myApp", ["ngRoute"]);
"use strict";


myApp.config(function($routeProvider) {
	$routeProvider
		.when("/",{templateUrl:  "jsp/home.jsp"})
		.when("/home",{templateUrl:  "jsp/home.jsp"})
		.when("/subscribe", {templateUrl: "jsp/subscribe.jsp"})
		.when("/new_acount",{templateUrl:"jsp/new_acount.jsp"})
		.when("/deposit",{templateUrl:  "jsp/deposit.jsp"})
		.when("/balance",{templateUrl: "jsp/balance.jsp"})
		.when("/history",{templateUrl:  "jsp/history.jsp" })
		.when("/menu", {templateUrl:"jsp/menu.jsp"})
		.when("/withdrawal", {templateUrl: "jsp/withdrawal.jsp" });
});

/*
* service to change view or page
*/
myApp.service("LocationSvc", function($location) {
	this.changeView = function(path) {
		return $location.path(path);
	};
});











/*
* the main controller for all the opérations
*/
myApp.controller("HomeCtrl", function($scope, LocationSvc, $http) {
	$scope.list_acount=true;
	$scope.list_trans = false;
	
	$scope.changeView = function(page) {
		LocationSvc.changeView(page);
		//        alert(page);
		hideAll();
	};
	
	
	
	setValue();
	//setBalance();
	
	
	function setValue() {
		var user = JSON.parse(localStorage.getItem("user"));
		if (user !==null) {
			$scope.user = user;
			var listAc=JSON.parse(localStorage.getItem("listAc"));
			//console.log(listAc);
			$scope.listAc=listAc;
			var acount = JSON.parse(localStorage.getItem("acount"));
			if(acount !== null) {
				$scope.acountSelect = acount;
				$scope.balance=acount.balance.toFixed(2);
				var listTrans = JSON.parse(localStorage.getItem("listTrans"));
				if(listTrans!==null){
					$scope.listTrans=listTrans;
				}
			}
		} else {
			LocationSvc.changeView("/home");
		}
	}
	
	
	function setBalance(){
		var balance=JSON.parse(localStorage.getItem("balance"));
			/*if(balance!==null){
			$scope.balance=balance.toFixed(2);
			var date=new Date();
			$scope.today=date.getDate()+"/"+(Number(date.getMonth())+1) +"/"+date.getFullYear();
		}*/
	}
	
	
	
	
	
	
	/*
	*login for the client of the bank
	*/
	$scope.login = function(){
		var num=document.getElementById("num_ac").value;
		var pwd=document.getElementById("pwd").value;
		if(num!==undefined && pwd  != undefined && num!== "" && pwd!== "") {
	
			if(isNaN(num) || isNaN(pwd)) {
				$scope.err_login = "Il faut entre uniquement des chiffres";
			} else {
	
	
				var reqLogin = {
					method: 'POST',
					url: host+'/login',
					headers: {
						'Content-Type': 'application/json'
					},
					data: JSON.stringify( {
						'clientNum':num,
					    'secretCode': pwd
					})
				}
	
	
				$http(reqLogin).then(function(response) {
					//console.log(response);
					if(response.data!== undefined && response.data!== "" && response.data !== null){
						if (response.status === 200){
							var user=response.data;
							$scope.list_acount=true;
							$scope.list_trans=false;
							localStorage.setItem("user", JSON.stringify(user));
							getAcountClient();
	
							//setValue();
							LocationSvc.changeView("/menu");
						}else {
							LocationSvc.changeView("/home");
						}
					} else{
						$scope.err_login="Identifiannt et/ou code secret incorect(s)";
						LocationSvc.changeView("/home");
					}
				}).catch(function(obj) {
					$scope.err_login="Problème lors de l'execution de la requète";
					LocationSvc.changeView("/home");
					console.log(obj);
				});
	
			}
		} else {
		$scope.err_login="Il faut remplir tous les champs";
		}
	};
	
	
	
	
	
	
	
	
	
	/*
	*saving a new cleint of the bank
	*/
	$scope.saveClient = function() {
		var f_name=document.getElementById("f_name").value;
		var l_name=document.getElementById("l_name").value;
		var pw =document.getElementById("pw").value;
		var pw1=document.getElementById("pw1").value;
	
	
		if (f_name !== undefined && l_name !== undefined && pw!== undefined && pw!== undefined
			&& f_name !=="" && l_name!=="" && pw!== "" && pw !== "") {
	
			if (isNaN(pw)) {
				$scope.err_signUp = "Le code secret est incorrect";
			} else {
				if(pw===pw1){
					var reqLogin = {
						method: 'POST',
						url: host+'/client_insert',
						headers: {
							'Content-Type': 'application/json'
						},
						data: JSON.stringify( {
						    "id": 0,
						    "fName": f_name,
						    "lName": l_name,
						    "clientNum": 0,
						    "secretCode": pw
						})
					}
		
		
					$http(reqLogin).then(function(response) {
						console.log(response);
						if(response.data!== undefined && response.data!== "" && response.data !== null){
							if (response.status === 200){
								var user=response.data;
								$scope.list_acount=true;
								$scope.list_trans=false;
								localStorage.setItem("user", JSON.stringify(user));
								getAcountClient();
								setValue();
								alert("Votre est créé et notez votre numéro client : "+user.clientNum);
								LocationSvc.changeView("/menu");
							}else {
								LocationSvc.changeView("/home");
							}
						} else{
							$scope.err_login="Votre inscription n'a pas été effectuée";
							LocationSvc.changeView("/home");
						}
					}).catch(function(obj) {
						$scope.err_login="Problème lors de l'execution de la requète";
						LocationSvc.changeView("/home");
						console.log(obj);
					});
				}else{
					$scope.err_signUp="Les codes secrets ne sont pas identiques";
				}
			}
		} else{
			$scope.err_signUp = "Il faut remplir tous les champs";
		}
	};
	
	
	
	
	
	
	
	
	
	/*
	*get the lsit acount of the client of the bank
	*/
	function getAcountClient() {
		var user = JSON.parse(localStorage.getItem("user"));
		if (user!==null){
			//console.log(user);
			var reqAcClient = {
				method: 'GET',
				url: host+'/acount/'+user.id,
				headers: {
					'Content-Type': 'application/json'
				},
				data:JSON.stringify({
	
				})
			}
	
	
			$http(reqAcClient).then(function(response) {
				//console.log(response.data);
				if (response.data !==undefined && response.data!=="" && response.data!==null) {
					if (response.status === 200) {
						var listAc=response.data;
						localStorage.setItem("listAc",JSON.stringify(listAc));
						//console.log(listAc);
						setValue();
					} else {
						alert("Problème lors de la récupération des comptes");
					}
				} else{
					alert("Vous n'avez pas encore de compte");
				}
			}).catch(function(obj) {
				alert("Problème lors de l'execution de la requète");
				console.log(obj);
			});
		} else{
			alert("Vous n'êtes pas connecté");
			LocationSvc.changeView("/home");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	$scope.setAsNumber = function() {
		var num = document.getElementById("num_ac").value;
		if (isNaN(num)) {
			document.getElementById("num_ac").value = undefined;
			document.getElementById("num_ac").value = "12345678";
		}
	};
	$scope.setAsNumberAmount = function() {
		var amount =document.getElementById("amount").value;
		if (isNaN(amount)){
			document.getElementById("amount").value = undefined;
			document.getElementById("amount").value = "1.0";
			$scope.err_deposit=undefined;
		}
	};
	$scope.setAsNumberAmountWithDraw=function(){
		var amount=document.getElementById("amount_w").value;
		if (isNaN(amount)) {
			document.getElementById("amount_w").value = undefined;
			document.getElementById("amount_w").value="1.0";
			$scope.err_with_Draw = undefined;
		}
	}
	
	
	
	
	
	$scope.gotoSubscribe=function(){
		LocationSvc.changeView("/subscribe");
    };
	
	
	
	
	
	
	
	$scope.gotoFormAcount=function(){
		LocationSvc.changeView("/new_acount");
	};
	
	
	
	
	
	
	
	$scope.saveAcount=function(){
		var acTitle=document.getElementById("ac_title").value;
		var user=JSON.parse(localStorage.getItem("user"));
		if(user!==null){
			if(acTitle!==null && acTitle!==undefined && acTitle!==""){
				
				var date=new Date();
				var dat_text=date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
				
				var reqSaveAc = {
					method: 'POST',
					url: host+'/acount_insert',
					headers: {
						'Content-Type': 'application/json'
					},
					data: JSON.stringify( {
					    "id": 0,
					    "accountNum": "",
					    "balance": 0.0,
					    "dateCreatedAcc": dat_text,
					    "clientId": user.id,
					    "acTitle": acTitle
					})
				}
	
	
				$http(reqSaveAc).then(function(response) {
					console.log(response);
					if(response.data!== undefined && response.data!== "" && response.data !== null){
						if (response.status === 200){
							var listAc=response.data;
							localStorage.setItem("listAc", JSON.stringify(listAc));
							getAcountClient();
	
							setValue();
							alert("Votre compte a été créé avec succès");
							LocationSvc.changeView("/menu");
						}else {
							LocationSvc.changeView("/home");
						}
					} else{
						$scope.err_login="Identifiannt et/ou code secret incorect(s)";
						LocationSvc.changeView("/home");
					}
				}).catch(function(obj) {
					$scope.err_login="Problème lors de l'execution de la requète";
					LocationSvc.changeView("/home");
					console.log(obj);
				});
			}else{
				$scope.err_ac_create="Il faut obligatoire remplir le champ";
			}
		}else{
			LocationSvc.changeView("/home");
		}
	};
	
	
	
	/*
	*cancel process create acount
	*/
	$scope.cancelCreateBankAcount=function(){
		var user=JSON.parse(localStorage.getItem("user"));
		if(user!==null){
			LocationSvc.changeView("/menu");
		}else{
			LocationSvc.changeView("/home");
		}
	};
	
	
	
	
	
	
	
	
	
	/*
	* Change page to go to the form for a deposit
	*/
	$scope.gotoDeposit = function() {
		var acount=JSON.parse(localStorage.getItem("acount"));
		if(acount!==null){
			LocationSvc.changeView("/deposit");
		}else{
			alert("Il faut choisir un compte pour effectuer l'opération");
		}
	};
	
	
	
	
	
	$scope.gotoWithDrowal=function(){
		LocationSvc.changeView("/withdrawal");
    };
    
    
    
    
    
    
    /*
    * get the balance of the bank acount
    */
    $scope.gotoBalance=function(){
    	getAcountClient();
    	var acount=JSON.parse(localStorage.getItem("acount"));
    	if(acount!==null){
    		//console.log(acount);
    		var reqBal = {
					method: 'GET',
					url: host+'/ac_id/'+acount.id,
					headers: {
						'Content-Type': 'application/json'
					},
					data: JSON.stringify( {
						
					})
				}
	
	
				$http(reqBal).then(function(response) {
					//console.log(response);
					if(response.data!== undefined && response.data!== "" && response.data !== null){
						if (response.status === 200){
							var acount=response.data;
							localStorage.setItem("acount", JSON.stringify(acount));
							var balance=acount.balance.toFixed(2);
							localStorage.setItem("balance", JSON.stringify(balance));
							$scope.balance=balance;
							getAcountClient();
							//relaodSelectAcount(acount);
							setValue();
							LocationSvc.changeView("/balance");
						}else {
							LocationSvc.changeView("/home");
						}
					} else{
						$scope.err_login="Identifiannt et/ou code secret incorect(s)";
						LocationSvc.changeView("/home");
					}
				}).catch(function(obj) {
					$scope.err_login="Problème lors de l'execution de la requète";
					LocationSvc.changeView("/home");
					console.log(obj);
				});	
    	}else{
    		alert("Aucun compte selectionné");
    	}
	};
	
	
	
	
	
	/*
	* get the history(transactions list) of the bank acount
	*/
	$scope.gotoHistory  = function(){
		getHistory();
	};
	function getHistory(){
		var acount=JSON.parse(localStorage.getItem("acount"));
    	if(acount!==null){
    		$scope.balance=acount.balance.toFixed(2);
    		localStorage.setItem("balance",JSON.stringify(acount.balance));
    		
    		var reqHisto = {
				method: 'GET',
				url: host+'/transaction/'+acount.id,
				headers: {
					'Content-Type': 'application/json'
				},
				data:JSON.stringify({
					
			    })
			}
		
			
			$http(reqHisto).then(function(response) {
				if (response.data !==undefined && response.data!=="" && response.data!==null) {
					if (response.status === 200) {
						//console.log(response);
						var listTrans=response.data;
						localStorage.setItem("listTrans",JSON.stringify(listTrans));
						var acountSelect=JSON.parse(localStorage.getItem("acount"));
						relaodSelectAcount(acountSelect);
						setValue();
						LocationSvc.changeView("/history");
					} else {
						alert("Problème lors de la récupération des transactions");
					}
				} else{
					alert("Historique non récupérée");
				}
			}).catch(function(obj) {
				console.log(obj);
			});
    		
    		setValue();
			LocationSvc.changeView("/history");
    	}else{
    		alert("Aucun compte selectionné");
    	}
	}
	
	
	
	
	/*
	*go to the page of the list of acount
	*/
	$scope.gotoListTransaction = function(acount) {
		gotoListTransaction(acount);
	};
	function gotoListTransaction(acount){
		if(acount!==null){
			//console.log(acount);
			localStorage.setItem("acount", JSON.stringify(acount));
			setValue();
			$scope.list_acount = false;
			$scope.list_trans=true;
		}else{
			alert("Aucun compte selectionné");
		}
	}
	
	
	/*
	* function to reload the acount after an update
	*/
	function relaodSelectAcount(acount){
		getAcountClient();
		var listAcount=JSON.parse(localStorage.getItem("listAc"));
		
		if(listAcount!==null){
			for(var i=0; i<listAcount.length; i++){
				if(acount.id===listAcount[i].id){
					var ac=listAcount[i];
					localStorage.setItem("acount", JSON.stringify(ac));
					$scope.balance=ac.balance;
    				localStorage.setItem("balance",JSON.stringify(ac.balance));
					setValue();
				}
			}
		}else{
			alert("Aucun compte trouvé");
		}
	}
	
	
	
	
	
	
	
	
	
	/*
	* got to the list bank acount of the client of the bank
	*/
	$scope.gotoListAcount=function(){
		getAcountClient();
		$scope.list_acount=true;
		$scope.list_trans=false;
	};
	
	
	
	
	
	
	$scope.changeTransaction = function(){
		$scope.list_acount=false;
		$scope.list_trans=true;
		LocationSvc.changeView("/menu");
    };
	
	
	
	
	
	
	
	
	
	/*
	* create a transaction with a deposit of money
	*/
	$scope.makeDeposit = function(){
		var amount = document.getElementById("amount").value;
		if (amount !==undefined && amount!== "") {
			if (isNaN(amount)) {
				$scope.err_deposit = "Il faut entrer un nombre";
			} else{
				if (amount <= 1000){
					var acount=JSON.parse(localStorage.getItem("acount"));
					if(acount!==null){
						var date=new Date();
						var dat_text=date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
						//alert(dat_text);
					
						var reqAc = {
							method: 'POST',
							url: host+'/trans_insert',
							headers: {
								'Content-Type': 'application/json'
							},
							data:JSON.stringify({
						        'id': 0,
						        'dateTransaction': dat_text,
						        'typeTransaction': 'CREDIT',
						        'amountTransaction': amount,
						        'balance': 0.0,
						        'transacTitle': 'Dépot argent',
						        'acountId': acount.id
						    })
						}
					
						
						$http(reqAc).then(function(response) {
							if (response.data !==undefined && response.data!=="" && response.data!==null) {
								if (response.status === 200) {
									//console.log(response);
									var listTrans=response.data;
									
									var lastListTrans=JSON.parse(localStorage.getItem("listTrans"));
									
									if(lastListTrans!==null){
										if(lastListTrans.length<listTrans.length){
											localStorage.setItem("listTrans",JSON.stringify(listTrans));
											$scope.list_acount=false;
											$scope.list_trans=true;
											alert("Votre opération a été éffectuée avec succès");
											var acountSelect=JSON.parse(localStorage.getItem("acount"));
											relaodSelectAcount(acountSelect);
											//setValue();
											LocationSvc.changeView("/menu");
										}
										else if(lastListTrans.lenght===listTrans.lenght){
											alert("Votre opération n'a pas été éxécutée");
										}
									}else{
										LocationSvc.changeView("/menu");
									}
								} else {
									alert("Problème lors de la création de la transaction");
								}
							} else{
								$scope.err_login = "Aucune transaction réaliseé";
							}
						}).catch(function(obj) {
							$scope.err_login = "Problème lors de l'execution de la requète";
							console.log(obj);
						});
					}else{
						alert("Aucun compte n'est spécifié pour cette opération");
					}
				} else{
					$scope.err_deposit="Vous ne pouvez pas deposer une somme supérieure à 1000 euros.Prenez contact avec un conseiller";
				}
			}
		} else{
			$scope.err_deposit = "Il faut remplir le champ";
		}
	};
	
	
	
	
	
	
	
	
	$scope.makeWithdrawal=function(){
		var amount = document.getElementById("amount_w").value;
		if(amount!=undefined && amount !== "") {
			if (isNaN(amount)) {
				$scope.err_with_Draw  = "Il faut entrer un nombre";
			}  else {
				if (amount <= 1000) {
					var acount=JSON.parse(localStorage.getItem("acount"));
					if(acount!==null){
						if(acount.balance>amount){
							var date=new Date();
							var dat_text=date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
							//alert(dat_text);
						
							var reqAc = {
								method: 'POST',
								url: host+'/trans_insert',
								headers: {
									'Content-Type': 'application/json'
								},
								data:JSON.stringify({
							        'id': 0,
							        'dateTransaction': dat_text,
							        'typeTransaction': 'DEBIT',
							        'amountTransaction': amount,
							        'balance': 0.0,
							        'transacTitle': 'Retrait Guichet App',
							        'acountId': acount.id
							    })
							}
						
							
							$http(reqAc).then(function(response) {
								if (response.data !==undefined && response.data!=="" && response.data!==null) {
									if (response.status === 200) {
										//console.log(response);
										var listTrans=response.data;
										var lastListTrans=JSON.parse(localStorage.getItem("listTrans"));
										
										if(lastListTrans!==null){
											if(lastListTrans.length<listTrans.length){
												localStorage.setItem("listTrans",JSON.stringify(listTrans));
												$scope.list_acount=false;
												$scope.list_trans=true;
												alert("Votre opération a été éffectuée avec succès");
												var acountSelect=JSON.parse(localStorage.getItem("acount"));
												relaodSelectAcount(acountSelect);
												//setValue();
												LocationSvc.changeView("/menu");
											}
											else if(lastListTrans.lenght===listTrans.lenght){
												alert("Votre opération n'a pas été éxécutée");
											}
										}else{
											LocationSvc.changeView("/menu");
										}
									} else {
										alert("Problème lors de la création de la transaction");
									}
								} else{
									$scope.err_login = "Aucune transaction réaliseé";
								}
							}).catch(function(obj) {
								$scope.err_login = "Problème lors de l'execution de la requète";
								console.log(obj);
							});
						}else{
							$scope.err_with_Draw="Vos ressourses sont insuffisantes pour cette opération";
						}
					}else{
						alert("Aucun compte n'est spécifié pour cette opération");
					}
				} else {
					$scope.err_with_Draw = "Vous ne pouvez pas retirer une somme supérieure à 1000 euros. Prenez contact avec un conseiller";
				}
			}
		}else {
			$scope.err_with_Draw="Il faut remplir le champ";
		}
    };
    
    
    
    
    
    
    /*
    * to clear the error text displayed by typing in a fields
    */
    $scope.clearField=function(){
    	$scope.err_deposit=undefined;
    	$scope.err_login=undefined;
    	$scope.err_ac_create=undefined;
    	$scope.err_signUp=undefined;
    	$scope.err_with_Draw=undefined;
    };
	
	
	
	
	$scope.logOut = function() {
		logOut();
	};
	function logOut() {
		localStorage.removeItem("user");
		localStorage.removeItem("listAc");
		localStorage.removeItem("acount");
		localStorage.removeItem("listTrans");
		localStorage.removeItem("balance");
		LocationSvc.changeView("/home");
	}
});





















