package service;

import model.Automovel;

public class AutomovelService {
    public void ligarVeiculo(Automovel veiculo) throws Exception {
        veiculo.ligar();
    }

    public void desligarVeiculo(Automovel veiculo) {
        veiculo.desligar();
    }

    public boolean estaLigado(Automovel veiculo) {
        return veiculo.isLigado();
    }
}
