package com.dudacf26.core.tema10.Main;

import java.util.List;
import java.util.Scanner;

import com.dudacf26.core.tema10.DAO.ContatoDao;
import com.dudacf26.core.tema10.DOMAIN.Contato;

public class Menu {
	private Scanner ler = new Scanner(System.in);
	private static ContatoDao contatos = new ContatoDao();

	public void iniciaPrograma() {
		while (true) {
			System.out.println("\n ----------------- Agenda de contato -----------------");

			System.out.println("1 - Adicionar um contato");
			System.out.println("2 - Listar todos contatos");
			System.out.println("3 - Buscar um contato pelo nome");
			System.out.println("4 - Buscar um contato pela id");
			System.out.println("5 - Remover um contato");
			System.out.println("6 - Listar e ordenar por nome");
			System.out.println("7 - Listar e ordenar por ID");
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
			case 6:
				ordenarPorNome();
				break;
			case 7:
				ordenarPorID();
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

	private void ordenarPorID() {

		List<Contato> todosContatosPorId = contatos.ordenaContatos("id");

		if (todosContatosPorId.size() != 0)
			for (Contato contatoId : todosContatosPorId) {
				System.out.println(contatoId.toString());
			}
		else {
			System.out.println("Contato não encontrado.");
		}
	}

	private void ordenarPorNome() {

		List<Contato> todosContatosPorNome = contatos.ordenaContatos("nome");

		if (todosContatosPorNome.size() != 0)
			for (Contato contatoNome : todosContatosPorNome) {
				System.out.println(contatoNome.toString());
			}
		else {
			System.out.println("Contato não encontrado.");
		}
	}

	public void cadastra() {
		System.out.println("Informe o nome do contato:\n");
		Scanner nomeRecebido = new Scanner(System.in);
		String lendoNome = nomeRecebido.nextLine();

		System.out.println("Informe o Email do contato:\n");
		Scanner EmailRecebido = new Scanner(System.in);
		String lendoEmail = EmailRecebido.nextLine();

		System.out.println("Informe o Telefone do contato:\n");
		Scanner TelefoneRecebido = new Scanner(System.in);
		String lendoTelefone = TelefoneRecebido.nextLine();

		contatos.adicionarCont(new Contato(lendoNome, lendoEmail, lendoTelefone));
		System.out.println("Contato Adicionado com sucesso :) \n");
	}

	public static void removerCont() {
		System.out.println("Informe o Id do contato:\n ");
		Scanner idRecebido = new Scanner(System.in);
		int lerId = idRecebido.nextInt();
		contatos.removerCont(lerId);
		System.out.println("Contato removido com sucesso :) \n");
	}

	public void verlista() {
		System.out.println("Listando Contatos ...");
		System.out.println(contatos.listarContatos());
	}

	public void buscarContatoPorNome() {
		System.out.println("Informe o nome do contato:\n ");
		Scanner nomeRecebido = new Scanner(System.in);
		String lendoNome = nomeRecebido.nextLine();
		System.out.println("Buscando contatos pelo nome ...");
		System.out.println(contatos.buscarContatoPorNome(lendoNome));
	}

	public void buscarContatoPorId() {
		System.out.println("Informe o ID do contato:\n ");
		Scanner idRecebido = new Scanner(System.in);
		int lendoId = idRecebido.nextInt();
		System.out.println("Buscando contatos por ID ...");
		System.out.println(contatos.buscarContatoPorId(lendoId));
	}
}
