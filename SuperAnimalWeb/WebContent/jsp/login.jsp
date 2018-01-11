<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="bd.*,bd.core.*,bd.daos.*,bd.dbos.*,java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--Identificacao da linguagem-->
<html lang="pt-br">

<!-- Tag Obrigatoria -->

<head>
<!-- Language & Responsive Meta Tag-->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- Mine CSS -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/login.css">

<!-- Tab Browser Image -->
<link rel="icon" type="image/ico"
	href="${pageContext.request.contextPath}/imagens/pata-favicon.ico" />

<!-- Text Fonts -->
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">

<!-- Font Awesome Icons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- Tab name -->
<title>Super Animal - Cl&iacute;nica Veterin&aacute;ria, Banho &
	Tosa</title>
</head>

<!-- Tag Obrigatoria -->

<body>

	<nav class="navbar navbar-default navbar-fixed-top"> <section
		class="container-nav"> <!-- Brand and toggle get grouped for better mobile display -->
	<section class="navbar-header">
	<button type="button" class="navbar-toggle collapsed"
		data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
		<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
		<span class="icon-bar"></span> <span class="icon-bar"></span>
	</button>
	<a class="navbar-brand text" href="${pageContext.request.contextPath}/jsp/index.html">SUPER ANIMAL</a> </section> </section> </nav>

	<br>

	<section class="container-fluid text-center"> <section
		class="row"> <section class="col-sm-8">
	<h3 class="section-title underline-section-title ">
		<strong> CADASTRO* </strong>
	</h3>
	<br>
	<br>

	<p class="text-left">
		<strong>COMO FAZER</strong><br> Venha at&eacute; a cl&iacute;nica
		com o seu bichinho de estima&ccedil;&atilde;o <br>
		<br> <strong>O QUE &Eacute; FEITO</strong><br> Cadastro do
		dono e a carteirinha virtual do bichinho. O processo demora alguns
		minutos e &eacute; gratu&iacute;to <br>
		<br> <strong>O QUE PRECISA</strong><br> Documento com foto
		(RG, CNH, passaporte, etc)<br> CPF do dono<br> Foto de rosto
		do bichinho (tiramos na hora tamb&eacute;m) <br>
		<br> <strong>PARA QUE SERVE</strong><br> Permite acesso ao
		aplicativo no celular, fa&ccedil;a o download:
	</p>

	<section class="float-left"> <figure> <img
		src="../imagens/apple-store.png" class="download"
		alt="Windows-Store-Logo"> <img src="../imagens/google-play.png"
		class="download" alt="Google-Play-Logo"> <img
		src="../imagens/windows-store.png" class="download"
		alt="Windows-Store-Logo"> </figure> </section> <br>
	<br>
	<br>

	<p class="text-left">
		<strong><small>*Em caso de d&uacute;vidas entre em
				contato conosco</small></strong>
	</p>

	</section> <section class="col-sm-4">
	<h3 class="section-title underline-section-title">
		<strong>LOGIN</strong>
	</h3>
	<br>
	<br>

	<form id="form-login" action="${pageContext.request.contextPath}/LoginMedico" method="post">
		<section class="form-group"> <section class="input-group">
		<input id="login" class="form-control text-center login" type="text"
			name="login" size="17" maxlength="14" placeholder="CPF*" required />
		<label for="login" class="input-group-addon"> <span
			class="fa fa-stethoscope fa-lg" aria-hidden="true"></span>
		</label> </section> </section>

		<section class="form-group"> <section class="input-group">
		<input id="senha" class="form-control text-center" type="password"
			name="senha" size="20" maxlength="8" placeholder="SENHA*" required />
		<label for="senha" class="input-group-addon"> <span
			class="fa fa-lock fa-lg" aria-hidden="true"></span>
		</label> </section> </section>

		<section class="checkbox-modal-login"> <input
			id="checkbox_crmv" type="checkbox" /> <label for="checkbox_crmv">Salvar
			dados</label> </section>

		<br>
		<section> <section class="salvar">
		<button form="form-login"
			class="btn btn-secondary btn-lg btn-modal-salvar" type="submit"
			title="Entrar" value="Cadastrar">ENTRAR</button>
		</section> </section>
	</form> <br><br>

<%
 	String mensagem = (String) request.getSession().getAttribute("mensagem");

	if (mensagem == "erro") {
 		out.print("<section class='alert alert-danger' role='alert'>"
 				+ "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
 				+ "<span aria-hidden='true'>&times;</span></button><strong>Erro: </strong><br>Contate o Administrador, n&atilde;o foi poss&iacute;vel validar seu login e senha!</section>");
 	}

	else if (mensagem == "aviso") {
 		out.print("<section class='alert alert-info' role='alert'>"
 				+ "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
 				+ "<span aria-hidden='true'>&times;</span></button><strong>Aten&ccedil;&atilde;o:<br></strong>Login e ou senha inv&aacute;lidos! Verifique se voc&ecirc; est&aacute; cadastrado(a)</section>");
 	}

	else if (mensagem == "desconectado") {
 		out.print("<section class='alert alert-info' role='alert'>"
 				+ "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
 				+ "<span aria-hidden='true'>&times;</span></button><strong>Aten&ccedil;&atilde;o: </strong><br>Voc&ecirc; foi desconectado, fa&ccedil;a o login novamente!</section>");
 	}

 	request.getSession().setAttribute("mensagem", null);
 %>

	</section>
	</section>
	</section>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"
		charset="utf-8"></script>

	<!-- jQuery Mask -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.12/jquery.mask.js"
		charset="utf-8"></script>

	<!-- Include all compiled plugins (below), or include insectionidual files as needed -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		charset="utf-8"></script>

	<!-- My JS -->
	<script src="${pageContext.request.contextPath}/js/login.js"
		charset="utf-8"></script>

</body>
</html>
