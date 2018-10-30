<%@page import="java.text.SimpleDateFormat"%>
<%@page import="bibliotecaSpring.models.Livro"%>
<%@page import="java.util.List"%>
<%@page import="bibliotecaSpring.daos.LivroDAO"%>
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


	<h1>Lista de Livros</h1>

	<table border="1">
		<thead>
			<tr>
				<th>TITULO</th>
				<th>AUTOR</th>
				<th>EDITORA</th>
				<th>ANO DE PULB.</th>
				<th>EDIÇÃO</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="livro" items="${livro }">
				<tr>
					<td>${livro.titulo}</td>
					<td>${livro.autor}</td>
					<td>${livro.editora}</td>
					<td>${livro.anoPublicacao}</td>
					<td>${livro.edicao}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

</body>
</html>