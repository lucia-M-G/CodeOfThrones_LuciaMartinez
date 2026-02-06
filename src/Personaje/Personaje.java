package Personaje;

public abstract class Personaje {
    //Atributos
    private String nombre;
    private int nivel;
    private int puntosVida;
    private boolean estaVivo;
    private TipoDanio debilidad;
    private TipoDanio resistencia;

    //Constructor
    public Personaje(String nombreE, int nivelE, int puntosVidaE, TipoDanio debilidadE, TipoDanio resistenciaE) {
        this.nombre = nombreE;
        setNivel(nivelE);
        setPuntosVida(puntosVidaE);
        this.estaVivo = (puntosVidaE > 0);
        this.debilidad = debilidadE;
        this.resistencia = resistenciaE;
    }

    //Métodos
    public abstract void atacar();

    public abstract void recibirDano(int valorDanio, TipoDanio tipoDanioE);

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

    public TipoDanio getDebilidad() {
        return debilidad;
    }

    public TipoDanio getResistencia() {
        return resistencia;
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
        //Solo +1
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

    public double calcularDanio(TipoDanio tipoDanioE) {
        if (tipoDanioE == debilidad) {
            System.out.println("¡Es muy efectivo! (" + tipoDanioE + " es debilidad)");
            // 50% más de daño
            return 1.5;
        } else if (tipoDanioE == resistencia) {
            System.out.println("No es muy efectivo... (" + tipoDanioE + " es resistencia)");
            // 50% menos de daño
            return 0.5;
        }
        // Daño normal
        return 1.0;
    }
}