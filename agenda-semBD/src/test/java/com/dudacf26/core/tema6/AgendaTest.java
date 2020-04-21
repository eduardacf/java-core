package com.dudacf26.core.tema6;


import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;

public class AgendaTest {

	@Test
	public void testarAdicionarContato() {
		Agenda agenda = new Agenda();
		agenda.adicionarCont("Eduarda");
		assertEquals("Eduarda", agenda.listarContatos().get(0).getNome());

	}

	@Test
	public void testarRemoverContato() {
		Agenda agenda = new Agenda();
		agenda.adicionarCont("Eduarda");
		agenda.adicionarCont("Pedro");

		agenda.removerCont(1);

		assertEquals(1, agenda.listarContatos().size());

	}

	@Test
	public void testarSeListaTodosOsContatos() {
		Agenda agenda = new Agenda();
		agenda.adicionarCont("Eduarda");
		agenda.adicionarCont("Pedro");
		assertEquals(2, agenda.listarContatos().size());
	}

	@Test
	public void testeBuscaPorNome() {
		Agenda agenda = new Agenda();
		agenda.adicionarCont("Eduarda");
		agenda.adicionarCont("Leo");

		List<Contato> contatoEncontrado = agenda.buscarContatoPorNome("Eduarda");
		int contaContatosEncontrados = contatoEncontrado.size();
		assertEquals(1, contaContatosEncontrados);
	}

	@Test
	public void testeBuscaPorID() {

		Agenda agenda = new Agenda();
		agenda.adicionarCont("Eduarda");
		agenda.adicionarCont("Leo");

		Contato contato = agenda.buscarContatoPorId(2);

		assertEquals(2, contato.getId());
	}

}
