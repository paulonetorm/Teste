package bibliotecaSpring.models;

import java.util.Calendar;

import bibliotecaSpring.daos.AlunoDAO;
import bibliotecaSpring.daos.LivroDAO;

public class Emprestimo {
	public final static int DIAS_DE_DURACAO = 14;
	public final static int MAXIMO_ALUNO = 3;

	private Calendar dataEmprestimo;
	private Calendar dataDevolucao;
	private long livro;
	private long aluno;
	
	private boolean situacao;
	
	public boolean Situacao() {
		return situacao;
	}
	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}
	public Livro getLivro() {
		return new LivroDAO().getById(livro);
	}
	public void setLivro(Livro livro) {
		this.livro = livro.getId();
	}
	public Aluno getAluno() {
		return new AlunoDAO().getById(aluno);
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno.getId();
	}

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
}