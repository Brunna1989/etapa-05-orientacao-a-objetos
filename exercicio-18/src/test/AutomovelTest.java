package test;

import model.*;
import exception.LigacaoException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AutomovelTest {

    @Test
    public void testCarroLigar() throws LigacaoException {
        Carro carro = new Carro(180);
        carro.ligar();
        assertTrue(carro.isLigado());
    }

    @Test
    public void testCarroAutomaticoComFreio() {
        CarroAutomatico carroAutomatico = new CarroAutomatico(180);
        carroAutomatico.pressionarFreio();
        try {
            carroAutomatico.ligar();
            assertTrue(carroAutomatico.isLigado());
        } catch (LigacaoException e) {
            fail("Não deveria lançar exceção");
        }
    }

    @Test
    public void testCarroAutomaticoSemFreio() {
        CarroAutomatico carroAutomatico = new CarroAutomatico(180);
        try {
            carroAutomatico.ligar();
            fail("Deveria lançar exceção");
        } catch (LigacaoException e) {
            assertEquals("O freio precisa estar pressionado para ligar o carro!", e.getMessage());
        }
    }

    @Test
    public void testMotoPartidaPedalComAcelerador() {
        MotoPartidaPedal moto = new MotoPartidaPedal(120);
        moto.puxarAcelerador();
        try {
            moto.ligar();
            assertTrue(moto.isLigado());
        } catch (LigacaoException e) {
            fail("Não deveria lançar exceção");
        }
    }

    @Test
    public void testMotoPartidaPedalSemAcelerador() {
        MotoPartidaPedal moto = new MotoPartidaPedal(120);
        try {
            moto.ligar();
            fail("Deveria lançar exceção");
        } catch (LigacaoException e) {
            assertEquals("O acelerador precisa estar puxado para ligar a moto!", e.getMessage());
        }
    }


    @Test
    public void testGuincho() {
        Guincho guincho = new Guincho(60);
        Carro carro = new Carro(180);
        Moto moto = new Moto(120);

        guincho.ligar();
        guincho.carregar(carro);
        guincho.carregar(moto);

        assertTrue(guincho.isLigado());
    }
}
