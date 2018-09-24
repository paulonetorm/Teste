package Atividade.models;

import java.util.Calendar;
import java.util.List;

import Atividade.daos.EmprestimoDAO;

public class Aluno {
	
	private long id;
	private String nome;
	private String matricula;
	private String endereco;
	private Calendar dataNascimento;
	private String cpf;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public List<Empretimo> getEmprestimos() {
		return new EmprestimoDAO().getListaByAluno(this);
		
	}
	public boolean Situacao() {
		for(Empretimo emprestimo : this.getEmprestimos()) {
			if(!emprestimo.Situacao()) {
				return emprestimo.Situacao();
			}
			
		}
		return true;
	}

	


}
