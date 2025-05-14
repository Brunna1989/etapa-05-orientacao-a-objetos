package model;

public abstract class Automovel {
    protected int numRodas;
    protected int velMax;
    protected boolean ligado;

    public Automovel(int numRodas, int velMax) {
        this.numRodas = numRodas;
        this.velMax = velMax;
        this.ligado = false;
    }

    public abstract void ligar() throws Exception;

    public void desligar() {
        this.ligado = false;
    }

    public boolean isLigado() {
        return ligado;
    }

    public int getNumRodas() {
        return numRodas;
    }

    public int getVelMax() {
        return velMax;
    }
}
