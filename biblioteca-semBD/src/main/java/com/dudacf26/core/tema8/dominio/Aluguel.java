package com.dudacf26.core.tema8.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aluguel {

	private Pessoa pessoa;
	private Livro livro;
	private LocalDate prazoDeEntrega;
	private List<Pessoa> historicoDeEmprestimos = new ArrayList<Pessoa>();


	public LocalDate getPrazoDeEntrega() {
		return prazoDeEntrega.plusDays(7);
	}

	public void setPrazoDeEntrega(LocalDate prazoDeEntrega) {
		this.prazoDeEntrega = prazoDeEntrega;
	}

	public List<Pessoa> getHistoricoDeEmprestimos() {
		return historicoDeEmprestimos;
	}

	public void setHistoricoDeEmprestimos(List<Pessoa> historicoDeEmprestimos) {
		this.historicoDeEmprestimos = historicoDeEmprestimos;
	}

	public Aluguel(Pessoa pessoa, Livro livro) {
		this.pessoa = pessoa;
		this.livro = livro;
		this.prazoDeEntrega = LocalDate.now();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	@Override
	public String toString() {
		return "Aluguel: Nome:" + pessoa + "Livro:" + livro + "Prazo de devolução :" + prazoDeEntrega.plusDays(7) + "";
	}

}
