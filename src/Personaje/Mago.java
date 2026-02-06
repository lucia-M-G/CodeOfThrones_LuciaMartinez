package Personaje;

public class Mago extends Personaje {
    //Atributos
    private int mana;
    private int escudoMagico;

    //Constructor
    public Mago(String nombreE, int nivelE, int puntosVidaE, int manaE) {
        super(nombreE, nivelE, puntosVidaE);
        setMana(manaE);
        this.escudoMagico = 3;
    }

    //Métodos
    @Override
    public void atacar() {
        if (getEstaVivo()) {
            if (mana >= 5) {
                mana -= 5;
                System.out.println(getNombre() + " lanza hechizo (Mana restante: " + mana + ").");
            } else {
                System.out.println(getNombre() + " no tiene suficiente mana.");
            }
        } else {
            System.out.println(getNombre() + " está muerto y no puede atacar.");
        }
    }

    @Override
    public void recibirDano(int valorDanio) {
        if (!getEstaVivo()) return;

        //El mago tiene escudo mágico
        int danioFinal = valorDanio - escudoMagico;
        if (danioFinal < 0) danioFinal = 0;

        System.out.println(getNombre() + " recibe " + valorDanio + " de daño.");
        System.out.println("Escudo mágico reduce " + escudoMagico + ".");
        System.out.println("Daño final: " + danioFinal + ".");

        aplicarDanioDirecto(danioFinal);
    }

    //GETTERS y SETTERS
    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana >= 0) {
            this.mana = mana;
        }
    }
}