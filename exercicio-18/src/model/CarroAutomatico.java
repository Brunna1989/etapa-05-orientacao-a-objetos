package model;

import exception.LigacaoException;
import exception.AutomovelExceptionHandler;

public class CarroAutomatico extends Carro {
    private boolean freioPressionado;

    public CarroAutomatico(int velMax) {
        super(velMax);
        this.freioPressionado = false;
    }

    public void pressionarFreio() {
        this.freioPressionado = true;
    }

    public boolean isFreioPressionado() {
        return freioPressionado;
    }

    @Override
    public void ligar() throws LigacaoException {
        AutomovelExceptionHandler.verificarCarroAutomatico(this);
        this.ligado = true;
    }
}
