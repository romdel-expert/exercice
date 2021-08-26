


<div class="container-fluid content-page text-center">
	<div class="row">
		<div class="col-xl-2 col-lg-2  col-md-2">
		</div>
		<div class="col-xl-8 col-lg-8  col-md-8 text-center" 
		style="border:1px solid rgba(158,134,75,1); padding: 50px; traslateY(-50%);">
			<h1 class="official-color-text">SOLDE DU COMPTE</h1>
			
			<h4>Compte n° 123456789</h4>
			
			
			
			<h4 class="official-color-text" style="margin:30px 0;">{{today}}</h4>
			
			
			
			
			
			
			<div class="container-fluid text-center" style="">
				  <div class="row">
				  
				  		<div class="col-3"></div>
				  		
			  			<div class="col-6">
		  					<p>Solde</p>
		  					<h1>{{balance}} euro(s)</h1>
			  			</div>
			  			
			  			<div class="col-3"></div>
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
		<div class="col-xl-2 col-lg-2  col-md-2">
		</div>
	</div>
</div>