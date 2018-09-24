package comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Atividade.daos.AlunoDAO;
import Atividade.models.Aluno;

public class RemoverAluno implements Logica {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		Long id = null;
		Aluno aluno = null;
		
		try {
			id = Long.parseLong(request.getParameter("id"));
			aluno = new AlunoDAO().getById(id);

			if(new AlunoDAO().remover(aluno)){
				return "WEB-INF/ConfirmacaoAlunoRemovido.jsp";
			}else {
				return "erro.jsp";
			}
			
		} catch (Exception e) {
			return "erro.jsp";
		}
	}

}
