<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda de Contatos</title>
<link rel="icon" href="imagens/favicon_fone.png">
<link rel="styLesheet" href="style.css">
</head>
<body>
	<section class="agenda novo_contato">
		<h1>Editar Contato</h1>
		<form name=frmContato action="update">
			<table>
				<tr>
					<td><input type="text" name="idcon" id="caixa3" readonly
						value="<%out.println(request.getAttribute("idcon"));%>"></td>
				</tr>
				<tr>
					<td><input type="text" name="nome" id="caixa1"
						value="<%out.println(request.getAttribute("nome"));%>"></td>
				</tr>
				<tr>
					<td><input type="text" name="fone" id="caixa2"
						value="<%out.println(request.getAttribute("fone"));%>"></td>
				</tr>
				<tr>
					<td><input type="text" name="email" id="caixa1"
						value="<%out.println(request.getAttribute("email"));%>"></td>
				</tr>
			</table>

			<input type="button" value="Salvar" class="botao" onclick="validar()">
		</form>
	</section>

	<script type="text/javascript" src="scripts/validacao.js">
		
	</script>

</body>
</html>