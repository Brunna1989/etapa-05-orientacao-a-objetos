package service;

import exception.LivroJaEmprestadoException;
import model.Emprestimo;
import model.Livro;
import model.Pessoa;

public class EmprestimoService {

    public Emprestimo realizarEmprestimo(Pessoa pessoa, Livro livro) {
        if (livro.isEmprestado()) {
            throw new LivroJaEmprestadoException("O livro \"" + livro.getTitulo() + "\" já está emprestado.");
        }
        livro.setEmprestado(true);
        return new Emprestimo(pessoa, livro);
    }

    public void devolverLivro(Livro livro) {
        if (!livro.isEmprestado()) {
            System.out.println("O livro \"" + livro.getTitulo() + "\" já está disponível.");
        } else {
            livro.setEmprestado(false);
            System.out.println("Livro \"" + livro.getTitulo() + "\" devolvido com sucesso.");
        }
    }
}
