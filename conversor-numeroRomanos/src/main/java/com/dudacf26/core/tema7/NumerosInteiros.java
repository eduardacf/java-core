package com.dudacf26.core.tema7;

import java.util.LinkedHashMap;
import java.util.Map;

public class NumerosInteiros {

	private final Map<Integer, String> dicionarioInteiro = new LinkedHashMap<Integer, String>();

	public NumerosInteiros() {
		dicionarioInteiro.put(10, "X");
		dicionarioInteiro.put(9, "IX");
		dicionarioInteiro.put(5, "V");
		dicionarioInteiro.put(4, "IV");
		dicionarioInteiro.put(1, "I");
	}

	public String transformaParaNumeroRomano(int numeroInteiro) {
		String soma = "";
		int compara[] = { 10, 9, 5, 4, 1 };
		int i = 0;

		while (numeroInteiro > 0) {
			if (numeroInteiro >= compara[i]) {
				soma += dicionarioInteiro.get(compara[i]);
				numeroInteiro -= compara[i];
			} else {
				i++;
			}
		}
		return soma;
	}
}
