import model.Livro;
import model.Pessoa;
import model.Emprestimo;
import service.EmprestimoService;
import exception.LivroJaEmprestadoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmprestimoService service = new EmprestimoService();
        List<Livro> livrosRegistrados = new ArrayList<>();

        System.out.println("=== Sistema de Empréstimo de Livros ===");

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n[1] Realizar empréstimo");
            System.out.println("[2] Devolver livro");
            System.out.println("[0] Sair");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.print("Digite o nome da pessoa: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite o título do livro: ");
                    String titulo = scanner.nextLine();

                    Livro livro = encontrarLivro(livrosRegistrados, titulo);
                    if (livro == null) {
                        livro = new Livro(titulo);
                        livrosRegistrados.add(livro);
                    }

                    Pessoa pessoa = new Pessoa(nome);

                    try {
                        Emprestimo emprestimo = service.realizarEmprestimo(pessoa, livro);
                        System.out.println("✅ Empréstimo realizado com sucesso!");
                        System.out.println("Pessoa: " + emprestimo.getPessoa().getNome());
                        System.out.println("Livro: " + emprestimo.getLivro().getTitulo());
                        System.out.println("Data: " + emprestimo.getDataEmprestimo());
                    } catch (LivroJaEmprestadoException e) {
                        System.out.println("⚠️ Erro: " + e.getMessage());
                    }
                    break;

                case "2":
                    System.out.print("Digite o título do livro a ser devolvido: ");
                    String tituloDevolver = scanner.nextLine();

                    Livro livroDevolver = encontrarLivro(livrosRegistrados, tituloDevolver);
                    if (livroDevolver == null) {
                        System.out.println("❌ Livro não encontrado no sistema.");
                    } else {
                        service.devolverLivro(livroDevolver);
                    }
                    break;

                case "0":
                    continuar = false;
                    System.out.println("Encerrando o sistema. Até logo!");
                    break;

                default:
                    System.out.println("❌ Opção inválida.");
            }
        }

        scanner.close();
    }

    private static Livro encontrarLivro(List<Livro> livros, String titulo) {
        for (Livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                return l;
            }
        }
        return null;
    }
}
