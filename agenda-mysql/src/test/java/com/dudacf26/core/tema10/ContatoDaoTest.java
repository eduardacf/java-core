package com.dudacf26.core.tema10;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.Test;

import com.dudacf26.core.tema10.DAO.ContatoDao;
import com.dudacf26.core.tema10.DOMAIN.Contato;

public class ContatoDaoTest {
	@Test
	public void testarAdicionarContato() {
		ContatoDao contatos = new ContatoDao();
		Contato pessoa = new Contato("Eduarda", "eduarda.ferreira@ilegra.com", "3333");
		assertEquals(true, contatos.adicionarCont(pessoa));
	}

	@Test
	public void testarRemoverContato() {
		ContatoDao contatos = new ContatoDao();
		Contato pessoa = new Contato("Eduarda", "eduarda.ferreira@ilegra.com", "3333");
		contatos.adicionarCont(pessoa);
		contatos.removerCont(1);
		assertEquals(true, contatos.listarContatos());
	}

	@Test
	public void testaBuscarPorNome() {
		ContatoDao contatos = new ContatoDao();
		Contato pessoa = new Contato("Eduarda", "eduarda.ferreira@ilegra.com", "3333");
		contatos.adicionarCont(pessoa);
		assertEquals(true, contatos.buscarContatoPorNome("Eduarda"));
	}

	@Test
	public void testaBuscaPorID() {
		ContatoDao contatos = new ContatoDao();
		Contato pessoa = new Contato("Eduarda", "eduarda.ferreira@ilegra.com", "3333");
		contatos.adicionarCont(pessoa);
		assertEquals(true, contatos.buscarContatoPorId(1));
	}

	@Test
	public void testaListarContatos() {
		ContatoDao contatos = new ContatoDao();
		Contato pessoa = new Contato("Eduarda", "eduarda.ferreira@ilegra.com", "3333");
		contatos.adicionarCont(pessoa);
		assertEquals(true, contatos.listarContatos());
	}

}
