<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:import url="../menu.jsp"></c:import>
<table border="1">
		<thead>
			<tr>
				
				<th>Nome</th>
				<th>Livro</th>
				<th>Data de Empréstimo</th>
			
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="emprestimo" items="${emprestimo }">
				<tr>
					<td>${emprestimo.aluno.nome}</td>
					<td>${emprestimo.livro.titulo}</td>
					<td><fmt:formatDate value="${emprestimo.dataEmprestimo.time}" pattern="dd/MM/yyyy" /></td>
					<td><fmt:formatDate value="${emprestimo.dataDevolucao.time}" pattern="dd/MM/yyyy" /></td>
					<td><a href="/BibliotecaSpring/emprestimo/devolucao?id=${emprestimo.id} ">Devolver</a></td>
					
				</tr>
			</c:forEach>

		</tbody>

	</table>
</body>
</html>