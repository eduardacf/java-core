package com.dudacf26.core.tema5;

public class LampadaFluorescente implements Lampada {
	 @Override
	    public void liga(){
	        System.out.println("A Lampada Fluorescente está ligada ");
	    }
	    @Override
	    public void desliga() {
	        System.out.println("A Lampada Fluorescente está desligada ");
	}
}
