<%@page import="java.text.SimpleDateFormat"%>
<%@page import="bibliotecaSpring.models.Aluno"%>
<%@page import="java.util.List"%>
<%@page import="bibliotecaSpring.daos.AlunoDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<h1>Lista de Aluno</h1>

	<table border="1">
		<thead>
			<tr>
				<th>MATRICULA</th>
				<th>NOME</th>
				<th>CPF</th>
				<th>DATA DE NASC.</th>
				<th>ENDEREÇO</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="aluno" items="${aluno }">
				<tr>
					<td>${aluno.matricula}</td>
					<td>${aluno.nome}</td>
					<td>${aluno.cpf}</td>
					<td>${aluno.dataNascimento.time}</td>
					<td>${aluno.endereco}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

</body>
</html>