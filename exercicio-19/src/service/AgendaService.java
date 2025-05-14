package service;

import exception.ContatoExistenteException;
import model.Contato;

import java.util.Set;
import java.util.TreeSet;

public class AgendaService {
    private Set<Contato> contatos;

    public AgendaService() {
        this.contatos = new TreeSet<>();
    }

    public void adicionarContato(Contato contato) throws ContatoExistenteException {
        if (contatos.contains(contato)) {
            throw new ContatoExistenteException("Contato ou número já cadastrado.");
        }
        contatos.add(contato);
    }

    public void removerContato(Contato contato) {
        contatos.remove(contato);
    }

    public Set<Contato> listarContatos() {
        return new TreeSet<>(contatos);
    }
}
