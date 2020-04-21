package com.dudacf26.core.tema8.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.dudacf26.core.tema8.dominio.Pessoa;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class PessoaDAO {

	public void salvarDadosDasPessoas(List<Pessoa> pessoas) {

		Gson gson = new Gson();
		String json = gson.toJson(pessoas);

		try (FileWriter writer = new FileWriter("Pessoas.json")) {

			writer.write(json);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Pessoa> carregarDadosDasPessoas() {

		Type typeFound = new TypeToken<ArrayList<Pessoa>>() {
		}.getType();

		try (BufferedReader jsonReader = new BufferedReader(new FileReader("Pessoas.json"))) {

			List<Pessoa> listPessoas = new Gson().fromJson(jsonReader, typeFound);
			return listPessoas;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ArrayList<Pessoa>();
	}
}