package agendaSpring.models;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class Contato {

	private Long id;
	private String nome;
	private String email;
	private String endereco;
	@DateTimeFormat(pattern="dd/mm/yyyy")
	private Calendar DataNascimento;
	
	

	

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public Calendar getDataNascimento() {
		return DataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.DataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + ", nome=" + nome + ", email=" + email + ", endereco=" + endereco
				+ ", dataNascimento=" + DataNascimento + "]";
	}

	


}
