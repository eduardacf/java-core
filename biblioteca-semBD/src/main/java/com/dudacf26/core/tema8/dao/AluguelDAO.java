package com.dudacf26.core.tema8.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.dudacf26.core.tema8.dominio.Aluguel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import com.google.gson.GsonBuilder;

public class AluguelDAO {

	public void salvarDadosAlugueis(List<Aluguel> alugueis) {

		Gson gson = new Gson();
		String json = gson.toJson(alugueis);
		


		try (FileWriter writer = new FileWriter("Aluguel.json")) {

			writer.write(json);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Aluguel> carregarDadosAlugueis() {

		Type typeFound = new TypeToken<ArrayList<Aluguel>>() {
		}.getType();

		try (BufferedReader jsonReader = new BufferedReader(new FileReader("Aluguel.json"))) {

			List<Aluguel> listAlugueis = new Gson().fromJson(jsonReader, typeFound);
			return listAlugueis;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ArrayList<Aluguel>();
	}
}
