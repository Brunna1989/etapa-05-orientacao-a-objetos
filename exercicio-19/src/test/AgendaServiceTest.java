package test;

import model.Contato;
import org.junit.jupiter.api.Test;
import service.AgendaService;
import exception.ContatoExistenteException;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class AgendaServiceTest {

    @Test
    public void deveAdicionarContatoComSucesso() throws ContatoExistenteException {
        AgendaService agenda = new AgendaService();
        Contato c = new Contato("João", "11 9999-9999");
        agenda.adicionarContato(c);
        assertTrue(agenda.listarContatos().contains(c));
    }

    @Test
    public void naoDeveAdicionarContatoDuplicado() throws ContatoExistenteException {
        AgendaService agenda = new AgendaService();
        Contato c1 = new Contato("Maria", "11 1234-5678");
        Contato c2 = new Contato("Maria", "11 1234-5678");
        agenda.adicionarContato(c1);

        ContatoExistenteException ex = assertThrows(ContatoExistenteException.class, () -> {
            agenda.adicionarContato(c2);
        });

        assertEquals("Contato ou número já cadastrado.", ex.getMessage());
    }

    @Test
    public void deveRemoverContatoComSucesso() throws ContatoExistenteException {
        AgendaService agenda = new AgendaService();
        Contato c = new Contato("Lucas", "21 2222-2222");
        agenda.adicionarContato(c);
        agenda.removerContato(c);
        assertFalse(agenda.listarContatos().contains(c));
    }

    @Test
    public void listaDeveEstarOrdenadaAlfabeticamente() throws ContatoExistenteException {
        AgendaService agenda = new AgendaService();
        agenda.adicionarContato(new Contato("Zeca", "11 1111-1111"));
        agenda.adicionarContato(new Contato("Ana", "22 2222-2222"));

        Set<Contato> ordenados = agenda.listarContatos();
        assertEquals("Ana", ordenados.iterator().next().getNome());
    }
}
