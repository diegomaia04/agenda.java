<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>

<%
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda de contatos</title>
<link rel="icon" href="imagens/faviconfone.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<section class="Agenda Agenda_jsp">
		<h1>Agenda de Contatos</h1>
		<a href="novo.html" class="botao"> Novo Contato </a>
		<a href="report" class="botao1">Relatorio</a>

		<table id="tabela">

			<thead>
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Fone</th>
					<th>Email</th>
					<th>Opções</th>
					
				</tr>
			</thead>

			<tbody>
				<%
				for (int i = 0; i < lista.size(); i++) {
				%>
				<tr>
					<td><%=lista.get(i).getIdcon()%></td>
					<td><%=lista.get(i).getNome()%></td>
					<td><%=lista.get(i).getFone()%></td>
					<td><%=lista.get(i).getEmail()%></td>

					<td><a href="select?idcon=<%=lista.get(i).getIdcon()%>"
						class="botao"> Editar </a>

					<a
						href="javascript:confirmar(<%=lista.get(i).getIdcon()%>)"
						class="botao1"> Excluir </a></td>

					<%
					}
					%>
				</tr>
			</tbody>


		</table>
	</section>
	<p>Somente para fins educativos.</p>

	<script type="text/javascript" src="scripts/confirmador.js"></script>

</body>
</html>