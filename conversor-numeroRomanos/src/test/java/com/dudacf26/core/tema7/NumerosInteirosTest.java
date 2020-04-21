package com.dudacf26.core.tema7;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

public class NumerosInteirosTest {
     @Test
	public void testeNumero1() {
		NumerosInteiros numeroInteiro = new NumerosInteiros();
		assertEquals("I", numeroInteiro.transformaParaNumeroRomano(1));
	}

	@Test
	public void testeNumero2() {
		NumerosInteiros numeroInteiro = new NumerosInteiros();
		assertEquals("II", numeroInteiro.transformaParaNumeroRomano(2));
	}
	
	@Test
	public void testeNumero3() {
		NumerosInteiros numeroInteiro = new NumerosInteiros();
		assertEquals("III", numeroInteiro.transformaParaNumeroRomano(3));
	}

	@Test
	public void testeNumero4() {
		NumerosInteiros numeroInteiro = new NumerosInteiros();
		assertEquals("IV", numeroInteiro.transformaParaNumeroRomano(4));
	}
	
	@Test
	public void testeNumero5() {
		NumerosInteiros numeroInteiro = new NumerosInteiros();
		assertEquals("V", numeroInteiro.transformaParaNumeroRomano(5));
	}

	@Test
	public void testeNumero6() {
		NumerosInteiros numeroInteiro = new NumerosInteiros();
		assertEquals("VI", numeroInteiro.transformaParaNumeroRomano(6));
	}
	
	@Test
	public void testeNumero7() {
		NumerosInteiros numeroInteiro = new NumerosInteiros();
		assertEquals("VII", numeroInteiro.transformaParaNumeroRomano(7));
	}

	@Test
	public void testeNumero8() {
		NumerosInteiros numeroInteiro = new NumerosInteiros();
		assertEquals("VIII", numeroInteiro.transformaParaNumeroRomano(8));
	}
	@Test
	public void testeNumero9() {
		NumerosInteiros numeroInteiro = new NumerosInteiros();
		assertEquals("IX", numeroInteiro.transformaParaNumeroRomano(9));
	}

	@Test
	public void testeNumero10() {
		NumerosInteiros numeroInteiro = new NumerosInteiros();
		assertEquals("X", numeroInteiro.transformaParaNumeroRomano(10));
	}
	
	@Test
	public void testeNumero11() {
		NumerosInteiros numeroInteiro = new NumerosInteiros();
		assertEquals("XI", numeroInteiro.transformaParaNumeroRomano(11));
	}
	@Test
	public void testeNumero12() {
		NumerosInteiros numeroInteiro = new NumerosInteiros();
		assertEquals("XII", numeroInteiro.transformaParaNumeroRomano(12));
	}

	@Test
	public void testeNumero13() {
		NumerosInteiros numeroInteiro = new NumerosInteiros();
		assertEquals("XIII", numeroInteiro.transformaParaNumeroRomano(13));
	}
	
	@Test
	public void testeNumero14() {
		NumerosInteiros numeroInteiro = new NumerosInteiros();
		assertEquals("XIV", numeroInteiro.transformaParaNumeroRomano(14));
	}
	@Test
	public void testeNumero16() {
		NumerosInteiros numeroInteiro = new NumerosInteiros();
		assertEquals("XVI", numeroInteiro.transformaParaNumeroRomano(16));
	}

	@Test
	public void testeNumero17() {
		NumerosInteiros numeroInteiro = new NumerosInteiros();
		assertEquals("XVII", numeroInteiro.transformaParaNumeroRomano(17));
	}
	
	@Test
	public void testeNumero18() {
		NumerosInteiros numeroInteiro = new NumerosInteiros();
		assertEquals("XVIII", numeroInteiro.transformaParaNumeroRomano(18));
	}
	@Test
	public void testeNumero19() {
		NumerosInteiros numeroInteiro = new NumerosInteiros();
		assertEquals("XIX", numeroInteiro.transformaParaNumeroRomano(19));
	}
	
	@Test
	public void testeNumero20() {
		NumerosInteiros numeroInteiro = new NumerosInteiros();
		assertEquals("XX", numeroInteiro.transformaParaNumeroRomano(20));
	}

	@Test
	public void testeNumero15() {
		NumerosInteiros numeroInteiro = new NumerosInteiros();
		assertEquals("XV", numeroInteiro.transformaParaNumeroRomano(15));
	}


}