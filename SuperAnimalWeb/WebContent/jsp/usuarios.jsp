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

<!-- DataTable CSS -->
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css" />

<!-- Mine CSS -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/usuarios.css">

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
							<button form="sair" class="btn btn-sm btn-modal-salvar hide-btn"
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
 	String mensagem = (String) request.getSession().getAttribute("mensagem");

 	if (mensagem == "sucesso") {
 		out.print("<section class='alert alert-success' role='alert'>"
 				+ "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
 				+ "<span aria-hidden='true'>&times;</span></button><strong>Sucesso: </strong><br>Cadastro exclu&iacute;do com sucesso!</section>");
 	}

 	else if (mensagem == "erro") {
 		out.print("<section class='alert alert-danger' role='alert'>"
 				+ "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
 				+ "<span aria-hidden='true'>&times;</span></button><strong>Erro: </strong><br>Contate o Administrador, erro ao excluir cadastro!</section>");
 	}

 	request.getSession().setAttribute("mensagem", null);
 %> <section class="text-center">
	<h2 class="underline-section-title section-title">USU&Aacute;RIOS</h2>
	</section> <br>

	<section class="form-inline"> <section class="form-group">
	<section class="control-group"> <label class="label-color"><strong>FILTRAR
			POR</strong></label> <br>

	<label class="control control-radio"> ANIMAL <input
		type="radio" name="radio" value="animal" /> <section
			class="control_indicator"></section>
	</label>

	<label class="control control-radio"> CLIENTE <input
		type="radio" name="radio" value="cliente" /> <section
			class="control_indicator"></section>
	</label> <label class="control control-radio"> VETERIN&Aacute;RIO <input
		type="radio" name="radio" value="veterinario" /> <section
			class="control_indicator"></section>
	</label>
	</section> </section> </section> <br>

		<section class="animal"> <section
		class="table-responsive animal">

	<table id="tabela-animal" class="display tabela" cellspacing="0"
		width="100%">
		<caption>
			ANIMAL<a
				href="${pageContext.request.contextPath}/jsp/animal/cadastrar.jsp?cadastro=animal">
				<button class="icon-header" type="submit" title="Novo">
					<i class="fa fa-plus" aria-hidden="true"></i>
				</button>
			</a>
		</caption>
		<thead>
			<tr>
				<th>NOME</th>
				<th>SEXO</th>
				<th>ESP&Eacute;CIE</th>
				<th>RESPONS&Aacute;VEL</th>
				<th>PERFIL</th>
				<th>EXCLUIR</th>
			</tr>
		</thead>
		<tbody>
			<%
				int totalAnimal= BD.animais.contadorAnimaisCadastrados();

				if (totalAnimal >= 1) {
					MeuResultSet resultadoAnimal = BD.animais.getTabelaAnimais();

					ArrayList<String> nomeAnimal = new ArrayList<String>();
					ArrayList<String> sexo = new ArrayList<String>();
					ArrayList<String> especie = new ArrayList<String>();
					ArrayList<String> responsavel = new ArrayList<String>();
					ArrayList<String> id_animal = new ArrayList<String>();

					while (resultadoAnimal.next()) {
						nomeAnimal.add(resultadoAnimal.getString("NOME"));
						sexo.add(resultadoAnimal.getString("SEXO"));
						especie.add(resultadoAnimal.getString("ESPECIE"));
						responsavel.add(resultadoAnimal.getString("CPF_CLI_MED"));
						id_animal.add(resultadoAnimal.getString("ID_ANIMAL"));
					}

					for (int x = 0; x < nomeAnimal.size(); x++) {
			%>
			<tr>
				<td>
					<%
						out.println(nomeAnimal.get(x));
					%>
				</td>
				<td>
					<%
						out.println(sexo.get(x));
					%>
				</td>
				<td>
					<%
						out.println(especie.get(x));
					%>
				</td>
 				<td>
					<%
						out.println(responsavel.get(x));
					%>
				</td>

				<td>
					<form
						action="${pageContext.request.contextPath}/SelectCadastroAnimal?consultar=<%=id_animal.get(x)%>"
						method="post">
						<button class="icon" type="submit" title="Consultar"
							value="<%=responsavel.get(x)%>">
							<i class="fa fa-file-text" aria-hidden="true"></i>
						</button>
					</form>
				</td>
				<td>
					<form
						action="${pageContext.request.contextPath}/DeleteAnimal?cadastro=<%=id_animal.get(x)%>"
						method="post">
						<button class="icon" type="submit" title="Excluir"
							value="<%=responsavel.get(x)%>" onclick="return confirmacao();">
							<i class="fa fa-trash" aria-hidden="true"></i>
						</button>
					</form>
				</td>
			</tr>
			<%
				}
				}
			%>
		</tbody>
	</table>

	</section> <!-- FIM cliente --> </section>

	<section class="cliente"> <section
		class="table-responsive cliente">

	<table id="tabela-cliente" class="display tabela" cellspacing="0"
		width="100%">
		<caption>
			CLIENTE<a
				href="${pageContext.request.contextPath}/jsp/cliente/cadastrar.jsp?cadastro=cliente">
				<button class="icon-header" type="submit" title="Novo">
					<i class="fa fa-plus" aria-hidden="true"></i>
				</button>
			</a>
		</caption>
		<thead>
			<tr>
				<th>NOME</th>
				<th>SOBRENOME</th>
				<th>CPF</th>
				<th>ANIMAIS</th>
				<th>PERFIL</th>
				<th>EXCLUIR</th>
			</tr>
		</thead>
		<tbody>
			<%
				int totalCliente = BD.clientes.contadorClientesCadastrados();

				if (totalCliente >= 1) {
					MeuResultSet MeuResultSet = BD.clientes.getTabelaClientes();

					ArrayList<String> nomeCliente = new ArrayList<String>();
					ArrayList<String> sobrenomeCliente = new ArrayList<String>();
					ArrayList<String> cpfCliente = new ArrayList<String>();

					while (MeuResultSet.next()) {
						nomeCliente.add(MeuResultSet.getString("NOME"));
						sobrenomeCliente.add(MeuResultSet.getString("SOBRENOME"));
						cpfCliente.add(MeuResultSet.getString("CLIENTE_CPF"));
					}

					for (int x = 0; x < nomeCliente.size(); x++) {
			%>
			<tr>
				<td>
					<%
						out.println(nomeCliente.get(x));
					%>
				</td>
				<td>
					<%
						out.println(sobrenomeCliente.get(x));
					%>
				</td>
				<td>
					<%
						out.println(cpfCliente.get(x));
					%>
				</td>
				<td><select class="text-center">
						<%
							int contador = BD.clientes.contadorAnimaisCadastrados(cpfCliente.get(x));

									if (contador == 0) {
										out.println("<option>NENHUM</option>");
									}

									else {

										MeuResultSet nomesAnimais = BD.clientes.selectNomeAnimaisCliente(cpfCliente.get(x));

										ArrayList<String> animais = new ArrayList<String>();

										while(nomesAnimais.next()){
										 animais.add(nomesAnimais.getString("NOME"));
										}

										for (int y = 0; y < animais.size(); y++) {
											out.println("<option> " + animais.get(y) + "</option>");
										}
									}
						%>
				</select></td>

				<td>
					<form
						action="${pageContext.request.contextPath}/SelectCadastroCliente?consultar=<%=cpfCliente.get(x)%>"
						method="post">
						<button class="icon" ype="submit" title="Consultar"
							value="<%=cpfCliente.get(x)%>">
							<i class="fa fa-file-text" aria-hidden="true"></i>
						</button>
					</form>
				</td>
				<td>
					<form
						action="${pageContext.request.contextPath}/DeleteCliente?cadastro=<%=cpfCliente.get(x)%>"
						method="post">
						<button class="icon" type="submit" title="Excluir"
							value="<%=cpfCliente.get(x)%>" onclick="return confirmacao();">
							<i class="fa fa-trash" aria-hidden="true"></i>
						</button>
					</form>
				</td>
			</tr>
			<%
				}
				}
			%>
		</tbody>
	</table>

	</section> <!-- FIM cliente --> </section>

	<section class="veterinario"> <section
		class="table-responsive veterinario">

	<table id="tabela-veterinario" class="display tabela" cellspacing="0"
		width="100%">
		<caption>
			VETERIN&Aacute;RIO<a
				href="${pageContext.request.contextPath}/jsp/clinica/cadastrar.jsp?cadastro=medico">
				<button class="icon-header" type="submit" title="Novo">
					<i class="fa fa-plus" aria-hidden="true"></i>
				</button>
			</a>
		</caption>
		<thead>
			<tr>
				<th>NOME</th>
				<th>SOBRENOME</th>
				<th>CPF</th>
				<th>CRMV</th>
				<th>PERFIL</th>
				<th>EXCLUIR</th>
			</tr>
		</thead>
		<tbody>
			<%
				int totalMedico = BD.medicos.contadorMedicosCadastrados();

				if (totalMedico >= 1) {
					MeuResultSet MeuResultSet = BD.medicos.getTabelaVeterinario();

					ArrayList<String> nome = new ArrayList<String>();
					ArrayList<String> sobrenome = new ArrayList<String>();
					ArrayList<String> cpf = new ArrayList<String>();
					ArrayList<String> crmv = new ArrayList<String>();

					while (MeuResultSet.next()) {
						nome.add(MeuResultSet.getString("NOME"));
						sobrenome.add(MeuResultSet.getString("SOBRENOME"));
						cpf.add(MeuResultSet.getString("CPF"));
						crmv.add(MeuResultSet.getString("CRMV"));
					}

					for (int x = 0; x < nome.size(); x++) {
			%>
			<tr>
				<td>
					<%
						out.println(nome.get(x));
					%>
				</td>
				<td>
					<%
						out.println(sobrenome.get(x));
					%>
				</td>
				<td>
					<%
						out.println(cpf.get(x));
					%>
				</td>
				<td>
					<%
						out.println(crmv.get(x));
					%>
				</td>

				<td>
					<form
						action="${pageContext.request.contextPath}/SelectCadastroMedico?consultar=<%=cpf.get(x)%>"
						method="post">
						<button class="icon" ype="submit" title="Consultar"
							value="<%=cpf.get(x)%>">
							<i class="fa fa-file-text" aria-hidden="true"></i>
						</button>
					</form>
				</td>
				<td>
					<form
						action="${pageContext.request.contextPath}/DeleteMedico?cadastro=<%=cpf.get(x)%>"
						method="post">
						<button class="icon" type="submit" title="Excluir"
							value="<%=cpf.get(x)%>" onclick="return confirmacao();">
							<i class="fa fa-trash" aria-hidden="true"></i>
						</button>
					</form>
				</td>
			</tr>
			<%
				}
				}
			%>
		</tbody>
	</table>

	</section> <!-- FIM clinica --> </section> </section>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"
		charset="utf-8"></script>
	<!-- Datatables -->
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
	<!-- Include all compiled plugins (below), or include insectionidual files as needed -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		charset="utf-8"></script>

	<!-- My JS -->
	<script src="${pageContext.request.contextPath}/js/usuarios.js"
		charset="utf-8"></script>

</body>

</html>
