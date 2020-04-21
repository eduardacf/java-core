package com.dudacf26.core.tema4;

import java.util.Random;

public class GeradorNumerico {

	private Random gerandoNumeroAleatorio = new Random();

	public int gerarPar() {
		int num = gerandoNumeroAleatorio.nextInt(20);
		if (num % 2 == 0) {
			return num;
		} else {
			return gerarPar();
		}
	}

	public int gerarImpar() {
		int num = gerandoNumeroAleatorio.nextInt(20);
		if (num % 2 != 0) {
			return num;
		} else {
			return gerarImpar();
		}
	}
}
