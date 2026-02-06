package Personaje;

public class Monstruo extends Personaje {
    //Atributos
    private int furia;

    //Constructor
    public Monstruo(String nombre, int nivel, int puntosVidaE) {
        super(nombre, nivel, puntosVidaE);
        this.furia = 0;
    }

    //Métodos
    @Override
    public void atacar() {
        if (getEstaVivo()) {
            System.out.println(getNombre() + " ataca salvajemente.");
            furia++;
        } else {
            System.out.println(getNombre() + " está muerto.");
        }
    }

    @Override
    public void recibirDano(int valorDanio) {
        if (!getEstaVivo()) {
            return;
        }

        int danioFinal = valorDanio;

        System.out.println(getNombre() + " recibe " + valorDanio + " de daño.");

        aplicarDanioDirecto(danioFinal);

        // Daño aumenta la furia
        if (getEstaVivo()) {
            furia++;
            System.out.println("Furia del monstruo: " + furia + ".");
        }
    }

    //GETTERS y SETTERS
    public int getFuria() {
        return furia;
    }

    public void setFuria(int furia) {
        if (furia >= 0) {
            this.furia = furia;
        }
    }
}