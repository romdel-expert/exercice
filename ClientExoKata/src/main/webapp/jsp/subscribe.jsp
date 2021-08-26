


<div class="container-fluid content-page text-center">
	<div class="row">
		<div class="col-xl-2 col-lg-2  col-md-2">
		</div>
		<div class="col-xl-8 col-lg-8  col-md-8 text-center" 
		style="border:1px solid rgba(158,134,75,1); padding: 50px; traslateY(-50%);">
			<h1 class="official-color-text">BIENVENUE CHEZ KATA BANK</h1>
			
			<h5>Toujours à vos cotés pour vous changer la vie</h5>
			
			
			
			<h4 class="official-color-text" style="margin:30px 0;">Inscrivez-vous</h4>
			
			
			
			
			
			
			<div class="container-fluid text-center" style="">
				  <div class="row">
			  			<div class="col-6">
		  					<div class="form-group">
							    <label for="f_name">Votre nom*:</label>
							    <input type="text" class="form-control" placeholder="Entrer votre nom" id="f_name"
							    ng-model="f_name" ng-keypress="clearField();">
						  	</div>
			  			</div>
			  			
			  			<div class="col-6">
		  					<div class="form-group">
							    <label for="l_name">Votre prénom*:</label>
							    <input type="text" class="form-control" placeholder="Entrer votre prénom" id="l_name"
							    ng-model="l_name" ng-keypress="clearField();">
						  	</div>
			  			</div>
			  			
			  			<div class="col-6">
						  	<div class="form-group">
							    <label for="pw">Code secret*:</label>
							    <input type="password" class="form-control" placeholder="Entrer votre code secret" id="pw"
							    maxlength="6" ng-keypress="clearField();">
						  	</div>
						  	<p style="font-size:60%;">( Suite de 6 chiffres )</p>
			  			</div>
			  			
			  			<div class="col-6">
						  	<div class="form-group">
							    <label for="pw1">Confirmer votre code secret*:</label>
							    <input type="password" class="form-control" placeholder="Entrer à nouveau votre code secret" id="pw1"
							    maxlength="6" ng-keypress="clearField();">
						  	</div>
			  			</div>
				  </div>
				  
				  
				  <div class="row" style="margin:40px 0px;">
			  			<div class="col-6">
		  					<button type="button" class="btn btn-official" ng-click="logOut();">Annuler</button>
			  			</div>
			  			
			  			<div class="col-6">
						  	<button type="button" class="btn btn-official" ng-click="saveClient();">Valider</button>
			  			</div>
				  </div>
				  
				  <p style="color: red;">{{err_signUp}}</p>
			</div>
			
		</div>
		<div class="col-xl-2 col-lg-2  col-md-2">
		</div>
	</div>
</div>