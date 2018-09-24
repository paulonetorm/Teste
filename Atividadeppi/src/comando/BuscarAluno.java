package comando;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Atividade.daos.AlunoDAO;
import Atividade.models.Aluno;

public class BuscarAluno implements Logica {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		List<Aluno> resposta = new ArrayList<>();

		try {
			resposta = new AlunoDAO().getLista();
			
		} catch (Exception e) {
			return "erro.jsp";
		}
		
		
		request.setAttribute("alunos", resposta);

		return "ListarAlunos.jsp";

	}
}
