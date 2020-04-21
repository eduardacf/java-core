package com.dudacf26.core.tema8;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;

import com.dudacf26.core.tema8.controller.Biblioteca;
import com.dudacf26.core.tema8.controller.AluguelController;
import com.dudacf26.core.tema8.controller.PessoaController;

public class AluguelControllerTest {
	@Test
	public void testaAlugarLivro() {
		AluguelController aluguel = new AluguelController();
		PessoaController pessoas = new PessoaController();
		Biblioteca biblioteca = new Biblioteca();
		
		biblioteca.adicionarLivro("Duda1", "Deus");
		pessoas.adicionarPessoa("Duda");
		aluguel.alugarLivro(pessoas.buscarPessoaPorId(1),biblioteca.buscarLivroPorId(1));
		assertEquals(1, aluguel.listarTodosOsAlugueis().size());
	}
	
	@Test
	  public void testaRenovarAluguel() {
			
		AluguelController aluguel = new AluguelController();
		PessoaController pessoas = new PessoaController();
		Biblioteca biblioteca = new Biblioteca();
		
		biblioteca.adicionarLivro("Duda1", "Deus");
		pessoas.adicionarPessoa("Duda");
		aluguel.alugarLivro(pessoas.buscarPessoaPorId(1),biblioteca.buscarLivroPorId(1));
		aluguel.renovarLivro("Duda1", 1);
		assertEquals(LocalDate.now().plusDays(14),aluguel.buscarAluguel(biblioteca.buscarLivroPorId(1)).getPrazo());

}
	

	@Test
	public void testarDevolverAluguel() {
		AluguelController aluguel = new AluguelController();
		PessoaController pessoas = new PessoaController();
		Biblioteca biblioteca = new Biblioteca();
		
		biblioteca.adicionarLivro("Duda1", "Deus");
		pessoas.adicionarPessoa("Duda");
		aluguel.alugarLivro(pessoas.buscarPessoaPorId(1),biblioteca.buscarLivroPorId(1));

		aluguel.devolverLivro(biblioteca.buscarLivroPorId(1));

		assertEquals(0, aluguel.listarTodosOsAlugueis().size());
		
	}
	
	@Test
	public void testaLivrosAlugados() {
		AluguelController aluguel = new AluguelController();
		PessoaController pessoas = new PessoaController();
		Biblioteca biblioteca = new Biblioteca();
		
		biblioteca.adicionarLivro("Duda1", "Deus");
		pessoas.adicionarPessoa("Duda");
		aluguel.alugarLivro(pessoas.buscarPessoaPorId(1),biblioteca.buscarLivroPorId(1));
		assertEquals(1,aluguel.listarTodosOsAlugueis().size());
	}
}
