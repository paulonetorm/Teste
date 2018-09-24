package comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Atividade.daos.LivroDAO;
import Atividade.models.Livro;

public class RemoverLivro implements Logica {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		Long id = null;
		Livro livro = null;
		
		try {
			id = Long.parseLong(request.getParameter("id"));
			livro = new LivroDAO().getById(id); 
			
			if(new LivroDAO().remover(livro)){
				return "WEB-INF/ConfirmacaoLivroRemovido.jsp";
			}else {
				return "erro.jsp";
			}
		} catch (Exception e) {
			return "erro.jsp";
		}
	}

}
