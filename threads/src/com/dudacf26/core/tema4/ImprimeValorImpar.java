package com.dudacf26.core.tema4;

public class ImprimeValorImpar implements Runnable {

	@Override
	public void run() {
		GeradorNumerico numeroGerado = new GeradorNumerico();
		try {
			while (true) {
				System.out.println("(THREAD A) IMPAR : " + numeroGerado.gerarImpar());
				Thread.sleep(100);
			}
		} catch (InterruptedException ex) {
			System.out.println("Interrupcao!");
		}
	}
}
