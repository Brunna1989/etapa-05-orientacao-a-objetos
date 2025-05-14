package model;

import java.util.Objects;

public class Contato implements Comparable<Contato> {
    private String nome;
    private String telefone;

    public Contato(String nome, String telefone) {
        this.nome = nome.trim();
        this.telefone = telefone.trim();
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public int compareTo(Contato other) {
        return this.nome.compareToIgnoreCase(other.nome);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contato)) return false;
        Contato contato = (Contato) o;
        return nome.equalsIgnoreCase(contato.nome) || telefone.equals(contato.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome.toLowerCase(), telefone);
    }

    @Override
    public String toString() {
        return nome + " - " + telefone;
    }
}
