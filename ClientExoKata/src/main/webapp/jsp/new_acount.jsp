


<div class="container-fluid content-page text-center">
	<div class="row">
		<div class="col-xl-2 col-lg-2  col-md-2">
		</div>
		<div class="col-xl-8 col-lg-8  col-md-8 text-center" 
		style="border:1px solid rgba(158,134,75,1); padding: 50px; traslateY(-50%);">
			<h1 class="official-color-text">VOUS ETES SUR KATA BANK</h1>
			
			<h5>Toujours à vos cotés pour vous changer la vie</h5>
			
			
			
			<h4 class="official-color-text" style="margin:30px 0;">Création d'un nouveau compte bancaire</h4>
			
			
			
			
			
			
			<div class="container-fluid text-center" style="">
				  <div class="row">
				  		<div class="col-3">
			  			</div>
			  			<div class="col-6">
		  					<div class="form-group">
							    <label for="ac_title">Libellé du compte*:</label>
							    <input type="text" class="form-control" placeholder="Entrer le libellé du compte" id="ac_title"
							    ng-model="ac_title" ng-keypress="clearField();">
						  	</div>
			  			</div>
			  			<div class="col-3">
			  			</div>
				  </div>
				  
				  
				  <div class="row" style="margin:40px 0px;">
			  			<div class="col-6">
		  					<button type="button" class="btn btn-official" ng-click="cancelCreateBankAcount();">Annuler</button>
			  			</div>
			  			
			  			<div class="col-6">
						  	<button type="button" class="btn btn-official" ng-click="saveAcount();">Valider</button>
			  			</div>
				  </div>
				  
				  <p style="color: red;">{{err_ac_create}}</p>
			</div>
			
		</div>
		<div class="col-xl-2 col-lg-2  col-md-2">
		</div>
	</div>
</div>