package Personaje;

public class Monstruo extends Personaje {
    //Atributos

    //Constructores
    public Monstruo(String nombre, int nivel, int puntVida) {
        super(nombre, nivel, puntVida);
    }

    // Métodos
    @Override
    public void atacar() {
        System.out.println(nombre + " ataca salvajemente");
    }
}