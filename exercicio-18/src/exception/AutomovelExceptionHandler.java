package exception;

import model.CarroAutomatico;
import model.MotoPartidaPedal;
import model.Moto;

public class AutomovelExceptionHandler {

    public static void verificarCarroAutomatico(CarroAutomatico carro) throws LigacaoException {
        if (!carro.isFreioPressionado()) {
            throw new LigacaoException("O freio precisa estar pressionado para ligar o carro!");
        }
    }

    public static void verificarMotoPartidaPedal(MotoPartidaPedal moto) throws LigacaoException {
        if (!moto.isAceleradorPuxado()) {
            throw new LigacaoException("O acelerador precisa estar puxado para ligar a moto!");
        }
    }

    public static void verificarMoto(Moto moto) throws LigacaoException {
        if (!moto.isLigado()) {
            throw new LigacaoException("Não foi possível ligar a moto!");
        }
    }
}
