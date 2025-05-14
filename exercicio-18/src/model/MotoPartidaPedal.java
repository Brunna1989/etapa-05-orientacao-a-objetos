package model;

import exception.LigacaoException;
import exception.AutomovelExceptionHandler;

public class MotoPartidaPedal extends Moto {
    private boolean aceleradorPuxado;

    public MotoPartidaPedal(int velMax) {
        super(velMax);
        this.aceleradorPuxado = false;
    }

    public void puxarAcelerador() {
        this.aceleradorPuxado = true;
    }

    public boolean isAceleradorPuxado() {
        return aceleradorPuxado;
    }

    @Override
    public void ligar() throws LigacaoException {
        AutomovelExceptionHandler.verificarMotoPartidaPedal(this);
        this.ligado = true;
    }
}
