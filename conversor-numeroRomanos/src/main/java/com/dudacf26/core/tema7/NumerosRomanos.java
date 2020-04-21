package com.dudacf26.core.tema7;

import java.util.LinkedHashMap;
import java.util.Map;

public class NumerosRomanos {

	private final Map<String, Integer> dicionarioRomano = new LinkedHashMap<String, Integer>();

	public NumerosRomanos() {
		dicionarioRomano.put("X", 10);
		dicionarioRomano.put("V", 5);
		dicionarioRomano.put("I", 1);
	}

	public int transformaParaNumeroInteiro(String numeroRomano) {
		numeroRomano = numeroRomano.toUpperCase();
		int soma = 0;
		int maiorValorVisto = 0;
		for (int i = numeroRomano.length() - 1; i >= 0; i--) {
			char caracter = numeroRomano.charAt(i);
			int valorAtual = dicionarioRomano.get("" + caracter);
			if (valorAtual < maiorValorVisto) {
				soma -= valorAtual;
			} else {
				soma += valorAtual;
				maiorValorVisto = valorAtual;
			}
		}
		if (testarIntervalo(soma)) {
			return soma;
		}
		return 0;
	}

	public boolean testarIntervalo(int soma) {
		if (soma < 1 || soma > 21) {
			return false;
		}
		return true;
	}
}
