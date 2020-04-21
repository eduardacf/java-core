package com.dudacf26.core.tema6;

import java.util.Scanner;

public class Menu {

	private static Agenda agenda = new Agenda();
	private Scanner ler = new Scanner(System.in);
	int id = 1;

	public void iniciaPrograma() {
		while (true) {
			System.out.println("\n ----------------- Agenda de contato -----------------");

			System.out.println("1 - Adicionar um contato");
			System.out.println("2 - Listar todos contatos");
			System.out.println("3 - Buscar um contato pelo nome");
			System.out.println("4 - Buscar um contato pela id");
			System.out.println("5 - Remover um contato");
			System.out.println("0 - Sair");

			System.out.println("Entre a opção desejada:");
			int opcao = ler.nextInt();

			switch (opcao) {
			case 1:
				cadastra();
				break;
			case 2:
				verlista();
				break;
			case 3:
				buscarContatoPorNome();
				break;
			case 4:
				buscarContatoPorId();
				break;
			case 5:
				removerCont();
				break;
			case 0:
				System.out.println("Finalizando programa ... !\n ");
				System.exit(0);
				break;
			default:
				System.out.println("Opcao digitada inválida!\n ");
			}
		}
	}

	public void cadastra() {
		System.out.println("Informe o nome do contato:\n");
		Scanner nomeRecebido = new Scanner(System.in);
		String lendoNome = nomeRecebido.nextLine();

		agenda.adicionarCont(lendoNome);
		System.out.println("Contato Adicionado com sucesso :) \n");
	}

	public static void removerCont() {
		System.out.println("Informe o Id do contato:\n ");
		Scanner idRecebido = new Scanner(System.in);
		int lerId = idRecebido.nextInt();
		agenda.removerCont(lerId);
		System.out.println("Contato removido com sucesso :) \n");
	}

	public void verlista() {
		System.out.println(agenda.listarContatos());
	}

	public void buscarContatoPorNome() {
		System.out.println("Informe o nome do contato:\n ");
		Scanner nomeRecebido = new Scanner(System.in);
		String lendoNome = nomeRecebido.nextLine();
		System.out.println(agenda.buscarContatoPorNome(lendoNome));
	}

	public void buscarContatoPorId() {
		System.out.println("Informe o ID do contato:\n ");
		Scanner idRecebido = new Scanner(System.in);
		int lendoId = idRecebido.nextInt();
		System.out.println(agenda.buscarContatoPorId(lendoId));
	}
}
