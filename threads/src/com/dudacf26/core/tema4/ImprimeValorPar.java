package com.dudacf26.core.tema4;

public class ImprimeValorPar implements Runnable {

	@Override
	public void run() {
		GeradorNumerico numeroGerado = new GeradorNumerico();
		try {
			while (true) {
				System.out.println("(THREAD B) PAR : " + numeroGerado.gerarPar());
				Thread.sleep(500);
			}
		} catch (InterruptedException ex) {
			System.out.println("Interrupcao!");
		}
	}
}