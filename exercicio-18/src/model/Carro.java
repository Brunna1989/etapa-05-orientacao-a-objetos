package model;

import exception.LigacaoException;

public class Carro extends Automovel {

    public Carro(int velMax) {
        super(4, velMax);
    }

    @Override
    public void ligar() throws LigacaoException {
        this.ligado = true;
    }
}
