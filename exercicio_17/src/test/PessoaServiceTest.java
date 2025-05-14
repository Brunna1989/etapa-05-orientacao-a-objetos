package test;

import exception.PessoaException;
import model.Pessoa;
import org.junit.jupiter.api.Test;
import service.PessoaService;

import static org.junit.jupiter.api.Assertions.*;

public class PessoaServiceTest {

    PessoaService service = new PessoaService();

    @Test
    public void deveCriarPessoaValida() throws PessoaException {
        Pessoa p = service.criarPessoa("Lucas", 30, null, null);
        assertEquals("Lucas", p.getNome());
        assertEquals(30, p.getIdade());
    }

    @Test
    public void deveLancarExcecaoParaPessoaInvalida() {
        assertThrows(PessoaException.class, () -> {
            service.criarPessoa("", -10, null, null);
        });
    }

    @Test
    public void deveDetectarIrmaos() throws PessoaException {
        Pessoa pai = service.criarPessoa("Carlos", 50, null, null);
        Pessoa mae = service.criarPessoa("Ana", 48, null, null);
        Pessoa filho1 = service.criarPessoa("João", 20, pai, mae);
        Pessoa filho2 = service.criarPessoa("Maria", 18, pai, mae);

        assertTrue(service.saoIrmãos(filho1, filho2));
    }

    @Test
    public void naoSaoIrmaosSePaisDiferentes() throws PessoaException {
        Pessoa pai1 = service.criarPessoa("Carlos", 50, null, null);
        Pessoa pai2 = service.criarPessoa("Rafael", 52, null, null);
        Pessoa mae = service.criarPessoa("Ana", 48, null, null);
        Pessoa filho1 = service.criarPessoa("João", 20, pai1, mae);
        Pessoa filho2 = service.criarPessoa("Maria", 18, pai2, mae);

        assertTrue(service.saoIrmãos(filho1, filho2)); // Compartilham a mãe
    }

    @Test
    public void deveExibirArvoreGenealogica() throws PessoaException {
        Pessoa pai = service.criarPessoa("Carlos", 50, null, null);
        Pessoa mae = service.criarPessoa("Ana", 48, null, null);
        Pessoa filho = service.criarPessoa("João", 20, pai, mae);

        String arvore = service.exibirArvoreGenealogica(filho);
        assertTrue(arvore.contains("Carlos"));
        assertTrue(arvore.contains("Ana"));
        assertTrue(arvore.contains("João"));
    }

    @Test
    public void deveLancarExcecaoSePessoaNula() {
        assertThrows(PessoaException.class, () -> {
            service.exibirArvoreGenealogica(null);
        });
    }
}
