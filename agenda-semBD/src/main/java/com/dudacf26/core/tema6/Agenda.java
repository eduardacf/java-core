package com.dudacf26.core.tema6;

import java.util.ArrayList;
import java.util.List;

public class Agenda {

	private List<Contato> contatos;
	private GeradorDeId id =  new GeradorDeId();

	public Agenda() {
		this.contatos = new ArrayList<>();
	}

	public void adicionarCont(String nome) {
		Contato contato = new Contato(nome,id.gerarId());
		contatos.add(contato);
	}

	public void removerCont(int id) {
		contatos.remove(buscarContatoPorId(id));
	}

	public List<Contato> buscarContatoPorNome(String nome) {
		List<Contato> contatoEncontrado = new ArrayList<Contato>();
		for (int i = 0; i < contatos.size(); i++) {
			if (nome.equals(contatos.get(i).getNome())) {
				contatoEncontrado.add(contatos.get(i));

			}
		}
		return contatoEncontrado;
	}

	public Contato buscarContatoPorId(int id) {
		Contato contatoLocalizado = null;
		for (int i = 0; i < contatos.size(); i++) {
			if (contatos.get(i).getId() == id) {
				contatoLocalizado = contatos.get(i);
			}
		}
		return contatoLocalizado;
	}

	public List<Contato> listarContatos() {
		return contatos;
	}
}
