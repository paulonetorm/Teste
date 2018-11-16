package bibliotecaSpring.models;

import java.util.Calendar;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import bibliotecaSpring.daos.EmprestimoDAO;

public class Aluno {
	
	private Long id;
	private String nome;
	private String matricula;
	private String endereco;
	@DateTimeFormat(pattern="dd/mm/yyyy")
	private Calendar dataNascimento;
	private String cpf;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
//	public List<Emprestimo> getEmprestimos() {
//		return new EmprestimoDAO().getListaByAluno(this);
//		
//	}
//	
//	public boolean Situacao() {
//		for(Emprestimo emprestimo : this.getEmprestimos()) {
//			if(!emprestimo.Situacao()) {
//				return emprestimo.Situacao();
//			}
//			
//		}
//		return true;
//	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", matricula=" + matricula + ", endereco=" + endereco
				+ ", dataNascimento=" + dataNascimento + ", cpf=" + cpf + "]";
	}


}
