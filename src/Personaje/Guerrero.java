package Personaje;

public class Guerrero extends Personaje {
    //Atributos
    private int resistencia;
    private int defensa;

    //Constructor
    public Guerrero(String nombreE, int nivelE, int puntosVidaE, int resistenciaE) {
        super(nombreE, nivelE, puntosVidaE);
        setResistencia(resistenciaE);
        this.defensa = 5;
    }

    //Métodos
    @Override
    public void atacar() {
        if (getEstaVivo()) {
            System.out.println(getNombre() + " ataca con espada.");
        } else {
            System.out.println(getNombre() + " está muerto y no puede atacar.");
        }
    }

    @Override
    public void recibirDano(int valorDanio) {
        if (!getEstaVivo()) {
            return;
        }

        int danioFinal = valorDanio - resistencia - defensa;
        if (danioFinal < 0) {
            danioFinal = 0;
        }

        System.out.println(getNombre() + " recibe " + valorDanio + " de daño.");
        System.out.println("Resistencia reduce " + resistencia + " | Defensa reduce " + defensa + ".");
        System.out.println("Daño final: " + danioFinal);

        aplicarDanioDirecto(danioFinal);
    }

    //GETTERS y SETTERS
    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        if (resistencia >= 0) {
            this.resistencia = resistencia;
        }
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        if (defensa >= 0) {
            this.defensa = defensa;
        }
    }
}