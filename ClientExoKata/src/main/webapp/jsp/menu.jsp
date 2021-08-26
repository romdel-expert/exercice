


<div class="container-fluid content-page text-center">
	<div class="row">
		<div class="col-xl-2 col-lg-2  col-md-2">
		</div>
		<div class="col-xl-8 col-lg-8  col-md-8 text-center" 
		style="border:1px solid rgba(158,134,75,1); padding: 50px; traslateY(-50%);">
			<h1 class="official-color-text">Bonjour {{user.lName}} {{user.fName}}</h1>
			<p>Compte n° {{user.clientNum}}</p>
			
			<div class="container-fluid text-center" style="" ng-show="list_acount">
				  
				  <h2 class="text-center">Choisissez un compte</h2>
				  
				  <div class="row" style="margin:40px 0px;">
				  
				  		<div class="col-6 text-left" style="padding: 20px"
				  		ng-repeat="acount in listAc">
		  					<div class="ac-case" style="Border:2px solid rgba(158,134,75,1); padding:30px"
		  					ng-click="gotoListTransaction(acount);">
		  						<h4>{{acount.acTitle}}</h4>
		  						<h5>{{acount.accountNum}}</h5>
		  					</div>
			  			</div>
			  			
			  			
			  			<div class="col-6" style="margin:30px 0px; padding: 20px">
		  					<button type="button" class="btn btn-official" ng-click="gotoFormAcount();">Créer-vous un nouveau compte</button>
			  			</div>
			  			
			  			
			  			<div class="col-12" style="margin:30px 0px;">
		  					<button type="button" class="btn btn-official" ng-click="logOut();">Terminer</button>
			  			</div>
				  </div>
			</div>
			
			
			
			
			<div class="container-fluid text-center" style="" ng-show="list_trans">
				  
				  <h2 class="text-center">Choisissez l'opération que souhaitez effectuer</h2>
				  
				  <div class="row" style="margin:40px 0px;">
				  
				  		<div class="col-6" style="margin:30px 0px;">
		  					<button type="button" class="btn btn-official" ng-click="gotoDeposit();">Effectuer un dépot</button>
			  			</div>
			  			
			  			
			  			<div class="col-6" style="margin:30px 0px;">
		  					<button type="button" class="btn btn-official" ng-click="gotoWithDrowal();">Effectuer un Retrait</button>
			  			</div>
			  			
			  			
			  			<div class="col-6" style="margin:30px 0px;">
						  	<button type="button" class="btn btn-official" ng-click="gotoHistory();">Consulter mes relevés</button>
			  			</div>
			  			
			  			
			  			<div class="col-6" style="margin:30px 0px;">
						  	<button type="button" class="btn btn-official" ng-click="gotoBalance();">Consulter le solde</button>
			  			</div>
			  			
			  			
			  			<div class="col-6" style="margin:30px 0px;">
						  	<button type="button" class="btn btn-official" ng-click="gotoListAcount();">Changer de compte</button>
			  			</div>
			  			
			  			
			  			<div class="col-12" style="margin:30px 0px;">
		  					<button type="button" class="btn btn-official" ng-click="logOut();">Terminer</button>
			  			</div>
				  </div>
			</div>
			
		</div>
		<div class="col-xl-2 col-lg-2  col-md-2">
		</div>
	</div>
</div>