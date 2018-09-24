package comando;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Atividade.daos.AlunoDAO;
import Atividade.models.Aluno;

public class AdicionarAluno implements Logica {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		Aluno aluno = new Aluno();
		
		String id = request.getParameter("id");
		String matricula = request.getParameter("matricula");
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String endereco = request.getParameter("endereco");
		
		String dataTexto = request.getParameter("dataNascimento");
		Calendar data = null;
		
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataTexto);
			data = Calendar.getInstance();
			data.setTime(date);
		} catch (Exception e) {
			return "erro.jsp";
		}
		
		aluno.setMatricula(matricula);
		aluno.setNome(nome);
		aluno.setCpf(cpf);
		aluno.setEndereco(endereco);
		aluno.setDataNascimento(data);
		
		try {
			if (id == null || id.equals("0") || id.isEmpty() || id.length() == 0) {
				new AlunoDAO().inserir(aluno);
			}else {
				aluno.setId(Long.parseLong(id));
				new AlunoDAO().atualisar(aluno);
			}
		}catch (Exception e) {
			return "erro.jsp";
		}
		return "WEB-INF/ConfirmacaoAlunoCadastro.jsp";
		
	}

}
