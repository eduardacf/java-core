package com.dudacf26.core.tema8.dominio;

public class Pessoa {

	private String nome;
	private int id;
	private int numeroDeLivrosAlugados;
	private int historicoDosLivrosQueAluga;
	private int retiraLivros;
	private int devolveLivros;

	public Pessoa(String nome, int id) {
		this.nome = nome;
		this.id = id;
	}

	public int devolveLivros() {
		return devolveLivros--;
	}

	public int retiraLivros() {
		return retiraLivros++;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroDeLivrosAlugados() {
		return numeroDeLivrosAlugados;
	}

	public void setNumeroDeLivrosAlugados(int numeroDeLivrosAlugados) {
		this.numeroDeLivrosAlugados = numeroDeLivrosAlugados;
	}

	public int getHistoricoDosLivrosQueAluga() {
		return historicoDosLivrosQueAluga;
	}

	public void setHistoricoDosLivrosQueAluga() {
		historicoDosLivrosQueAluga++;
	}

	@Override
	public String toString() {
		return "Nome:" + nome + "\n " + "id:" + id + "";
	}

}
