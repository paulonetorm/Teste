package bibliotecaSpring.models;

import java.util.Calendar;

public class Emprestimo {
	private Aluno aluno;
	private Livro livro;
	Calendar dataEmprestimo;
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
		return "Emprestimo [aluno=" + aluno + ", livro=" + livro + ", dataEmprestimo=" + dataEmprestimo
				+ ", dataDevolucao=" + dataDevolucao + "]";
	}
	
	

}