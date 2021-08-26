


<div class="container-fluid content-page text-center">
	<div class="row">
		<div class="col-xl-2 col-lg-2  col-md-2">
		</div>
		<div class="col-xl-8 col-lg-8  col-md-8 text-center" 
		style="border:1px solid rgba(158,134,75,1); padding: 50px; traslateY(-50%);">
			<h1 class="official-color-text">BIENVENUE CHEZ KATA BANK</h1>
			
			<h5>Toujours à vos cotés pour vous changer la vie</h5>
			
			
			
			<h4 class="official-color-text" style="margin:30px 0;">Authentifier-vous</h4>
			
			
			
			
			
			
			<div class="container-fluid text-center" style="">
				  <div class="row">
			  			<div class="col-6">
		  					<div class="form-group">
							    <label for="num_ac">Identifiant client*:</label>
							    <input type="text" class="form-control" placeholder="Entrer votre identifiant" id="num_ac"
							    ng-model="num_ac" ng-keypress="setAsNumber(); clearField();">
						  	</div>
						  	<p style="font-size:60%;">( Suite de 8 chiffres )</p>
			  			</div>
			  			
			  			<div class="col-6">
						  	<div class="form-group">
							    <label for="pwd">Code secret*:</label>
							    <input type="password" class="form-control" placeholder="Entrer votre code secret" id="pwd"
							    maxlength="6" ng-keypress="clearField();">
						  	</div>
			  			</div>
				  </div>
				  
				  
				  <div class="row" style="margin:40px 0px;">
			  			<div class="col-6">
		  					<button type="button" class="btn btn-official" ng-click="gotoSubscribe();">Créer-vous un compte</button>
			  			</div>
			  			
			  			<div class="col-6">
						  	<button type="button" class="btn btn-official" ng-click="login();">Valider</button>
			  			</div>
				  </div>
				  
				  <p style="color: red;">{{err_login}}</p>
			</div>
			
		</div>
		<div class="col-xl-2 col-lg-2  col-md-2">
		</div>
	</div>
</div>