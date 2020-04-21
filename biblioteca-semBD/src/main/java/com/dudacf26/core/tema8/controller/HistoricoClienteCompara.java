package com.dudacf26.core.tema8.controller;

import java.util.Comparator;

import com.dudacf26.core.tema8.dominio.Pessoa;

public class HistoricoClienteCompara implements Comparator<Pessoa> {
	@Override
	public int compare(Pessoa c1, Pessoa c2) {
		return c2.getHistoricoDosLivrosQueAluga() - c1.getHistoricoDosLivrosQueAluga();
	}
}
