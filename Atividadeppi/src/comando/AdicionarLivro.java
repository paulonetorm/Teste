package comando;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Atividade.daos.LivroDAO;
import Atividade.models.Livro;

public class AdicionarLivro implements Logica {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		Livro livro = new Livro();

		String id = request.getParameter("id");
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		String editora = request.getParameter("editora");
	    String edicao = (request.getParameter("edicao"));
	    int anoPublicacao = Integer.parseInt(request.getParameter("anoPublicacao"));
		
		
		
		livro.setTitulo(titulo);
		livro.setAutor(autor);
		livro.setEditora(editora);
		livro.setEdicao(edicao);
		livro.setAnoPublicacao(anoPublicacao);
		
		try {
			if (id == null || id.equals("0") || id.isEmpty()) {
				new LivroDAO().inserir(livro);
			} else {
				livro.setId(Long.parseLong(id));
				new LivroDAO().atualisar(livro);
			}
			request.setAttribute("menssagem", "O livro" + titulo + "foi adicionado");
		} catch (Exception e) {
			return "erro.jsp";
			
		}
		return "servico?function=BuscaLivro";
	}
}
