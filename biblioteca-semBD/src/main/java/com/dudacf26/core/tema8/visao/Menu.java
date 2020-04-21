package com.dudacf26.core.tema8.visao;

import java.util.List;
import java.util.Scanner;

import com.dudacf26.core.tema8.controller.Biblioteca;
import com.dudacf26.core.tema8.controller.AluguelController;
import com.dudacf26.core.tema8.controller.PessoaController;
import com.dudacf26.core.tema8.dominio.Livro;

public class Menu {
	private AluguelController aluguel = new AluguelController(null);
	private Biblioteca biblioteca = new Biblioteca();
	private PessoaController pessoas = new PessoaController();
	private Scanner ler = new Scanner(System.in);
	  
	 
	public void iniciaPrograma() {
		while (true) {
			System.out.println("\n \nSeja bem vindo(a) ao nosso sistema de Empréstimo de livros :D \n");

			System.out.println("Menu:\n" + "1  - Cadastrar um Livro\n" + "2  - Cadastrar cliente\n"
					+ "3  - Listar clientes" + "\n4  - Listar todos os Livros\n" + "5  - Pesquisar por Autor\n"
					+ "6  - Pesquisar por Titulo\n" + "7  - Excluir um Livro do sistema\n" + "8  - Alugar livro\n"
					+ "9  - Devolver Livros\n" + "10  - Renovar Livro\n" + "11  - Listar Livros Alugados\n"
					+ "12 - Listar Top 10 Clientes que mais alocam livros\n" + "13 - Listar Livros Atrasados\n"
					+ "0  - Sair");

			System.out.println("\nDigite a opção de sua preferência:");
			int opcao = ler.nextInt();

			switch (opcao) {
			case 1:
				cadastrarLivro();
				break;
			case 2:
				cadastrarCliente();
				break;
			case 3:
				listarClientes();
				break;
			case 4:
				listarTodosOsLivros();
				break;
			case 5:
				buscarPorNome();
				break;
			case 6:
				buscarPorTitulo();
				break;
			case 7:
				excluirLivro();
				break;
			case 8:
				alugarLivro();
				break;
			case 9:
				devolveLivro();
				break;
			case 10:
				renovaLivro();
				break;
			case 11:
				livrosAlugados();
				break;
			case 12:
				top10();
				break;
			case 13:
				livrosAtrasados();
				break;
			case 0:
				System.out.println("Obrigada por ter usado nosso sistema de Empréstimos de Livros :D !\n ");
				System.out.println("Programa finalizado :( \n ");
				System.exit(0);
				break;
			default:
				System.out.println("Opção digitada é inválida!\n ");
			}
		}
	}

	private void renovaLivro() {

		int lendoId = 0;
		int lendoPrazo = 0;
		String lendoTitulo = "";

		try {
			System.out.println("Informe o titulo do Livro que deseja renovar:\n ");
			Scanner tituloRecebido = new Scanner(System.in);
			lendoTitulo = tituloRecebido.nextLine();

			System.out.println("Informe o Id do Livro que deseja renovar:\n ");
			Scanner idRecebido = new Scanner(System.in);
			lendoId = idRecebido.nextInt();

		} catch (Exception erro) {
			System.out.println("Você digitou algum campo abaixo incorreto ou inválido: \n" + "- Titulo do Livro\n"
					+ "- Dias de permanencia do Livro\n" + "- ID do Livro\n" + "!");
			System.out.println(
					"\nSe você quiser voltar para o menu anterior digite 1 , ou 2 para tentar renovar novamente:");
			int opcao = ler.nextInt();

			switch (opcao) {
			case 1:
				iniciaPrograma();
				break;
			case 2:
				renovaLivro();
				break;
			default:
				System.out.println("Opção digitada é inválida!\n ");
			}
		}

		aluguel.renovarLivro(lendoTitulo, lendoId);

	}

	private void devolveLivro() {
		int lendoId = 0;

		try {
			System.out.println("Informe o Id do Livro que deseja devolver:\n ");
			Scanner idRecebido = new Scanner(System.in);
			lendoId = idRecebido.nextInt();

		} catch (Exception erro) {
			System.out.println("Você digitou um ID incorreto ou inválido");

			System.out.println(
					"\nSe você quiser voltar para o menu anterior digite 1 , ou 2 para tentar devolver novamente:");
			int opcao = ler.nextInt();

			switch (opcao) {
			case 1:
				iniciaPrograma();
				break;
			case 2:
				devolveLivro();
				break;
			default:
				System.out.println("Opção digitada é inválida!\n ");
			}
		}

		aluguel.devolverLivro(biblioteca.buscarLivroPorId(lendoId));

	}

	private void livrosAtrasados() {
		System.out.println(aluguel.listarAtrasados());

	}

	private void top10() {
		System.out.println(pessoas.listarTopClientes());

	}

	private void cadastrarCliente() {
		String lendoNome = "";

		try {
			System.out.println("Informe o nome do usuário:\n");
			Scanner nomeRecebido = new Scanner(System.in);
			lendoNome = nomeRecebido.nextLine();

		} catch (Exception erro) {

			System.out.println("Você digitou um nome incorreto ou inválido");

			System.out.println(
					"\nSe você quiser voltar para o menu anterior digite 1 , ou 2 para tentar devolver novamente:");
			int opcao = ler.nextInt();

			switch (opcao) {
			case 1:
				iniciaPrograma();
				break;
			case 2:
				cadastrarCliente();
				break;
			default:
				System.out.println("Opção digitada é inválida!\n ");
			}
		}

		pessoas.adicionarPessoa(lendoNome);
		System.out.println("Cliente Adicionado com sucesso :) \n");

	}

	private void listarClientes() {

		System.out.println(pessoas.listarTodosOsClientes());
	}

	private void livrosAlugados() {
		System.out.print(aluguel.listarTodosOsAlugueis());
	}

	private void alugarLivro() {
		String lendoTitulo = "";
		int lendoId = 0;
		try {
			System.out.println("Informe o titulo do livro que deseja alugar:\n ");
			Scanner tituloRecebido = new Scanner(System.in);
			lendoTitulo = tituloRecebido.nextLine();

			System.out.println("Informe o ID do usuário:\n ");
			Scanner idRecebido = new Scanner(System.in);
			lendoId = idRecebido.nextInt();

		} catch (Exception erro) {

			System.out.println("Você digitou algum campo abaixo incorreto ou inválido: \n" + "- Titulo do Livro\n"
					+ "- ID do Livro\n" + "!");
			System.out.println(
					"\nSe você quiser voltar para o menu anterior digite 1 , ou 2 para tentar devolver novamente:");
			int opcao = ler.nextInt();

			switch (opcao) {
			case 1:
				iniciaPrograma();
				break;
			case 2:
				alugarLivro();
				break;
			default:
				System.out.println("Opção digitada é inválida!\n ");
			}
		}
 
		aluguel.alugarLivro(pessoas.buscarPessoaPorId(lendoId), biblioteca.buscarLivroTitulo(lendoTitulo));

	}

	private void excluirLivro() {
		int lendoId = 0;
		try {
			System.out.println("Informe o Id do Livro que deseja excluir:\n ");
			Scanner idRecebido = new Scanner(System.in);
			lendoId = idRecebido.nextInt();

		} catch (Exception erro) {

			System.out.println("Você digitou um Id do livro inválido" + "!");
			System.out.println(
					"\nSe você quiser voltar para o menu anterior digite 1 , ou 2 para tentar devolver novamente:");
			int opcao = ler.nextInt();

			switch (opcao) {
			case 1:
				iniciaPrograma();
				break;
			case 2:
				alugarLivro();
				break;
			default:
				System.out.println("Opção digitada é inválida!\n ");
			}
		}
		biblioteca.excluirLivro(lendoId);

	}

	private void buscarPorTitulo() {
		String lendoTitulo = "";
		int lendoId = 0;
		try {
			System.out.println("Informe o titulo do livro que deseja alugar:\n ");
			Scanner tituloRecebido = new Scanner(System.in);
			lendoTitulo = tituloRecebido.nextLine();

		} catch (Exception erro) {
			System.out.println("Nenhum Título com esse nome foi encontrado :(");
		}

		biblioteca.buscarLivroTitulo(lendoTitulo);

	}

	private void buscarPorNome() {
		System.out.println("Informe o Autor do Livro:\n");
		Scanner autorRecebido = new Scanner(System.in);
		String lendoAutor = autorRecebido.nextLine();

		List<Livro> livrosEncontrados = biblioteca.buscarLivroPorAutor(lendoAutor);
		if (livrosEncontrados.size() != 0) {
			System.out.println("---------Livros do autor:" + lendoAutor + "---------");
			for (int i = 0; i < livrosEncontrados.size(); i++) {
				System.out.println(lendoAutor + livrosEncontrados.get(i).getTitulo());
			}
		} else {
			System.out.println("Nenhum Autor com esse nome foi encontrado :(");
		}
	}

	private void listarTodosOsLivros() {
		System.out.println(biblioteca.listarTodosOsLivros());
	}

	private void cadastrarLivro() {
		String lendoTitulo = "";
		String lendoAutor = "";
		try {
			System.out.println("Informe o título do Livro:\n");
			Scanner tituloRecebido = new Scanner(System.in);
			lendoTitulo = tituloRecebido.nextLine();

			System.out.println("Informe o autor do Livro:\n");
			Scanner autorRecebido = new Scanner(System.in);
			lendoAutor = autorRecebido.nextLine();
		} catch (Exception erro) {

			System.out.println("Você digitou algum campo abaixo incorreto ou inválido: \n" + "- Titulo do Livro\n"
					+ "- Autor do Livro\n" + "!");
			System.out.println(
					"\nSe você quiser voltar para o menu anterior digite 1 , ou 2 para tentar devolver novamente:");
			int opcao = ler.nextInt();

			switch (opcao) {
			case 1:
				iniciaPrograma();
				break;
			case 2:
				alugarLivro();
				break;
			default:
				System.out.println("Opção digitada é inválida!\n ");
			}
		}
		System.out.println("Livro " + lendoTitulo + " foi adicionado com sucesso :)");

		biblioteca.adicionarLivro(lendoTitulo, lendoAutor);

	}

}
