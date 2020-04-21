package com.dudacf26.core.tema8.dominio;

import java.util.ArrayList;
import java.util.List;

public class Livro {

	private int id;
	private String titulo;
	private String autor;
	private boolean disponivel;
	private List<Pessoa> historicoDeEmprestimos = new ArrayList<Pessoa>();

	public Livro(int id, String titulo, String autor, boolean disponivel) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.disponivel = disponivel;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public List<Pessoa> getHistoricoDeEmprestimos() {
		return historicoDeEmprestimos;
	}

	public void setHistoricoDeEmprestimos(Pessoa pessoa) {
		historicoDeEmprestimos.add(pessoa);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	@Override
	public String toString() {
		return "\nLivro de ID:" + id + "\nTítulo:" + titulo + "\nAutor:" + autor + "\n";
	}

}
