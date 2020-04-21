package com.dudacf26.core.tema8.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.dudacf26.core.tema8.GeradorDeId;
import com.dudacf26.core.tema8.dao.PessoaDAO;
import com.dudacf26.core.tema8.dominio.Livro;
import com.dudacf26.core.tema8.dominio.Pessoa;

public class PessoaController {

	private PessoaDAO pessoadao;
	private List<Pessoa> clientes;
	private GeradorDeId geradorId;

	private void inicializaGerador() {
		int idInicial = 0;
		if (!clientes.isEmpty()) {
			idInicial = clientes.get(clientes.size() - 1).getId();
		}
		geradorId = new GeradorDeId(idInicial);
	}

	public PessoaController() {
		this.clientes = new ArrayList<Pessoa>();
	}

	public List<Pessoa> listarTodosOsClientes() {
		return clientes;
	}

	public void adicionarPessoa(String nome) {
		List<Pessoa> clientes = pessoadao.carregarDadosDasPessoas();
		inicializaGerador();
		int id = geradorId.gerarId();
		Pessoa pessoa = new Pessoa(nome, id);
		clientes.add(pessoa);
		pessoadao.salvarDadosDasPessoas(clientes);
	}

	public Optional<Pessoa> buscarPessoaPorId(int id) {
		List<Pessoa> clientes = pessoadao.carregarDadosDasPessoas();
		Optional<Pessoa> pessoaOptional = Optional.empty();
		for (Pessoa clientesBuscar : clientes) {
			if (clientesBuscar.getId() == id) {
				pessoaOptional = Optional.of(clientesBuscar);
			}
		}
		return pessoaOptional;
	}

	public String listarTopClientes() {
		List<Pessoa> clientes = pessoadao.carregarDadosDasPessoas();
		StringBuffer top = new StringBuffer();
		Collections.sort(clientes, new HistoricoClienteCompara());
		int contador = 0;
		for (Pessoa pessoa : clientes) {
			top.append("Cliente: " + pessoa.getNome() + "    Livros Alugados: " + pessoa.getHistoricoDosLivrosQueAluga()
					+ "\n");
			contador++;
			if (contador > 9)
				break;
		}
		return top.toString();
	}

}
