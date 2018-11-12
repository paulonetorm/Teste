package bibliotecaSpring.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import bibliotecaSpring.models.Aluno;
import bibliotecaSpring.models.Emprestimo;
import bibliotecaSpring.models.Livro;


public class EmprestimoDAO  {
	private Connection connection;
	
	public EmprestimoDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean estaEmprestado(int id) {
		String sql = "select emprestimo.id_livro, emprestimo.dataDevolucao from emprestimo where emprestimo.id_livro = ?;";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return false;
	}

	


	public boolean inserir(Emprestimo emprestimos) {

		String sql = "insert into emprestimo (mat_aluno, id_livro, dataEmprestimo, dataDevolucao) values (?, ?, ?, ?);";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, emprestimos.getAluno().getMatricula());
			stmt.setLong(2, emprestimos.getLivro().getId());
			stmt.setDate(3, new java.sql.Date(emprestimos.getDataEmprestimo().getTimeInMillis()));
			stmt.setDate(4, null);

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	
	public List<Emprestimo> getLista() {
		List<Emprestimo> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from emprestimo;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Emprestimo emprestimo = new Emprestimo();
				Aluno aluno = new AlunoDAO().getById(rs.getLong("aluno"));
				Livro livro = new LivroDAO().getById(rs.getLong("livro"));
				emprestimo.setAluno(aluno);
				emprestimo.setLivro(livro);

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataEmprestimo"));
				emprestimo.setDataEmprestimo(data);
				result.add(emprestimo);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

}