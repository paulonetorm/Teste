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
		<c:import url="../menu.jsp"></c:import>
		<h1>Emprestimo</h1>
		<form action="/BibliotecaSpring/emprestimo" method="post">
		<div>
			<label>Matricula:</label> 
			<select>
			<c:forEach var="aluno" items="${alunos }">
  				<option value="aluno">${aluno.matricula}</option>  				
  			</c:forEach>
			</select>
			<select>
				<c:forEach var="livro" items="${livros }">
  					<option value="aluno">${livro.titulo}</option> 
  				</c:forEach>
			</select>
		</div>
			<button type="submit">Adicionar</button>
		</form> 
	</body>
</html>