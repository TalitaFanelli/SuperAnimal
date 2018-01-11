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
	href="${pageContext.request.contextPath}/css/home.css">

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
	<a class="navbar-brand"
		href="${pageContext.request.contextPath}/jsp/home.jsp">SUPER
		ANIMAL</a> </section> <!-- Collect the nav links, forms, and other content for toggling -->
	<section class="collapse navbar-collapse"
		id="bs-example-navbar-collapse-1">
	<ul class="nav navbar-nav navbar-right">
		<li class="dropdown"><a href="#" class="dropdown-toggle"
			data-toggle="dropdown"> <img
				src="${pageContext.request.contextPath}/imagens/200x200.png"
				class="img-circle special-img"> <%
 	String nomeUsuario = (String) session.getAttribute("nomeUsuario");

 	if (nomeUsuario == null) {
 		request.getSession().setAttribute("mensagem", "desconectado");

 		response.sendRedirect(request.getContextPath() + "/jsp/login.jsp?resultado=desconectado");
 	}

 	else {
 		out.println(nomeUsuario);
 	}
 %> <b class="caret"></b></a>
			<ul class="dropdown-menu">
				<li><a
					href="${pageContext.request.contextPath}/jsp/usuarios.jsp"><i
						class="fa fa-search" aria-hidden="true"></i> USU&Aacute;RIOS </a></li>
				<li class="divider"></li>
				<form id="sair"
					action="${pageContext.request.contextPath}/LogoutMedico"
					method="post">
					<li><section class="text-center"> <a>
							<button form="sair"
								class="btn btn-sm btn-lg btn-modal-salvar hide-btn"
								type="submit" title="Sair" value="Sair">SAIR</button>
						</a>
	</section>
					</li>
	</form>
	</ul>
	</li>
	</ul>
	</section> </section> </nav>

	<section class="container-fluid"> <%
 	out.println("<h2>Ol&aacute;, " + nomeUsuario + "</h2>");
 %> </section>

	<section class="container"> <section
		class="jumbotron text-center">
	<h1>Super Animal</h1>
	<p>Um super tratamento para voc&ecirc; e seu animal de
		estima&ccedil;&atilde;o</p>
	<br>
	<img src="${pageContext.request.contextPath}/imagens/logo.png"
		alt="logo"> </section> </section>

	<!-- Modal -->
	<section id="modal-cliente-senha" class="modal fade" role="dialog">
	<section class="modal-dialog modal-sm"> <!-- Modal content -->
	<section class="modal-content modal-content-senha"> <section
		class="modal-header modal-header-senha">
	<button type="button" class="close" data-dismiss="modal">&times;</button>
	<h4 class="modal-title">TROCAR SENHA</h4>
	</section> <section class="modal-body">
	<form>
		<section class="form-group"> <label
			for="cliente_senha_atual">ATUAL*</label> <br>
		<input id="cliente_senha_atual" class="form-control text-center"
			type="text" name="cliente_senha_atual" size="11" maxlength="8"
			pattern="[a-zA-Z0-9]+$" placeholder="ATUAL*" required /> </section>

		<section class="form-group"> <label for="cliente_senha_nova">NOVA*</label>
		<br>
		<input id="cliente_senha_nova" class="form-control text-center"
			type="text" name="cliente_senha_nova" size="11" maxlength="8"
			pattern="[a-zA-Z0-9]+$" placeholder="NOVA*" required /> </section>

		<section class="form-group"> <label
			for="cliente_senha_confirmacao">CONFIRMA&Ccedil;&Atilde;O*</label> <br>
		<input id="cliente_senha_confirmacao" class="form-control text-center"
			type="text" name="cliente_senha_confirmacao" size="11" maxlength="8"
			pattern="[a-zA-Z0-9]+$" placeholder="CONFIRMA&Ccedil;&Atilde;O*"
			required /> </section>

		<section class="text-center"> <a
			class="btn btn-secondary btn-lg btn-modal-salvar"
			aria-expanded="false">SALVAR</a> </section>

	</form>
	</section> <section class="modal-footer modal-footer-senha">
	<button class="btn btn-secondary btn-outline btn-sm btn-modal-fechar"
		data-dismiss="modal">FECHAR</button>
	</section> </section> </section> </section>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"
		charset="utf-8"></script>

	<!-- Include all compiled plugins (below), or include insectionidual files as needed -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		charset="utf-8"></script>


</body>
</html>
