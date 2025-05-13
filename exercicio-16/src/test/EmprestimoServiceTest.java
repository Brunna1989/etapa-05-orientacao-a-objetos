package test;

import exception.LivroJaEmprestadoException;
import model.Emprestimo;
import model.Livro;
import model.Pessoa;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.EmprestimoService;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class EmprestimoServiceTest {

    private EmprestimoService service;
    private Pessoa pessoa;
    private Livro livro;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() {
        service = new EmprestimoService();
        pessoa = new Pessoa("João");
        livro = new Livro("Java Básico");
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testEmprestimoBemSucedido() {
        Emprestimo emprestimo = service.realizarEmprestimo(pessoa, livro);
        assertNotNull(emprestimo);
        assertEquals("João", emprestimo.getPessoa().getNome());
        assertEquals("Java Básico", emprestimo.getLivro().getTitulo());
        assertTrue(livro.isEmprestado());
    }

    @Test(expected = LivroJaEmprestadoException.class)
    public void testEmprestimoDeLivroJaEmprestado() {
        livro.setEmprestado(true);
        service.realizarEmprestimo(pessoa, livro);
    }

    @Test
    public void testDevolucaoBemSucedida() {
        livro.setEmprestado(true);
        service.devolverLivro(livro);
        assertFalse(livro.isEmprestado());
        assertTrue(outContent.toString().contains("devolvido com sucesso"));
    }

    @Test
    public void testDevolucaoDeLivroDisponivel() {
        livro.setEmprestado(false);
        service.devolverLivro(livro);
        assertFalse(livro.isEmprestado());
        assertTrue(outContent.toString().contains("já está disponível"));
    }

    @Test
    public void testEmprestimoEDevolucaoCombinados() {
        Emprestimo emprestimo = service.realizarEmprestimo(pessoa, livro);
        assertTrue(livro.isEmprestado());

        service.devolverLivro(livro);
        assertFalse(livro.isEmprestado());
        assertTrue(outContent.toString().contains("devolvido com sucesso"));
    }

    @Test
    public void testLivroNaoAlteradoSeDevolucaoInvalida() {
        livro.setEmprestado(false);
        service.devolverLivro(livro);
        assertFalse(livro.isEmprestado());
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
    }
}
