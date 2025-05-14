import exception.PessoaException;
import model.Pessoa;
import service.PessoaService;

public class Main {
    public static void main(String[] args) {
        PessoaService service = new PessoaService();

        try {

            Pessoa avoPai = service.criarPessoa("João", 78, null, null);
            Pessoa avoMae = service.criarPessoa("Maria", 74, null, null);

            Pessoa pai = service.criarPessoa("Carlos", 50, avoPai, avoMae);
            Pessoa mae = service.criarPessoa("Ana", 48, null, null);

            Pessoa filho = service.criarPessoa("Lucas", 20, pai, mae);

            System.out.println(service.exibirArvoreGenealogica(filho));
            System.out.println(service.exibirArvoreGenealogica(pai));

            Pessoa irma = service.criarPessoa("Laura", 18, pai, mae);
            boolean saoIrmaos = service.saoIrmãos(filho, irma);
            System.out.println("Lucas e Laura são irmãos? " + (saoIrmaos ? "Sim" : "Não"));

        } catch (PessoaException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
