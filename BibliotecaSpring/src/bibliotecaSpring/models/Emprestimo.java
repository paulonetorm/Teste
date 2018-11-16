package bibliotecaSpring.models;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class Emprestimo {
	private long id;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	private Aluno aluno;
	private Livro livro;
	@DateTimeFormat(pattern="dd/mm/yyyy")
	Calendar dataEmprestimo;
	@DateTimeFormat(pattern="dd/mm/yyyy")
	Calendar dataDevolucao;

	public Calendar getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Calendar dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Calendar getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Calendar dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	@Override
	public String toString() {
		return "Emprestimo [id=" + id + ", aluno=" + aluno + ", livro=" + livro + ", dataEmprestimo=" + dataEmprestimo
				+ ", dataDevolucao=" + dataDevolucao + "]";
	}
	
	

}