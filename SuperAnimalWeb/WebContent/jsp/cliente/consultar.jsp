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
	href="${pageContext.request.contextPath}/css/cliente.css">

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
<title>Super Animal - Cl&iacute;nica Veterin&aacute;ria, Banho & Tosa</title>
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
 	String mensagem = (String) request.getSession().getAttribute("mensagem");

 	if (mensagem == "sucesso") {
 		out.print("<section class='alert alert-success' role='alert'>"
 				+ "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
 				+ "<span aria-hidden='true'>&times;</span></button><strong>Sucesso: </strong><br>Cadastro atualizado com sucesso!</section>");
 	}

 	else if (mensagem == "erro") {
 		out.print("<section class='alert alert-danger' role='alert'>"
 				+ "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
 				+ "<span aria-hidden='true'>&times;</span></button><strong>Erro: </strong><br>Contate o Administrador, erro ao atualizar!</section>");
 	}

 	request.getSession().setAttribute("mensagem", null);
 %>
 <section class="text-center">
	<h2 class="underline-section-title section-title">CONSULTAR
		CADASTRO</h2>
	</section> <br>
	<% String id = (String) request.getSession().getAttribute("cpf");

	MeuResultSet dados = BD.clientes.selectTodosDadosClientes(id); String cpf = null; String nome = null, sobrenome = null, nascimento = null, genero = null; String cep = null, endereco
											= null, bairro = null, numero = null, complemento = null, cidade = null, estado = null; String email = null, fixo = null, celular = null; while (dados.next()) { cpf = dados.getString("CPF"); nome =
											dados.getString("NOME"); sobrenome = dados.getString("SOBRENOME"); nascimento = dados.getString("NASCIMENTO"); genero = dados.getString("GENERO"); cep = dados.getString("CEP"); endereco = dados.getString("ENDERECO"); bairro =
											dados.getString("BAIRRO"); numero = dados.getString("NUMERO"); complemento = dados.getString("COMPLEMENTO"); cidade = dados.getString("CIDADE"); estado = dados.getString("ESTADO"); email = dados.getString("EMAIL"); fixo = dados.getString("FIXO");
											celular = dados.getString("CELULAR"); } %> <section
		class="clinica"> <section class="panel-group"> <section
		class="panel panel-default"> <section
		class="panel-heading panel-heading-1">
	<h4 class="panel-title">DADOS PESSOAIS</h4>
	</section> <section class="panel-body panel-body-1"> <br>

	<section class="row"> <section class="col-sm-2"> <section
		class="profile-userpic"> <img
		src="${pageContext.request.contextPath}/imagens/200x200.png"
		class="img-responsive" alt="foto-perfil"></section> <br>
	<section class="text-center">
	<button form="form-foto"
		class="btn btn-secondary btn-lg btn-profile-foto" disabled>TROCAR</button>
	</section> </section> <section class="col-sm-10"> <br>

	<form id="form-cliente"
		action="${pageContext.request.contextPath}/UpdateDadosPessoaisCliente?cpf=<%=cpf%>"
		method="post">

		<section class="form-inline"> <section class="form-group">
		<label for="cliente_nome">NOME*</label> <br>
		<section class="input-group"> <input value="<%=nome%>" id="cliente_nome"
			class="form-control text-center" type="text" name="cliente_nome"
			size="60" maxlength="40"
			pattern="[a-zA-Zá-úÁ-ÚãõÃÕçÇ][a-zA-Zá-úÁ-ÚãõÃÕçÇ\s]+$" required
			placeholder="NOME*" onkeyup="validarNome(cliente_nome);" /></section> <section> <label id="label-cliente_nome"></label> <br>
		</section> </section> <section class="form-group"> <label
			for="cliente_sobrenome">SOBRENOME*</label> <br>
		<section class="input-group"> <input value="<%=sobrenome%>" id="cliente_sobrenome"
			class="form-control text-center" type="text" name="cliente_sobrenome"
			size="65" maxlength="45"
			pattern="[a-zA-Zá-úÁ-ÚãõÃÕçÇ][a-zA-Zá-úÁ-ÚãõÃÕçÇ\s]+$" required
			placeholder="SOBRENOME*"
			onkeyup="validarSobrenome(cliente_sobrenome);" />
		 </section> <section> <label id="label-cliente_sobrenome"></label> <br>
		</section> </section> </section>
		<br />

		<section class="form-inline"> <section class="form-group">
		<label for="cliente_nascimento">NASCIMENTO*</label> <br>
		<section class="input-group"> <input value="<%=nascimento%>" id="cliente_nascimento"
			class="form-control date" type="text" name="cliente_nascimento"
			size="11" maxlength="10" min="1917-01-01" max="2004-12-31"
			pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}+$"
			onkeyup="validarData(cliente_nascimento);"
			onblur="validarData(cliente_nascimento);" required
			placeholder="00/00/0000" />
		 </section> <section> <label id="label-cliente_nascimento"></label> <br>
		</section> </section> <section class="form-group"> <label for="cliente_genero">G&Ecirc;NERO*</label>
		<br>
		<section class="input-group"> <select value="<%=genero%>" id="cliente_genero"
			class="text-center" name="cliente_genero" required
			onchange="validarGenero(cliente_genero);">
			<%
					if (genero.equals("F")) {
						out.println("<option value='F' selected>FEMININO</option>");
						out.println("<option value='M' >MASCULINO</option>");
					}

					else if (genero.equals("M")) {
						out.println("<option value='F'>FEMININO</option>");
						out.println("<option value='M' selected>MASCULINO</option>");
					}
				%>
		</select></section> <section> <label id="label-cliente_genero"></label> <br>
		</section> </section> <section class="form-group"> <label for="cliente_cpf">CPF*</label>
		<br>
		<section class="input-group"> <input value="<%=cpf%>" id="cliente_cpf"
			class="form-control text-center cpf" type="text" name="cliente_cpf"
			size="17" maxlength="14" placeholder="000.000.000-00"
			onkeyup="validarCPF(cliente_cpf);"
			pattern="[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}" required disabled/> </section> <section> <label id="label-cliente_cpf"></label> <br>
		</section> </section>
		</section> <br>
				<button form="form-cliente"
			class="btn btn-secondary btn-lg btn-modal-salvar hide-btn float-right"
			type="submit" title="Atualizar" value="<%=cpf%>">ATUALIZAR</button>
	</form>
	<!-- FIM DADOS PESSOAIS --> </section> </section> </section> </section> </section> <section class="panel-group">
	<section class="panel panel-default"> <section
		class="panel-heading panel-heading-2">
	<h4 class="panel-title">RESID&Ecirc;NCIA</h4>
	</section> <section class="panel-body panel-body-2"> <br>

	<form id="form-residencia"
		action="${pageContext.request.contextPath}/UpdateDadosResidenciaisCliente?cpf=<%=cpf%>"
		method="post">

		<section class="form-inline"> <section class="form-group">
		<label for="cliente_cep">CEP*</label> <br>
		<section class="input-group"> <input value="<%=cep%>" id="cliente_cep"
			class="form-control text-center cep" type="text" name="cliente_cep"
			size="12" maxlength="9" placeholder="00000-000"
			pattern="[0-9]{5}-[0-9]{3}" required
			onkeyup="validarCEP(cliente_cep);" />   </section> <section> <label id="label-cliente_cep"></label> <br>
		</section> </section> <section class="form-group"> <label for="cliente_endereco">ENDERE&Ccedil;O*</label>
		<br>
		<section class="input-group"> <input value="<%=endereco%>" id="cliente_endereco"
			class="form-control text-center" type="text" name="cliente_endereco"
			size="80" maxlength="60" placeholder="ENDERE&Ccedil;O*"
			pattern="[a-zA-Zá-úÁ-ÚàÀ][a-zA-Z0-9á-úÁ-ÚãõÃÕçÇ,.-àÀ/\s]+$" required
			onkeyup="validarEndereco(cliente_endereco);" />   </section> <section> <label id="label-cliente_endereco"></label> <br>
		</section> </section> <section class="form-group"> <label for="cliente_bairro">BAIRRO*</label>
		<br>
		<section class="input-group"> <input value="<%=bairro%>" id="cliente_bairro"
			class="form-control text-center" type="text" name="cliente_bairro"
			size="45" maxlength="30" placeholder="BAIRRO*"
			pattern="[a-zA-Zá-úÁ-ÚàÀ][a-zA-Zá-úÁ-ÚãõÃÕçÇ,.-àÀ/\s]+$" required
			onkeyup="validarBairro(cliente_bairro);" />   </section> <section> <label id="label-cliente_bairro"></label> <br>
		</section> </section> </section>
		<br>

		<section class="form-inline"> <section class="form-group">
		<label for="cliente_numero">N&Uacute;MERO*</label> <br>
		<section class="input-group"> <input value="<%=numero%>" id="cliente_numero"
			class="form-control text-center" type="text" name="cliente_numero"
			size="17" maxlength="12"
			pattern="[a-zA-Z0-9][a-zA-Zá-úÁ-ÚãõÃÕçÇ,.-àÀ/\s]+$" required
			placeholder="N&Uacute;MERO*" onkeyup="validarNumero(cliente_numero);" />
	 </section> <section> <label id="label-cliente_numero"></label> <br>
		</section> </section> <section class="form-group"> <label
			for="cliente_complemento">COMPLEMENTO (OPCIONAL)</label> <br>
		<section class="input-group"> <input value="<%=complemento%>"
			id="cliente_complemento" class="form-control text-center" type="text"
			name="cliente_complemento" size="50" maxlength="40"
			placeholder="COMPLEMENTO (OPCIONAL)"
			pattern="[a-zA-Z0-9á-úÁ-ÚãõÃÕçÇ,.-àÀ/\s]+$"
			onkeyup="validarComplemento(cliente_complemento);" />   </section> <section> <label id="label-cliente_complemento"></label> <br>
		</section> </section> <section class="form-group"> <label for="cliente_cidade">CIDADE*</label>
		<br>
		<section class="input-group"> <input value="<%=cidade%>" id="cliente_cidade"
			class="form-control text-center" type="text" name="cliente_cidade"
			size="50" maxlength="35" placeholder="CIDADE*"
			pattern="[a-zA-Zá-úÁ-ÚàÀ]{2}[a-zA-Zá-úÁ-ÚãõÃÕçÇàÀ\s]+$" required
			onkeyup="validarCidade(cliente_cidade);" />  </section> <section> <label id="label-cliente_cidade"></label> <br>
		</section> </section> <section class="form-group"> <label for="cliente_estado">ESTADO*</label>
		<br>
		<section class="input-group"> <select value="<%=estado%>" id="cliente_estado"
			class="text-center" name="cliente_estado" required
			onchange="validarEstado(cliente_estado);">
			<%
					if (estado.equals("AC")) {
						out.println("<option value='AC' selected>AC</option>");
						out.println("<option value='AL'>AL</option>");
						out.println("<option value='AP'>AP</option>");
						out.println("<option value='AM'>AM</option>");
						out.println("<option value='BA'>BA</option>");
						out.println("<option value='CE'>CE</option>");
						out.println("<option value='DF'>DF</option>");
						out.println("<option value='ES'>ES</option>");
						out.println("<option value='GO'>GO</option>");
						out.println("<option value='MA'>MA</option>");
						out.println("<option value='MS'>MS</option>");
						out.println("<option value='MT'>MT</option>");
						out.println("<option value='MG'>MG</option>");
						out.println("<option value='PA'>PA</option>");
						out.println("<option value='PB'>PB</option>");
						out.println("<option value='PR'>PR</option>");
						out.println("<option value='PE'>PE</option>");
						out.println("<option value='PI'>PI</option>");
						out.println("<option value='RJ'>RJ</option>");
						out.println("<option value='RN'>RN</option>");
						out.println("<option value='RO'>RO</option>");
						out.println("<option value='RR'>RR</option>");
						out.println("<option value='SC'>SC</option>");
						out.println("<option value='SP' >SP</option>");
						out.println("<option value='SE'>SE</option>");
						out.println("<option value='TO'>TO</option>");
					}

					else if (estado.equals("AL")) {
						out.println("<option value='AC'>AC</option>");
						out.println("<option value='AL'selected>AL</option>");
						out.println("<option value='AP'>AP</option>");
						out.println("<option value='AM'>AM</option>");
						out.println("<option value='BA'>BA</option>");
						out.println("<option value='CE'>CE</option>");
						out.println("<option value='DF'>DF</option>");
						out.println("<option value='ES'>ES</option>");
						out.println("<option value='GO'>GO</option>");
						out.println("<option value='MA'>MA</option>");
						out.println("<option value='MS'>MS</option>");
						out.println("<option value='MT'>MT</option>");
						out.println("<option value='MG'>MG</option>");
						out.println("<option value='PA'>PA</option>");
						out.println("<option value='PB'>PB</option>");
						out.println("<option value='PR'>PR</option>");
						out.println("<option value='PE'>PE</option>");
						out.println("<option value='PI'>PI</option>");
						out.println("<option value='RJ'>RJ</option>");
						out.println("<option value='RN'>RN</option>");
						out.println("<option value='RO'>RO</option>");
						out.println("<option value='RR'>RR</option>");
						out.println("<option value='SC'>SC</option>");
						out.println("<option value='SP' >SP</option>");
						out.println("<option value='SE'>SE</option>");
						out.println("<option value='TO'>TO</option>");
					}

					else if (estado.equals("RN")) {
						out.println("<option value='AC'>AC</option>");
						out.println("<option value='AL'>AL</option>");
						out.println("<option value='AP'>AP</option>");
						out.println("<option value='AM'>AM</option>");
						out.println("<option value='BA'>BA</option>");
						out.println("<option value='CE'>CE</option>");
						out.println("<option value='DF'>DF</option>");
						out.println("<option value='ES'>ES</option>");
						out.println("<option value='GO'>GO</option>");
						out.println("<option value='MA'>MA</option>");
						out.println("<option value='MS'>MS</option>");
						out.println("<option value='MT'>MT</option>");
						out.println("<option value='MG'>MG</option>");
						out.println("<option value='PA'>PA</option>");
						out.println("<option value='PB'>PB</option>");
						out.println("<option value='PR'>PR</option>");
						out.println("<option value='PE'>PE</option>");
						out.println("<option value='PI'>PI</option>");
						out.println("<option value='RJ'>RJ</option>");
						out.println("<option value='RN' selected>RN</option>");
						out.println("<option value='RO'>RO</option>");
						out.println("<option value='RR'>RR</option>");
						out.println("<option value='SC'>SC</option>");
						out.println("<option value='SP' >SP</option>");
						out.println("<option value='SE'>SE</option>");
						out.println("<option value='TO'>TO</option>");
					}

					else if (estado.equals("SP")) {
						out.println("<option value='AC'>AC</option>");
						out.println("<option value='AL'>AL</option>");
						out.println("<option value='AP'>AP</option>");
						out.println("<option value='AM'>AM</option>");
						out.println("<option value='BA'>BA</option>");
						out.println("<option value='CE'>CE</option>");
						out.println("<option value='DF'>DF</option>");
						out.println("<option value='ES'>ES</option>");
						out.println("<option value='GO'>GO</option>");
						out.println("<option value='MA'>MA</option>");
						out.println("<option value='MS'>MS</option>");
						out.println("<option value='MT'>MT</option>");
						out.println("<option value='MG'>MG</option>");
						out.println("<option value='PA'>PA</option>");
						out.println("<option value='PB'>PB</option>");
						out.println("<option value='PR'>PR</option>");
						out.println("<option value='PE'>PE</option>");
						out.println("<option value='PI'>PI</option>");
						out.println("<option value='RJ'>RJ</option>");
						out.println("<option value='RN'>RN</option>");
						out.println("<option value='RO'>RO</option>");
						out.println("<option value='RR'>RR</option>");
						out.println("<option value='SC'>SC</option>");
						out.println("<option value='SP' selected>SP</option>");
						out.println("<option value='SE'>SE</option>");
						out.println("<option value='TO'>TO</option>");
					}
				%>
		</select>   </section> <section> <label id="label-cliente_estado"></label> <br>
		</section> </section> </section> <br>
		<button form="form-residencia"
			class="btn btn-secondary btn-lg btn-modal-salvar hide-btn float-right"
			type="submit" title="Atualizar" value="<%=cpf%>">ATUALIZAR</button>
	</form>
	<!-- FIM RESIDENCIA --> </section> </section> </section> <section class="panel-group"> <section
		class="panel panel-default"> <section
		class="panel-heading panel-heading-3">
	<h4 class="panel-title">CONTATO</h4>
	</section> <section class="panel-body panel-body-3"> <br>

	<form id="form-contato"
		action="${pageContext.request.contextPath}/UpdateDadosContatoCliente?cpf=<%=cpf%>"
		method="post">

		<section class="form-inline"> <section class="form-group">
		<label for="cliente_email">EMAIL*</label> <br>
		<section class="input-group"> <input value="<%=email%>" id="cliente_email"
			class="form-control text-center" type="text" name="cliente_email"
			size="60" maxlength="40"
			pattern="[a-z-A-Z0-9._%+-]+@[a-z-A-Z0-9.-]+\.[A-Z-a-z]{2,4}$"
			required oninput="validarEmail(cliente_email);" />  </section> <section> <label id="label-cliente_email"></label> <br>
		</section> </section> <section class="form-group"> <label for="cliente_fixo">FIXO
			(OPCIONAL)</label> <br>
		<section class="input-group"> <input value="<%=fixo%>" id="cliente_fixo"
			class="form-control text-center fixo" type="text" name="cliente_fixo"
			size="15" maxlength="13" placeholder="(00)0000-0000"
			pattern="\([0-9]{2}\)[0-9]{4}-?[0-9]{4}"
			oninput="validarFixo(cliente_fixo);" />  </section> <section> <label id="label-cliente_fixo"></label> <br>
		</section> </section> <section class="form-group"> <label for="cliente_cel">CELULAR*</label>
		<br>
		<section class="input-group"> <input value="<%=celular%>" id="cliente_cel"
			class="form-control text-center cel" type="text" name="cliente_cel"
			size="13" maxlength="14" placeholder="(00)00000-0000"
			pattern="\([0-9]{2}\)[0-9]{5}-?[0-9]{4}" required
			oninput="validarCel(cliente_cel);" /> </section> <section> <label id="label-cliente_cel"></label> <br>
		</section> </section> </section> <br>
		<button form="form-contato"
			class="btn btn-secondary btn-lg btn-modal-salvar hide-btn float-right"
			type="submit" title="Atualizar" value="<%=cpf%>">ATUALIZAR</button>
	</form>
	<!-- FIM CONTATO --> </section> </section> </section> </section> </section>

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
	<script src="${pageContext.request.contextPath}/js/cliente.js"
		charset="utf-8"></script>

</body>

</html>
