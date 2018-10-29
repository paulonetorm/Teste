package bibliotecaSpring.models;

import bibliotecaSpring.daos.EmprestimoDAO;

public class Livro {
	
	private long id;
	private String titulo;
	private String autor;
	private String editora;
	private int anoPublicacao;
	private String edicao;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public int getAnoPublicacao() {
		return anoPublicacao;
	}
	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
	public String getEdicao() {
		return edicao;
	}
	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}
	public boolean estaDisponivel() {
		try {
			if (new EmprestimoDAO().getListaByLivro(this).isEmpty() || new EmprestimoDAO().getListaByLivro(this).size() == 0) {
				return true;
		} else {
			return false;
		}
	} catch (Exception e) {
		return true;
	}
	}
}
	


