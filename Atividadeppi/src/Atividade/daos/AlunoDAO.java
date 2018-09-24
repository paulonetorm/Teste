package Atividade.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Atividade.models.Aluno;

public class AlunoDAO {

	private Connection connection;

	public AlunoDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Aluno aluno) {

		String sql = "insert into contatos (nome, matricula, endereco, dataNascimento, cpf) values (?, ?, ?, ?, ?);";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getMatricula());
			stmt.setString(3, aluno.getEndereco());

			stmt.setDate(4, new java.sql.Date(aluno.getDataNascimento().getTimeInMillis()));
			stmt.setString(5, aluno.getCpf());	
			
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public List<Aluno> getLista() {
		List<Aluno> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				Aluno aluno = new Aluno();
				aluno.setId(rs.getLong("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setMatricula(rs.getString("matricula"));
				aluno.setEndereco(rs.getString("endereco"));

				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				aluno.setDataNascimento(data);
				aluno.setCpf(rs.getString("cpf"));

				
				result.add(aluno);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean alterar(Aluno aluno) {
		String sql = "update contatos set nome=?, email=?, endereco=?, dataNascimento=? where id=?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getMatricula());
			stmt.setString(3, aluno.getEndereco());
			stmt.setDate(4, new java.sql.Date(aluno.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, aluno.getId());
			stmt.setString(6, aluno.getCpf());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean remover(Aluno aluno) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from contatos where id=?;");
			stmt.setLong(1, aluno.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean atualisar(Aluno aluno) {

		String sql = "update aluno set nome=?, cpf=?, endereco=?, dataNascimento=?, matricula=? where id = ?";
	
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getCpf());
			stmt.setString(3, aluno.getEndereco());
			stmt.setDate(4, new java.sql.Date(aluno.getDataNascimento().getTimeInMillis()));
			stmt.setString(5, aluno.getMatricula());
			
			stmt.setLong(6, aluno.getId());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public Aluno getById(Long id) {
		Aluno result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos where id = ?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				
				result = new Aluno();
				result.setId(rs.getLong("id"));
				result.setNome(rs.getString("nome"));
				result.setMatricula(rs.getString("matricula"));
				result.setEndereco(rs.getString("endereco"));

				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				result.setDataNascimento(data);
				result.setCpf(rs.getString("cpf"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	

}
