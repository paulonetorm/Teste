package comando;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Atividade.daos.AlunoDAO;
import Atividade.daos.EmprestimoDAO;
import Atividade.models.Aluno;
import Atividade.models.Empretimo;

public class CriarRelatorio implements Logica {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		List<Empretimo> emprestimo = new ArrayList<>();
		List<Aluno> alunosDias = new ArrayList<>();
		List<Aluno> alunosAtra = new ArrayList<>();
		
		try {
			for(Aluno aluno : new AlunoDAO().getLista()){
				if (!aluno.getEmprestimos().isEmpty()){
					if (aluno.Situacao()) {
						alunosDias.add(aluno);
					} else {
						alunosAtra.add(aluno);
					}
				}
			}
			emprestimo = new EmprestimoDAO().getLista();

			request.setAttribute("emprestimos", emprestimo);
			request.setAttribute("alunosD", alunosDias);
			request.setAttribute("alunosA", alunosAtra);
			
		} catch (Exception e) {
			return "erro.jsp";
		}
		
		return "relatorio.jsp";
	};

}
