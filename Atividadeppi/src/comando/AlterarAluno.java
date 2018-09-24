package comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Atividade.daos.AlunoDAO;
import Atividade.models.Aluno;

public class AlterarAluno implements Logica {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			Long id = Long.parseLong(request.getParameter("id"));
			Aluno aluno = new AlunoDAO().getById(id);
			
			request.setAttribute("aluno", aluno);
		} catch (Exception e) {
			return "erro.jsp";
		}
		
		return "Aluno.jsp";
	}

}
