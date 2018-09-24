package comando;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Atividade.daos.LivroDAO;
import Atividade.models.Livro;

public class BuscarLivro implements Logica {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String titulo = request.getParameter("titulo");
		List<Livro> resposta = new ArrayList<>();
		
		try {
			
			if(titulo== null || titulo.equals("0") || titulo.isEmpty() || titulo.length() == 0){
				resposta = new LivroDAO().getLista();
			}
			
			else {
				for(Livro livro : new LivroDAO().getLista()){
					if(livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())){
						resposta.add(livro);
					}
				}
			}
		} catch (Exception e) {
			return "erro.jsp";
		}
		
		
		request.setAttribute("livros", resposta);
		
		return "ListarLivros.jsp";
	};

}
