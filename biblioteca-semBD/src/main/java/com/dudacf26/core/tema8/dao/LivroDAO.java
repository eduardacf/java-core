package com.dudacf26.core.tema8.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.dudacf26.core.tema8.dominio.Livro;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class LivroDAO {

	public void salvarDadosDosLivros(List<Livro> livros) {

		Gson gson = new Gson();
		String json = gson.toJson(livros);

		try (FileWriter writer = new FileWriter("Livros.json")) {

			writer.write(json);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Livro> carregarDadosDosLivros() {

		Type typeFound = new TypeToken<ArrayList<Livro>>() {
		}.getType();

		try (BufferedReader jsonReader = new BufferedReader(new FileReader("Livros.json"))) {

			List<Livro> listLivros = new Gson().fromJson(jsonReader, typeFound);
			return listLivros;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ArrayList<Livro>();
	}
}
