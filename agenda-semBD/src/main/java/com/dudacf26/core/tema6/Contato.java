package com.dudacf26.core.tema6;

public class Contato {

	private String nome;
	private int id;

	public Contato(String nome, int id) {
		this.nome = nome;
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}
	@Override
	public String toString() {
		return "\nNome:" + nome + ""
				+ "\nid:" + id;
	}
}
