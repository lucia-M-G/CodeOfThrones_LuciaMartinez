package Personaje;

public class Guerrero extends Personaje {
    //Atributos
    private int resistencia;

    //Constructores
    public Guerrero(String nombreE, int nivelE, int puntosVidaE, int resistenciaE) {
        super(nombreE, nivelE, puntosVidaE);
        this.resistencia = resistenciaE;
    }

    // Métodos
    @Override
    public void atacar() {
        System.out.println(nombre + " ataca con espada");
    }
}