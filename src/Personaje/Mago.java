package Personaje;

public class Mago extends Personaje {
    //Atributos
    private int mana;

    //Constructores
    public Mago(String nombreE, int nivelE, int puntosVidaE, int manaE) {
        super(nombreE, nivelE, puntosVidaE);
        this.mana = manaE;
    }

    // Métodos
    @Override
    public void atacar() {
        System.out.println(nombre + " lanza hechizo");
    }
}