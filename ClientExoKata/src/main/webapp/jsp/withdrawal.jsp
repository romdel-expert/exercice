


<div class="container-fluid content-page text-center">
	<div class="row">
		<div class="col-xl-2 col-lg-2  col-md-2">
		</div>
		<div class="col-xl-8 col-lg-8  col-md-8 text-center" 
		style="border:1px solid rgba(158,134,75,1); padding: 50px; traslateY(-50%);">
			<h1 class="official-color-text">OPERATION DE RETRAIT</h1>
			
			<h5>Pour un montant supérieur à votre plafond de retrait, contactez votre conseiller</h5>
			
			
			
			<h4 class="official-color-text" style="margin:30px 0;">Saisissez le monntant</h4>
			
			
			
			
			
			
			<div class="container-fluid text-center" style="">
				  <div class="row">
				  
				  		<div class="col-3"></div>
				  		
			  			<div class="col-6">
		  					<div class="form-group">
							    <label for="amount_w">Montant*:</label>
							    <input type="text" class="form-control" placeholder="Entrer le montant" id="amount_w"
							    ng-model="amount_w" ng-keypress="setAsNumberAmountWithDraw(); clearField();" maxlength="7">
						  	</div>
						  	<p style="font-size:60%;">( Montant en chiffres )</p>
						  	<p style="font-size:60%;">( Utiliser des "." au lieu de "," pour les montant decimaux )</p>
			  			</div>
			  			
			  			<div class="col-3"></div>
				  </div>
				  
				  
				  <div class="row" style="margin:40px 0px;">
			  			<div class="col-6">
		  					<button type="button" class="btn btn-official" ng-click="changeTransaction();">Changer d'opération</button>
			  			</div>
			  			
			  			<div class="col-6">
						  	<button type="button" class="btn btn-official" ng-click="makeWithdrawal();">Valider</button>
			  			</div>
				  </div>
				  
				  <p style="color: red;">{{err_with_Draw}}</p>
			</div>
			
		</div>
		<div class="col-xl-2 col-lg-2  col-md-2">
		</div>
	</div>
</div>