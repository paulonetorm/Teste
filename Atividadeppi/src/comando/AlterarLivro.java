package comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Atividade.daos.LivroDAO;
import Atividade.models.Livro;

public class AlterarLivro implements Logica {
public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			Long id = Long.parseLong(request.getParameter("id"));
			Livro livro = new LivroDAO().getById(id);
			
			request.setAttribute("livro", livro);
		} catch (Exception e) {
			return "erro.jsp";
		}
		
		return "Livro.jsp";
	}

}
