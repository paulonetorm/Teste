package comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Atividade.daos.EmprestimoDAO;
import Atividade.daos.LivroDAO;
import Atividade.models.Livro;

public class DevolverLivro implements Logica {
public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		long id = Long.parseLong(request.getParameter("id"));
		Livro livro = new LivroDAO().getById(id);
		
		try{
			if(new EmprestimoDAO().removerByLivro(livro)){
				request.setAttribute
				("menssagem", livro.getTitulo() + " O livro foi devolvido à biblioteca. ");
			}else {
				return "erro.jsp";
			}
		}
		catch (Exception e) {
			return "erro.jsp";
		}
		
		return "index.jsp";
	}

}
