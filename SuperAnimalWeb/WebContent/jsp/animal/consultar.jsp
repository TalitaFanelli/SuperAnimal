<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="bd.*,bd.core.*,bd.daos.*,bd.dbos.*,java.util.*"%>
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
	href="${pageContext.request.contextPath}/css/animal.css">

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


	  <section class="container-fluid">

	  	<%
    String mensagem = (String)request.getSession().getAttribute("mensagem");
	String cpf_digitado = (String)request.getSession().getAttribute("cpf_digitado");

    if(mensagem == "sucesso"){
    	out.print("<section class='alert alert-success' role='alert'>" + "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>" +
    			"<span aria-hidden='true'>&times;</span></button><strong>Sucesso: </strong><br>Cadastro atualizado com sucesso!</section>");
    }

    else if(mensagem == "aviso"){
    	out.print("<section class='alert alert-info' role='alert'>" + "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>" +
    			"<span aria-hidden='true'>&times;</span></button><strong>Aten&ccedil;&atilde;o: </strong><br>Atualiza&ccedil;&atilde;o cancelada! N&atilde;o existe nenhum(a) M&eacute;dico(a) ou Cliente com esse CPF " + cpf_digitado + "</section>");
    }

    else if (mensagem == "erro"){
    	out.print("<section class='alert alert-danger' role='alert'>" + "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>" +
    			"<span aria-hidden='true'>&times;</span></button><strong>Erro: </strong><br>Contate o Administrador, erro ao atualizar!</section>");
    }

    request.getSession().setAttribute("mensagem", null);
	%>

    <section class="text-center">
      <h2 class="underline-section-title section-title">CONSULTAR CADASTRO</h2>
    </section> <br>

	<%
	String id_animal = (String) request.getSession().getAttribute("id_animal");

	MeuResultSet dados = BD.animais.selectTodosDadosAnimais(id_animal);

	String nome = null, sobrenome = null, nascimento = null, sexo = null, especie = null, raca = null, pelagem = null, responsavel = null;

	while(dados.next()) {
		nome = dados.getString("NOME");
		sobrenome = dados.getString("SOBRENOME");
		nascimento = dados.getString("NASCIMENTO");
		sexo = dados.getString("SEXO");
		especie = dados.getString("ESPECIE");
		raca = dados.getString("RACA");
		pelagem = dados.getString("PELAGEM");
		responsavel = dados.getString("CPF_CLI_MED");
		}
		%>
    <section class="animal">

      <section class="panel-group">
        <section class="panel panel-default">
          <section class="panel-heading panel-heading-1">
            <h4 class="panel-title">
             DADOS DO ANIMAL
          </h4>
          </section>

          <section class="panel-body panel-body-1"> <br>

            <section class="row">
              <section class="col-sm-2">

                <form>
                  <section class="profile-userpic">
                    <img src="${pageContext.request.contextPath}/imagens/200x200.png" class="img-responsive" alt="animal-foto">
                  </section> <br>
                  <section class="text-center">
                    <button class="btn btn-secondary btn-lg btn-profile-foto" disabled>TROCAR</button>
                  </section>
                </form>
              </section>

              <section class="col-sm-10"> <br>

                <form id="form-atualizar" action="${pageContext.request.contextPath}/UpdateDadosAnimal?id_animal=<%=id_animal%>" method="post">

                  <section class="form-inline">
                    <section class="form-group">
                      <label for="animal_dono">CPF DONO(A)*</label><br>
                      <section class="input-group">
                        <input value="<%=responsavel%>" id="animal_dono" class="form-control text-center cpf" type="text" name="animal_dono" size="17" maxlength="14" placeholder="000.000.000-00" onkeyup="validarCPF(animal_dono);" pattern="[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}" required />
                      </section>
                      <section>
                        <label id="label-animal_dono"> </label><br>
                      </section>
                    </section>
                  </section>

                  <section class="form-inline">

                    <section class="form-group">
                      <label for="animal_nome">NOME*</label><br>
                      <section class="input-group">
                        <input value="<%=nome%>" id="animal_nome" class="form-control text-center" type="text" name="animal_nome" size="35" maxlength="25" pattern="[a-zA-Zá-úÁ-ÚãõÃÕçÇ\s]+$" required placeholder="NOME*" onkeyup="validarNome(animal_nome);" /><br>
                      </section>
                      <section>
                        <label id="label-animal_nome"> </label><br>
                      </section>
                    </section>

                    <section class="form-group">
                      <label for="animal_sobrenome">SOBRENOME*</label><br>
                      <section class="input-group">
                        <input value="<%=sobrenome%>" id="animal_sobrenome" class="form-control text-center" type="text" name="animal_sobrenome" size="65" maxlength="45" pattern="[a-zA-Zá-úÁ-ÚãõÃÕçÇ\s]+$" required placeholder="SOBRENOME*" onkeyup="validarSobrenome(animal_sobrenome);" /><br>
                      </section>
                      <section>
                        <label id="label-animal_sobrenome"> </label><br>
                      </section>
                    </section>

                  </section> <br>

                  <section class="form-inline">

                    <section class="form-group">
                      <label for="animal_sexo">SEXO*</label><br>
                      <section class="input-group">

                        <select value="<%=sexo%>" id="animal_sexo" class="text-center" name="animal_sexo" required onchange="validarSexo(animal_sexo);">
                        			<%
					if (sexo.equals("F")) {
						out.println("<option value='F' selected>F&Ecirc;MEA</option>");
						out.println("<option value='M' >MACHO</option>");
					}

					else if (sexo.equals("M")) {
						out.println("<option value='F'>F&Ecirc;MEA</option>");
						out.println("<option value='M' selected>MACHO</option>");
					}
				%>
                                        </select>
                      </section>
                      <section>
                        <label id="label-animal_sexo"> </label><br>
                      </section>
                    </section>

                    <section class="form-group">
                      <label for="animal_nascimento">NASCIMENTO*</label><br>
                      <section class="input-group">
                        <input value="<%=nascimento%>" id="animal_nascimento" class="form-control date" type="text" name="animal_nascimento" size="11" maxlength="10" min="1917-01-01" max="2004-12-31" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}+$" onkeyup="validarNascimento(animal_nascimento);" required placeholder="00/00/0000"
                        />
                      </section>
                      <section>
                        <label id="label-animal_nascimento"> </label><br>
                      </section>
                    </section>

                    <section class="form-group idade">
                      <label>IDADE</label><br>

                      <%

                      String[] data = nascimento.split("/");

                      int dia = Integer.parseInt(data[0]);
                      int mes = Integer.parseInt(data[1]);
                      int ano = Integer.parseInt(data[2]);

                      Calendar birthDay = new GregorianCalendar(ano, mes, dia);

                      Calendar today = new GregorianCalendar();

                      today.setTime(new Date());

                      int yearsInBetween = today.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);

                      int monthsDiff = today.get(Calendar.MONTH) - birthDay.get(Calendar.MONTH);

                      monthsDiff = monthsDiff + 1;

                      long age = yearsInBetween;
                      %>

                      <input value="<%=age%>" id="calculo_ano" class="form-control text-center" disabled type="text" name="calculo_ano" placeholder="0" size="1" />
                      <label for="calculo_ano">ano(s) e </label>

                      <input value="<%=monthsDiff%>" id="calculo_mes" class="form-control text-center" disabled type="text" name="calculo_mes" placeholder="0" size="1" />
                      <label for="calculo_mes">m&ecirc;s(es)</label>

                      <section>
                        <label> </label><br>
                      </section>

                    </section>

                  </section> <br>

                  <section class="form-inline">

                    <section class="form-group">
                      <label for="animal_especie">ESP&Eacute;CIE*</label><br>
                      <section class="input-group">

                        <select value="<%=especie%>" id="animal_especie" class="text-center" name="animal_especie" required onchange="validarEspecie(animal_especie);">
                        			<%
					if (especie.equals("CANIS LUPUS")) {
						out.println("<option value='CANIS LUPUS' selected>CANIS LUPUS</option>");
						out.println("<option value='FELIS CATUS' >FELIS CATUS</option>");
					}

					else if (especie.equals("FELIS CATUS")) {
						out.println("<option value='CANIS LUPUS'>CANIS LUPUS</option>");
						out.println("<option value='FELIS CATUS' selected>FELIS CATUS</option>");
					}
				%>
				</select>
                      </section>
                      <section>
                        <label id="label-animal_especie"> </label><br>
                      </section>
                    </section>

                    <section class="form-group">
                      <label for="animal_raca">RA&Ccedil;A*</label><br>
                      <section class="input-group">
                        <input value="<%=raca%>" id="animal_raca" class="form-control text-center" type="text" name="animal_raca" size="35" maxlength="25" pattern="[a-zA-Zá-úÁ-ÚàÀ]{2}[a-zA-Zá-úÁ-ÚãõÃÕçÇàÀ\s]+$" required placeholder="*RA&Ccedil;A" onkeyup="validarRaca(animal_raca);" />
                      </section>
                      <section>
                        <label id="label-animal_raca"> </label><br>
                      </section>
                    </section>

                    <section class="form-group">
                      <label for="animal_pelagem">PELAGEM*</label><br>
                      <section class="input-group">
                        <input value="<%=pelagem%>" id="animal_pelagem" class="form-control text-center" type="text" name="animal_pelagem" size="30" maxlength="20" pattern="[a-zA-Zá-úÁ-ÚàÀ]{2}[a-zA-Zá-úÁ-ÚãõÃÕçÇàÀ\s]+$" required placeholder="*PELAGEM" onkeyup="validarPelagem(animal_pelagem);" />
                      </section>
                      <section>
                        <label id="label-animal_pelagem"> </label><br>
                      </section>
                    </section>

                  </section>
 		<section class="float-right"> <section class="salvar">
		<button form="form-atualizar"
			class="btn btn-secondary btn-lg btn-modal-salvar" type="submit"
			title="Atualizar" value="Atualizar">ATUALIZAR</button>
		</section> </section>
		      </form>
              </section>
            </section>
          </section>

        </section>
      </section>

          </section>
        </section>
  <!-- Container Fluid -->

  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.12/jquery.mask.js" charset="utf-8"></script>

  <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.6/moment.min.js" charset="utf-8"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.6/locale/pt-br.js" charset="utf-8"></script>

  <!-- Include all compiled plugins (below), or include insectionidual files as needed -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" charset="utf-8"></script>

  <script src="${pageContext.request.contextPath}/js/animal.js" charset="utf-8">
  </script>

</body>

</html>
