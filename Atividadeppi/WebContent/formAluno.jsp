<%@page import="Atividade.models.Aluno"%>
<%@page import="java.util.List"%>
<%@page import="Atividade.daos.AlunoDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	<style>
		body {margin:0; background-color: #1abc9c;}

		ul {
			list-style-type: none;
			margin: 0;
    		padding: 0;
    		overflow: hidden;
    		background-color: #333;
    		position: fixed;
    		top: 0;
    		width: 100%;
		}

		li {
    		float: left;
		}

		li a {
    		display: block;
    		color: white;
    		text-align: center;
    		padding: 14px 16px;
    		text-decoration: none;
		}

		li a:hover:not(.active) {
    		background-color: #111;
		}

		.active {
    		background-color: #4CAF50;
		}
</style>
	</head>
	<body>
		<ul>
  <li><a class="active" href="http://localhost:8080/Atividadeppi/index.html">Home</a></li>
  <li><a href="http://localhost:8080/Atividadeppi/listaLivros.jsp">Livros</a></li>
  <li><a href="http://localhost:8080/Atividadeppi/formLivro.jsp">Cadastrar Livro</a></li>
  <li><a href="http://localhost:8080/Atividadeppi/listaAlunos.jsp">Alunos</a></li>
  <li><a href="http://localhost:8080/Atividadeppi/formAluno.jsp">Cadastrar Aluno</a></li>
  <li><a href="#emprestimo">Emprestimos</a></li>
  <li><a href="#fazEmprestimo">Fazer Emprestimos</a></li>
</ul>
<br>
<br>
<br>
<br>
<br>
<br>		
	<h1>Adicionar Aluno</h1>
	<form action="sistema" method="post">
		<input type="hidden" name="comando" value="AdicionarAluno">
		<div>
			<label>Matricula: </label> 
			<input type="text" name="matricula">
		</div>
		<div>
			<label>Nome: </label> 
			<input type="text" name="nome">
		</div>
		<div>
			<label>CPF: </label> 
			<input type="text" name="cpf">
		</div>
		<div>
			<label>Data de Nascimento: </label>
			<input type="text" name="dataNascimento">
		</div>
		<div>
			<label>Endereço: </label>
			<input type="text" name="endereco">
		</div>
		<div>
			<button type="submit">Adicionar</button>
		</div>
	</form>


	</body>
</html>