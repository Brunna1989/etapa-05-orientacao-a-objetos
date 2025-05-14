package model;

import exception.LigacaoException;

public class Moto extends Automovel {

    public Moto(int velMax) {
        super(2, velMax);
    }

    @Override
    public void ligar() throws LigacaoException {
        this.ligado = true;
    }
}
