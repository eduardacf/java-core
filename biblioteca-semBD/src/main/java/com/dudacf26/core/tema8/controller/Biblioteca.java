package com.dudacf26.core.tema8.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.dudacf26.core.tema8.GeradorDeId;
import com.dudacf26.core.tema8.dao.AluguelDAO;
import com.dudacf26.core.tema8.dao.LivroDAO;
import com.dudacf26.core.tema8.dominio.Aluguel;
import com.dudacf26.core.tema8.dominio.Livro;

public class Biblioteca {
	private LivroDAO livrodao;
	private List<Livro> gerenciaDelivros;
	private GeradorDeId geradorId;

	private void inicializaGerador() {
		int idInicial = 0;
		if (!gerenciaDelivros.isEmpty()) {
			idInicial = gerenciaDelivros.get(gerenciaDelivros.size() - 1).getId();
		}
		geradorId = new GeradorDeId(idInicial);
	}

	public Biblioteca() {
		this.gerenciaDelivros = new ArrayList<Livro>();
	}

	public void adicionarLivro(String titulo, String autor) {
		List<Livro> gerenciaDelivros = livrodao.carregarDadosDosLivros();
		inicializaGerador();
		int id = geradorId.gerarId();
		Livro livro = new Livro(id, titulo, autor, true);
		gerenciaDelivros.add(livro);
		livrodao.salvarDadosDosLivros(gerenciaDelivros);
	}

	public List<Livro> listarTodosOsLivros() {
		return gerenciaDelivros;
	}

	public List<Livro> buscarLivroPorAutor(String nome) {
		List<Livro> gerenciaDelivros = livrodao.carregarDadosDosLivros();
		List<Livro> livrosEncontrados = new ArrayList<>();
		livrosEncontrados = gerenciaDelivros.stream()
				.filter(l -> l.getAutor().toLowerCase().contains(nome.toLowerCase())).collect(Collectors.toList());
		return livrosEncontrados;
	}

	public Optional<Livro> buscarLivroPorId(int id) {
		List<Livro> gerenciaDelivros = livrodao.carregarDadosDosLivros();
		Optional<Livro> livroOptional = Optional.empty();
		for (Livro livro : gerenciaDelivros) {
			if (livro.getId() == id) {
				livroOptional = Optional.of(livro);
			}
		}
		return livroOptional;
	}

	public List<Livro> buscarLivroTitulo(String titulo) {
		List<Livro> gerenciaDelivros = livrodao.carregarDadosDosLivros();
		List<Livro> livrosEncontrados = new ArrayList<>();
		livrosEncontrados = gerenciaDelivros.stream()
				.filter(l -> l.getTitulo().toLowerCase().contains(titulo.toLowerCase())).collect(Collectors.toList());
		return livrosEncontrados;
	}

	public boolean excluirLivro(int id) {
		List<Livro> gerenciaDelivros = livrodao.carregarDadosDosLivros();
		for (Livro livro : gerenciaDelivros) {
			if (livro.getId() == id && livro.isDisponivel()) {
				gerenciaDelivros.remove(livro);
				livrodao.salvarDadosDosLivros(gerenciaDelivros);
				return true;
			}
		}
		return false;
	}




}
