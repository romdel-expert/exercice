


<div class="container-fluid content-page text-center">
	<div class="row">
		<div class="col-2">
		</div>
		<div class="col-8 text-center" 
		style="border:1px solid rgba(158,134,75,1); padding: 50px; traslateY(-50%);">
			<h1 class="official-color-text">HISTORIQUE DU COMPTE</h1>
			
			<h4>Compte n° {{acountSelect.accountNum}}</h4>
			
			
			
			<h4 class="official-color-text" style="margin:30px 0;">{{today}}</h4>
			
			
			
			
			
			
			<div class="container-fluid text-center" style="">
				  <div class="row">
				  
				  		<div class="col-3"></div>
				  		
			  			<div class="col-6">
		  					<p>Solde</p>
			  			</div>
			  			
			  			<div class="col-3"></div>
				  </div>
				  
				  
				  
				  <div class="row">
					  <div class="container">
						  <h2>{{balance}} euro(s)</h2>
							  <p>Détails des opérations du compte:</p>            
							  <table class="table text-left" style="font-size:80%;">
								    <thead>
									      <tr>
									        <th>Date</th>
									        <th>Type</th>
									        <th>Description</th>
									        <th>Montant(euros)</th>
									      </tr>
								    </thead>
								    <tbody>
									      <tr ng-repeat="trans in listTrans">
										        <td>{{trans.dateTransaction}}</td>
										        <td>{{trans.typeTransaction}}</td>
										        <td>{{trans.transacTitle}}</td>
										        <td style="float:right"><b>{{trans.amountTransaction}}</b></td>
									      </tr>
								    </tbody>
							  </table>
						</div>
				  </div>
				  
				  
				  
				  
				  <div class="row" style="margin:40px 0px;">
			  			<div class="col-6">
		  					<button type="button" class="btn btn-official" ng-click="changeTransaction();">Changer d'opération</button>
			  			</div>
			  			
			  			<div class="col-6">
						  	<button type="button" class="btn btn-official" ng-click="logOut();">Terminer</button>
			  			</div>
				  </div>
			</div>
			
		</div>
		<div class="col-2">
		</div>
	</div>
</div>