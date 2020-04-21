package com.dudacf26.core.tema5;

public class LampadaLed implements Lampada {
	@Override
	public void liga() {
		System.out.println("A Lampada LED está ligada ");
	}

	@Override
	public void desliga() {
		System.out.println("A Lampada LED está desligada ");
	}
}
