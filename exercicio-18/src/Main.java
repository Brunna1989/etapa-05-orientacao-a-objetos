import model.*;
import exception.LigacaoException;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("===== Testando Automóveis =====");

            Carro carro = new Carro(180);
            carro.ligar();
            System.out.println("Carro ligado? " + carro.isLigado());

            Moto moto = new Moto(150);
            moto.ligar();
            System.out.println("Moto ligada? " + moto.isLigado());

            CarroAutomatico carroAuto = new CarroAutomatico(200);
            carroAuto.pressionarFreio();
            carroAuto.ligar();
            System.out.println("Carro Automático ligado? " + carroAuto.isLigado());

            MotoPartidaPedal motoPedal = new MotoPartidaPedal(130);
            motoPedal.puxarAcelerador();
            motoPedal.ligar();
            System.out.println("Moto Partida a Pedal ligada? " + motoPedal.isLigado());

            Guincho guincho = new Guincho(100);
            guincho.ligar();
            guincho.carregar(carro);
            guincho.carregar(moto);
            System.out.println("Guincho ligado? " + guincho.isLigado());

        } catch (LigacaoException e) {
            System.err.println("Erro ao ligar automóvel: " + e.getMessage());
        }
    }
}
