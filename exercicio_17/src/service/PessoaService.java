package service;

import exception.PessoaException;
import model.Pessoa;

public class PessoaService {

    public Pessoa criarPessoa(String nome, int idade, Pessoa pai, Pessoa mae) throws PessoaException {
        if (nome == null || nome.isBlank() || idade < 0) {
            throw new PessoaException("Nome inválido ou idade negativa.");
        }
        return new Pessoa(nome, idade, pai, mae);
    }

    public boolean saoIrmãos(Pessoa p1, Pessoa p2) {
        if (p1 == null || p2 == null) return false;
        return (p1.getPai() != null && p1.getPai().equals(p2.getPai())) ||
                (p1.getMae() != null && p1.getMae().equals(p2.getMae()));
    }

    public boolean saoPaisDe(Pessoa filho, Pessoa pai, Pessoa mae) {
        if (filho == null) return false;
        return filho.getPai() == pai && filho.getMae() == mae;
    }

    public String exibirArvoreGenealogica(Pessoa pessoa) throws PessoaException {
        if (pessoa == null) throw new PessoaException("Pessoa não pode ser nula.");

        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(pessoa.getNome())
                .append(" | Idade: ").append(pessoa.getIdade()).append("\n");

        if (pessoa.getPai() != null) {
            sb.append("  Pai -> ").append(pessoa.getPai().getNome())
                    .append(" (").append(pessoa.getPai().getIdade()).append(" anos)\n");
        }

        if (pessoa.getMae() != null) {
            sb.append("  Mãe -> ").append(pessoa.getMae().getNome())
                    .append(" (").append(pessoa.getMae().getIdade()).append(" anos)\n");
        }

        return sb.toString();
    }
}
