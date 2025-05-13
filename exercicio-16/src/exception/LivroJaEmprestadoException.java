package exception;

public class LivroJaEmprestadoException extends RuntimeException {
    public LivroJaEmprestadoException(String message) {
        super(message);
    }
}
