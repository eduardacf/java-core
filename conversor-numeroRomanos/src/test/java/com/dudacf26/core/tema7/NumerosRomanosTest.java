package com.dudacf26.core.tema7;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

public class NumerosRomanosTest {

	@Test
	public void testeNumeroI() {
		NumerosRomanos numeroRomano = new NumerosRomanos();
		assertEquals(1, numeroRomano.transformaParaNumeroInteiro("I"));
	}

	@Test
	public void testeNumeroII() {
		NumerosRomanos numeroRomano = new NumerosRomanos();
		assertEquals(2, numeroRomano.transformaParaNumeroInteiro("II"));
	}

	@Test
	public void testeNumeroIII() {
		NumerosRomanos numeroRomano = new NumerosRomanos();
		assertEquals(3, numeroRomano.transformaParaNumeroInteiro("III"));
	}

	@Test
	public void testeNumeroIV() {
		NumerosRomanos numeroRomano = new NumerosRomanos();
		assertEquals(4, numeroRomano.transformaParaNumeroInteiro("IV"));
	}

	@Test
	public void testeNumeroV() {
		NumerosRomanos numeroRomano = new NumerosRomanos();
		assertEquals(5, numeroRomano.transformaParaNumeroInteiro("V"));
	}

	@Test
	public void testeNumeroVI() {
		NumerosRomanos numeroRomano = new NumerosRomanos();
		assertEquals(6, numeroRomano.transformaParaNumeroInteiro("VI"));
	}

	@Test
	public void testeNumeroVII() {
		NumerosRomanos numeroRomano = new NumerosRomanos();
		assertEquals(7, numeroRomano.transformaParaNumeroInteiro("VII"));
	}

	@Test
	public void testeNumeroVIII() {
		NumerosRomanos numeroRomano = new NumerosRomanos();
		assertEquals(8, numeroRomano.transformaParaNumeroInteiro("VIII"));
	}

	@Test
	public void testeNumeroIX() {
		NumerosRomanos numeroRomano = new NumerosRomanos();
		assertEquals(9, numeroRomano.transformaParaNumeroInteiro("IX"));
	}

	@Test
	public void testeNumeroX() {
		NumerosRomanos numeroRomano = new NumerosRomanos();
		assertEquals(10, numeroRomano.transformaParaNumeroInteiro("X"));
	}

	@Test
	public void testeNumeroXI() {
		NumerosRomanos numeroRomano = new NumerosRomanos();
		assertEquals(11, numeroRomano.transformaParaNumeroInteiro("XI"));
	}

	@Test
	public void testeNumeroXII() {
		NumerosRomanos numeroRomano = new NumerosRomanos();
		assertEquals(12, numeroRomano.transformaParaNumeroInteiro("XII"));
	}

	@Test
	public void testeNumeroXIII() {
		NumerosRomanos numeroRomano = new NumerosRomanos();
		assertEquals(13, numeroRomano.transformaParaNumeroInteiro("XIII"));
	}

	@Test
	public void testeNumeroXIV() {
		NumerosRomanos numeroRomano = new NumerosRomanos();
		assertEquals(14, numeroRomano.transformaParaNumeroInteiro("XIV"));
	}

	@Test
	public void testeNumeroXV() {
		NumerosRomanos numeroRomano = new NumerosRomanos();
		assertEquals(15, numeroRomano.transformaParaNumeroInteiro("XV"));
	}

	@Test
	public void testeNumeroXVI() {
		NumerosRomanos numeroRomano = new NumerosRomanos();
		assertEquals(16, numeroRomano.transformaParaNumeroInteiro("XVI"));
	}

	@Test
	public void testeNumeroXVII() {
		NumerosRomanos numeroRomano = new NumerosRomanos();
		assertEquals(17, numeroRomano.transformaParaNumeroInteiro("XVII"));
	}

	@Test
	public void testeNumeroXVIII() {
		NumerosRomanos numeroRomano = new NumerosRomanos();
		assertEquals(18, numeroRomano.transformaParaNumeroInteiro("XVIII"));
	}

	@Test
	public void testeNumeroXIX() {
		NumerosRomanos numeroRomano = new NumerosRomanos();
		assertEquals(19, numeroRomano.transformaParaNumeroInteiro("XIX"));
	}

	@Test
	public void testeNumeroXX() {
		NumerosRomanos numeroRomano = new NumerosRomanos();
		assertEquals(20, numeroRomano.transformaParaNumeroInteiro("XX"));
	}

}
