package com.dudacf26.core.tema8;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import java.util.List;
import org.junit.jupiter.api.Test;

import com.dudacf26.core.tema8.controller.Biblioteca;
import com.dudacf26.core.tema8.controller.PessoaController;
import com.dudacf26.core.tema8.dominio.Livro;
import com.dudacf26.core.tema8.dominio.Pessoa;

public class PessoaControllerTest {

	@Test
	public void testaAdicionarPessoas() {
		PessoaController pessoa = new PessoaController();

		pessoa.adicionarPessoa("Eduarda");
		List<Pessoa> pessoas = pessoa.listarTodosOsClientes();
		assertFalse(pessoas.isEmpty());
	}

	public void testaSeListaTodosOsClientes() {
		PessoaController pessoa = new PessoaController();

		pessoa.adicionarPessoa("Eduarda");
		assertEquals(1, pessoa.listarTodosOsClientes().size());

	}

	@Test
	public void testaTop10() {
		Biblioteca biblioteca = new Biblioteca();
		PessoaController pessoa = new PessoaController();

		for (int i = 1; i <= 20; i++) {
			biblioteca.adicionarLivro("Oi Sou a Duda :D " + i, "p");
		}
		for (int i = 1; i <= 20; i++) {
			pessoa.adicionarPessoa("Nome" + i);
		}

		List<Livro> livros = biblioteca.listarTodosOsLivros();
		List<Pessoa> pessoas = pessoa.listarTodosOsClientes();

		aluguel.alugarLivro(pessoas.buscarPessoaPorId(1), biblioteca.buscarLivroPorId(1));
		aluguel.alugarLivro(pessoas.buscarPessoaPorId(2), biblioteca.buscarLivroPorId(4));
		aluguel.alugarLivro(pessoas.buscarPessoaPorId(3), biblioteca.buscarLivroPorId(6));
		aluguel.alugarLivro(pessoas.buscarPessoaPorId(4), biblioteca.buscarLivroPorId(10));

		String topUsuario = pessoa.listarTopClientes();
		assertEquals(10, topUsuario.size());
		assertEquals("Nome4", topUsuario.get(0).getNome());
	}
}
