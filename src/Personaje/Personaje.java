package Personaje;

abstract class Personaje {
    //Atributos
    private String nombre;
    private int nivel;
    private int puntosVida;

    //Constructores
    public Personaje(String nombreE, int nivelE, int puntosVidaE) {
        this.nombre = nombreE;
        this.nivel = nivelE;
        this.puntosVida = puntosVidaE;
    }

    //Métodos
    public abstract void atacar();

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVidaE) {
        this.puntosVida = puntosVidaE;
    }
}