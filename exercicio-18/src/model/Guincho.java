package model;

public class Guincho extends Automovel {

    public Guincho(int velMax) {
        super(4, velMax);
    }

    public void carregar(Automovel veiculo) {
        System.out.println("Guinchando: " + veiculo.getClass().getSimpleName());
    }

    @Override
    public void ligar() {
        this.ligado = true;
    }
}
