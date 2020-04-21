package com.dudacf26.core.tema5;

public class Interruptor {

	private Lampada lampada;
	private boolean ligada;

	public Interruptor(Lampada lampada) {
		this.lampada = lampada;
		this.ligada = false;
	}

	public void trocar() {
		if (ligada) {
			lampada.desliga();	  
            		ligada = false;
		} else {
			lampada.liga();
			ligada = true;
		}
	}
	public boolean verificarSeEstaLigada() {
		return ligada;
	}
}
