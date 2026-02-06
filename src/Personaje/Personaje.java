package Personaje;

public abstract class Personaje {
    //Atributos
    private String nombre;
    private int nivel;
    private int puntosVida;
    private boolean estaVivo;

    //Constructor
    public Personaje(String nombreE, int nivelE, int puntosVidaE) {
        this.nombre = nombreE;
        setNivel(nivelE);
        setPuntosVida(puntosVidaE);
        this.estaVivo = (puntosVidaE > 0);
    }

    //Métodos
    public abstract void atacar();

    public abstract void recibirDano(int valorDanio);

    //GETTERS y SETTERS
    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public boolean getEstaVivo() {
        return estaVivo;
    }

    public void setPuntosVida(int puntosVidaP) {
        if (puntosVidaP < 0) {
            this.puntosVida = 0;
            this.estaVivo = false;
        } else {
            this.puntosVida = puntosVidaP;
            this.estaVivo = true;
        }
    }

    public void setNivel(int nivelParametro) {
        // Solo +1
        if (nivelParametro > this.nivel) {
            if (nivelParametro == this.nivel + 1) {
                this.nivel = nivelParametro;
            } else {
                System.out.println("Error: Solo se puede subir de nivel de 1 en 1");
            }
        } else {
            System.out.println("Error: No se puede bajar de nivel");
        }
    }

    public void aplicarDanioDirecto(int cantidad) {
        if (cantidad > 0) {
            int nuevaVida = this.puntosVida - cantidad;
            setPuntosVida(nuevaVida);

            if (nuevaVida <= 0) {
                System.out.println(nombre + " ha muerto!");
            }
        }
    }
}