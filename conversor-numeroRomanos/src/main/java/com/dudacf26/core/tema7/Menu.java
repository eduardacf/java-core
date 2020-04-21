package com.dudacf26.core.tema7;

import java.util.Scanner;

public class Menu {

	private NumerosInteiros numeroInteiro = new NumerosInteiros();
	private NumerosRomanos numeroRomano = new NumerosRomanos();
	private Scanner ler = new Scanner(System.in);
	private Scanner romanoRecebido;
	private Scanner inteiroRecebido;

	public void iniciaPrograma() {
		while (true) {
			try {
				System.out.println(
						"\n ----------------- Conversor de Numeros Romanos para Inteiros e Vice-versa :) -----------------");
				System.out.println("1 - Converter Inteiro para Romano");
				System.out.println("2 - Converter Romano para Inteiro");
				System.out.println("0 - Sair");

				System.out.println("Entre a opcao desejada:");
				int opcao = ler.nextInt();

				switch (opcao) {
				case 1:
					converterParaRomano();
					break;
				case 2:
					converterParaInteiro();
					break;
				case 0:
					System.out.println("Finalizando programa ... !\n ");
					System.exit(0);
					break;
				default:
					System.out.println("Opcao digitada invalida!\n ");
				}
			} catch (Exception erro) {
				System.out.println("Erro! Dados Invalidos, tente novamente :)");

			}

		}

	}

	private void converterParaInteiro() {
		System.out.println("Digite um numero romano:\n");
		romanoRecebido = new Scanner(System.in);
		String lerNumeroRomano = romanoRecebido.nextLine();
		if (numeroRomano.transformaParaNumeroInteiro(lerNumeroRomano) == 0) {
			System.out.println("Numero fora do intervalo permitido :(");
		} else {
			System.out.println("O Valor " + lerNumeroRomano + " em conversao para Inteiro fica: "
					+ numeroRomano.transformaParaNumeroInteiro(lerNumeroRomano) + "\n");
		}
	}

	private void converterParaRomano() {
		System.out.println("Digite um numero Inteiro:\n");
		inteiroRecebido = new Scanner(System.in);
		int lerNumeroInteiro = inteiroRecebido.nextInt();
		if (lerNumeroInteiro > 20 || lerNumeroInteiro < 1) {
			System.out.println("Numero fora do intervalo permitido :(");
		} else {
			System.out.println("O Valor " + lerNumeroInteiro + " em conversao para ROMANO fica: "
					+ numeroInteiro.transformaParaNumeroRomano(lerNumeroInteiro) + "\n");
		}
	}
}
