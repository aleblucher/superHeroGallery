<!DOCTYPE html>
<html>

<head>
<!--Import Google Icon Font-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">


<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<style>
body {
	background-image: url("http://jonvilma.com/images/colors-6.jpg");
	background-position: center;
	background-color: black;
	background-repeat: no-repeat;
}

.login {
	margin-top: 10vh;
}

.titulo {
	font-size: 18px;
	color: #616060;
}

.login-button {
	margin: 5%;
	margin-top: 0;
}

.card-image img {
	object-fit: cover;
	max-height: 18vh;
}
</style>

</head>

<body>
	<div class="container login">
		<div class="row">
			<div class="col s12 m8 offset-m2 l6 offset-l3">
				<div class="card">
					<div class="card-image">
						<img src="https://materializecss.com/images/sample-1.jpg"> <span
							class="card-title">Bem-vindo ao ColorNote!</span>
					</div>
					<form action="AddUser" method="post" enctype="application/x-www-form-urlencoded">
						<div class="card-content">
							<div class="form-field">
								<label class="titulo" for="username">Username</label>
								<input type="text" id="username" name="username">
							</div>
							<br>
							<div class="form-field">
								<label class="titulo" for="password">Password</label> 
								<input type="password" id="password" name="password">
							</div>
							<div>
								<label class="titulo">Manda Foto plox</label>
								<div class="file-field input-field">
									<div class="btn">
										<span>Pesquisar</span> 
										<input type="file" name="foto"/>
									</div>
									<div class="file-path-wrapper">
										<input class="file-path validate" type="text" placeholder="selecione uma foto" />
									</div>
								</div>
							</div>
						</div>
						<br>
						<div class="right-align">
							<a href="./Login">Voltar para o login</a>
							<button
								class="login-button waves-effect waves-light btn center-align"
								 type="submit">Cadastrar</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!--JavaScript at end of body for optimized loading-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>
</body>

</html>