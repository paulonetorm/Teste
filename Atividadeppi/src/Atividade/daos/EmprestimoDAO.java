package Atividade.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Atividade.models.Aluno;
import Atividade.models.Empretimo;
import Atividade.models.Livro;

public class EmprestimoDAO {
	private Connection connection;

	public EmprestimoDAO() {
		connection = ConnectionFactory.getConnection();
	}
	public boolean inserir(Empretimo x) {

		String sql = "insert into Emprestimo (aluno, livro, dataEmprestimo) " + "values (?, ?, ?);";
	
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setLong(1, x.getAluno().getId());
			stmt.setLong(2, x.getLivro().getId());
			stmt.setDate(3, new java.sql.Date(x.getDataEmprestimo().getTimeInMillis()));
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public List<Empretimo> getLista() {
		List<Empretimo> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from emprestimo");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Empretimo x = new Empretimo();
				Aluno aluno = new AlunoDAO().getById(rs.getLong("aluno"));
				Livro livro = new LivroDAO().getById(rs.getLong("livro"));
				x.setAluno(aluno);
				x.setLivro(livro);
				
				Calendar dataEmprestimo = Calendar.getInstance();
				dataEmprestimo.setTime(rs.getDate("dataEmprestimo"));
				x.setDataEmprestimo(dataEmprestimo);

				Calendar dataDevolucao = null;
				dataDevolucao = (Calendar) dataEmprestimo.clone();
				dataDevolucao.add(Calendar.DAY_OF_MONTH , Empretimo.DIAS_DE_DURACAO);
				
				x.setDataEmprestimo(dataEmprestimo);
				x.setDataDevolucao(dataDevolucao);
				
				if(Calendar.getInstance().after(dataDevolucao)) {
					x.setSituacao(false);
				}else {
					x.setSituacao(true);
				}

				result.add(x);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public List<Empretimo> getListaByAluno(Aluno aluno) {
		List<Empretimo> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from emprestimo where aluno=?");
			stmt.setLong(1, aluno.getId());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Empretimo y = new Empretimo();
				
				aluno = new AlunoDAO().getById(rs.getLong("aluno"));
				Livro livro = new LivroDAO().getById(rs.getLong("livro"));
				y.setAluno(aluno);
				y.setLivro(livro);

				
				Calendar dataEmprestimo = Calendar.getInstance();
				dataEmprestimo.setTime(rs.getDate("dataEmprestimo"));
				y.setDataEmprestimo(dataEmprestimo);

				Calendar dataDevolucao = null;
				dataDevolucao = (Calendar) dataEmprestimo.clone();
				dataDevolucao.add(Calendar.DAY_OF_MONTH , Empretimo.DIAS_DE_DURACAO);
				
				y.setDataEmprestimo(dataEmprestimo);
				y.setDataDevolucao(dataDevolucao);

				if(Calendar.getInstance().after(dataDevolucao)) {
					y.setSituacao(false);
				}else {
					y.setSituacao(true);
				}

				result.add(y);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public List<Empretimo> getListaByLivro(Livro livro) {
		List<Empretimo> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from emprestimo where livro=?");
			stmt.setLong(1, livro.getId());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Empretimo w = new Empretimo();
				
				Aluno aluno = new AlunoDAO().getById(rs.getLong("aluno"));
				livro = new LivroDAO().getById(rs.getLong("livro"));
				w.setAluno(aluno);
				w.setLivro(livro);
				
				Calendar dataEmprestimo = Calendar.getInstance();
				dataEmprestimo.setTime(rs.getDate("dataEmprestimo"));
				w.setDataEmprestimo(dataEmprestimo);

				Calendar dataDevolucao = null;
				dataDevolucao = (Calendar) dataEmprestimo.clone();
				dataDevolucao.add(Calendar.DAY_OF_MONTH , Empretimo.DIAS_DE_DURACAO);
				
				w.setDataEmprestimo(dataEmprestimo);
				w.setDataDevolucao(dataDevolucao);
				
				if(Calendar.getInstance().after(dataDevolucao)) {
					w.setSituacao(false);
				}else {
					w.setSituacao(true);
				}

				result.add(w);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public boolean remover(Empretimo emprestimo) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from emprestimo where livro=?");
			//stmt.setString(2, emprestimo.getAluno().getMatricula());
			stmt.setLong(1, emprestimo.getLivro().getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean removerByLivro(Livro livro) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from emprestimo where livro=?");
			//stmt.setString(2, emprestimo.getAluno().getMatricula());
			stmt.setLong(1, livro.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}