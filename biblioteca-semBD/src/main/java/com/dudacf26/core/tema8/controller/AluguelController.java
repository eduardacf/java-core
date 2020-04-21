package com.dudacf26.core.tema8.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dudacf26.core.tema8.dao.AluguelDAO;
import com.dudacf26.core.tema8.dominio.Aluguel;
import com.dudacf26.core.tema8.dominio.Livro;
import com.dudacf26.core.tema8.dominio.Pessoa;

public class AluguelController {
		
	private List<Aluguel> gerenciaDeAlugueis;
	private AluguelDAO aluguelDAO;


	public AluguelController() {
		gerenciaDeAlugueis = new ArrayList<Aluguel>();
	}

	public List<Aluguel> listarTodosOsAlugueis() {
		return gerenciaDeAlugueis;

	}

	public boolean listarAtrasados() {
		List<Aluguel> gerenciaDeAlugueis = aluguelDAO.carregarDadosAlugueis();
		for (Aluguel aluguel : gerenciaDeAlugueis) {
			int verificarAtraso = (LocalDate.now().getDayOfYear() - aluguel.getPrazoDeEntrega().getDayOfYear());
			System.out.println(verificarAtraso);
			System.out.println(aluguel.getLivro().isDisponivel());
			if (aluguel.getLivro().isDisponivel() == false && verificarAtraso > 0) {
				System.out.println("Cliente:" + aluguel.getPessoa().getNome());
				System.out.println("Livro:" + aluguel.getLivro().getTitulo() + "está atrasado!");
				System.out.println("Dias de atraso: " + verificarAtraso + "\n");
				return true;
			}
		}
		System.out.println("Não foi localizado nenhum livro em atraso!");
		return false;
	}

	public void alugarLivro(Pessoa pessoa, Livro livro) {
		List<Aluguel> gerenciaDeAlugueis = aluguelDAO.carregarDadosAlugueis();
		if (pessoa.getNumeroDeLivrosAlugados() < 5) {
			if (livro.isDisponivel()) {
				gerenciaDeAlugueis.add(new Aluguel(pessoa, livro));
				pessoa.retiraLivros();
				livro.setDisponivel(false);
				livro.getHistoricoDeEmprestimos().add(pessoa);
				pessoa.setHistoricoDosLivrosQueAluga();
				System.out.println("O livro " + livro.getTitulo() + " foi alugado :D \n");
				aluguelDAO.salvarDadosAlugueis(gerenciaDeAlugueis);
			} else {
				System.out.println("O Livro" + livro.getTitulo() + "já está alugado!\n");

			}
		} else {
			System.out.println("Você não pode retirar mais livro pois ja atingiu a cota maxima.\n");
		}
	}

	public void renovarLivro(String titulo, int id) {
		List<Aluguel> gerenciaDeAlugueis = aluguelDAO.carregarDadosAlugueis();
		for (Aluguel aluguel : gerenciaDeAlugueis) {
			if (aluguel.getLivro().getTitulo().equals(titulo) && aluguel.getPessoa().getId() == id) {
				int verificarAtraso = (LocalDate.now().getDayOfYear() - aluguel.getPrazoDeEntrega().getDayOfYear());
				if (verificarAtraso < 7) {
					aluguel.setPrazoDeEntrega(aluguel.getPrazoDeEntrega().plusDays(7));
					System.out.println("O livro foi renovado com sucesso :) \n");
					aluguelDAO.salvarDadosAlugueis(gerenciaDeAlugueis);
				} else {
					System.out.println("Você não pode renovar pois está em atraso!!");
				}
			} else {
				System.out.println("Livro não renovado!!");
			}
		}
	}

	public void devolverLivro(Optional<Livro> optional) {
		List<Aluguel> gerenciaDeAlugueis = aluguelDAO.carregarDadosAlugueis();
		Aluguel aluguelAuxiliar = null;
		for (Aluguel aluguel : gerenciaDeAlugueis) {
			if (aluguel.getLivro().equals(optional)) {
				int verificarAtraso = (LocalDate.now().getDayOfYear() - aluguel.getPrazoDeEntrega().getDayOfYear());
				if (verificarAtraso > 7) {

					System.out.println("Você não entregou o livro " + verificarAtraso
							+ "  no prazo correto por isso, está devendo de multa R$: " + (verificarAtraso * 5)
							+ " Reais.\n");

					aluguelAuxiliar = aluguel;
					aluguel.getLivro().setDisponivel(true);
					System.out.println("Livro devolvido porém terá que pagar a multa :)");
				} else {
					aluguelAuxiliar = aluguel;
					aluguel.getLivro().setDisponivel(true);
					System.out.println("Livro devolvido :)");

				}

			}

		}
		excluirEmprestimo(aluguelAuxiliar);
		aluguelDAO.salvarDadosAlugueis(gerenciaDeAlugueis);

	}

	public boolean excluirEmprestimo(Aluguel aluguelAuxiliar) {
		List<Aluguel> gerenciaDeAlugueis = aluguelDAO.carregarDadosAlugueis();
		for (Aluguel aluguel : gerenciaDeAlugueis) {
			gerenciaDeAlugueis.remove(aluguelAuxiliar);
			aluguelDAO.salvarDadosAlugueis(gerenciaDeAlugueis);
			return true;
		}
		return false;
	}

	public Aluguel buscarAluguel(Livro livro) {
		List<Aluguel> gerenciaDeAlugueis = aluguelDAO.carregarDadosAlugueis();
		for (Aluguel aluguel : gerenciaDeAlugueis) {
			if (aluguel.getLivro().getTitulo().equals(livro)) {
				return aluguel;
			}
		}
		return null;
	}

}
