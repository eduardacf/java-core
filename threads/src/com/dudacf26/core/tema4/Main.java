package com.dudacf26.core.tema4;

public class Main {

	public static void main(String[] args) {

		ImprimeValorImpar imprimevalorimpar = new ImprimeValorImpar();
		ImprimeValorPar imprimeValorPar = new ImprimeValorPar();

		Thread threadValorImpar = new Thread(imprimevalorimpar);
		Thread threadValorPar = new Thread(imprimeValorPar);

		threadValorImpar.start();
		threadValorPar.start();
	}
}