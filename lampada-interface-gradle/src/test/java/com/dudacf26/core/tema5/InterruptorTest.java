package com.dudacf26.core.tema5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.dudacf26.core.tema5.Interruptor;

public class InterruptorTest {
	@Test
	public void verificarSeLampadaLedEstaLigada() {
		LampadaLed led = new LampadaLed();
		Interruptor interruptor = new Interruptor(led);
		interruptor.trocar();
		assertTrue(interruptor.verificarSeEstaLigada());
	}

	@Test
	public void verificarSeLampadaLedEstaDesligada() {
		LampadaLed led = new LampadaLed();
		Interruptor interruptor = new Interruptor(led);
		assertFalse(interruptor.verificarSeEstaLigada());
	}

	@Test
	public void verificarSeLampadaFluorescenteEstaLigada() {
		LampadaFluorescente fluorescente = new LampadaFluorescente();
		Interruptor interruptor = new Interruptor(fluorescente);
		interruptor.trocar();
		assertTrue(interruptor.verificarSeEstaLigada());
	}

	@Test
	public void verificarSeLampadaFluorescenteEstaDesligada() {
		LampadaFluorescente fluorescente = new LampadaFluorescente();
		Interruptor interruptor = new Interruptor(fluorescente);
		assertFalse(interruptor.verificarSeEstaLigada());
	}

	@Test
	public void verificarTrocaDeEstadoLigaDesliga() {
		Lampada lampadaLed = new LampadaLed();
		Interruptor interruptorLed = new Interruptor(lampadaLed);

		assertEquals(true, interruptorLed.verificarSeEstaLigada());
		interruptorLed.trocar();
		assertEquals(false, interruptorLed.verificarSeEstaLigada());
	}
}