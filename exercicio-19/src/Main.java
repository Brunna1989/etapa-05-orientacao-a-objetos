import model.Contato;
import service.AgendaService;
import exception.ContatoExistenteException;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        AgendaService agenda = new AgendaService();

        JFrame frame = new JFrame("Sistema de Agenda");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JLabel mensagem = new JLabel("Bem-vindo - Sistema de Agenda Telefônica", JLabel.CENTER);
        mensagem.setFont(new Font("Arial", Font.BOLD, 16));

        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> listaContatos = new JList<>(listModel);

        JButton adicionar = new JButton("Adicionar");
        JButton deletar = new JButton("Deletar");
        JButton sair = new JButton("Sair");

        adicionar.addActionListener(e -> {
            String nome = JOptionPane.showInputDialog("Digite o nome:");
            String telefone = JOptionPane.showInputDialog("Digite o telefone (XX XXXX-XXXX):");

            if (nome == null || telefone == null || nome.isBlank() || telefone.isBlank()) {
                JOptionPane.showMessageDialog(frame, "Nome e telefone são obrigatórios!");
                return;
            }

            Contato novo = new Contato(nome, telefone);
            try {
                agenda.adicionarContato(novo);
                atualizarLista(agenda, listModel);
            } catch (ContatoExistenteException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage());
            }
        });

        deletar.addActionListener(e -> {
            String nome = JOptionPane.showInputDialog("Digite o nome para deletar:");
            if (nome == null || nome.isBlank()) return;

            Contato paraRemover = agenda.listarContatos().stream()
                    .filter(c -> c.getNome().equalsIgnoreCase(nome.trim()))
                    .findFirst().orElse(null);

            if (paraRemover != null) {
                agenda.removerContato(paraRemover);
                atualizarLista(agenda, listModel);
            } else {
                JOptionPane.showMessageDialog(frame, "Contato não encontrado!");
            }
        });

        sair.addActionListener(e -> System.exit(0));

        JPanel botoes = new JPanel();
        botoes.add(adicionar);
        botoes.add(deletar);
        botoes.add(sair);

        frame.setLayout(new BorderLayout());
        frame.add(mensagem, BorderLayout.NORTH);
        frame.add(new JScrollPane(listaContatos), BorderLayout.CENTER);
        frame.add(botoes, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private static void atualizarLista(AgendaService agenda, DefaultListModel<String> listModel) {
        listModel.clear();
        for (Contato c : agenda.listarContatos()) {
            listModel.addElement(c.toString());
        }
    }
}
