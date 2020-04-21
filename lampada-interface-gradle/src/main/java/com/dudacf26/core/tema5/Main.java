package com.dudacf26.core.tema5;

public class Main {

	public static void main(String[] args) {

		LampadaFluorescente lampflu = new LampadaFluorescente();
		LampadaLed lampled = new LampadaLed();
		Interruptor LigaFluorescente = new Interruptor(lampflu);
		Interruptor LigaLed = new Interruptor(lampled);
		LigaFluorescente.trocar();
		LigaLed.trocar();
	}
}
