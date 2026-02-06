package Personaje;

public class Guerrero extends Personaje implements Habilidad{
    //Atributos
    private int resistencia;
    private int defensa;
    private int furia;

    //Constructor
    public Guerrero(String nombreE, int nivelE, int puntosVidaE, int resistenciaE) {
        super(nombreE, nivelE, puntosVidaE, TipoDanio.MAGICO, TipoDanio.FISICO);
        setResistencia(resistenciaE);
        this.defensa = 5;
        this.furia = 0;
    }

    //Métodos
    @Override
    public void atacar() {
        if (getEstaVivo()) {
            System.out.println(getNombre() + " ataca con espada.");
            furia += 5;
        } else {
            System.out.println(getNombre() + " está muerto y no puede atacar.");
        }
    }

    @Override
    public void recibirDano(int valorDanio, TipoDanio tipoDanioE) {
        if (!getEstaVivo()) {
            return;
        }

        double multiplicador = calcularDanio(tipoDanioE);
        int danioBase = (int)(valorDanio * multiplicador);

        int danioFinal = danioBase - resistencia - defensa;
        if (danioFinal < 0) {
            danioFinal = 0;
        }

        System.out.println(getNombre() + " recibe " + valorDanio + " de daño" + tipoDanioE + ".");
        System.out.println("Multiplicador: " + multiplicador + " | Base: " + danioBase);
        System.out.println("Resistencia reduce " + resistencia + ", Defensa reduce " + defensa);
        System.out.println("Daño final: " + danioFinal);

        aplicarDanioDirecto(danioFinal, tipoDanioE);

        if (danioFinal > 0) {
            furia += 10;
        }
    }

    @Override
    public void usarHabilidad() {
        if (puedeUsarHabilidad()) {
            furia -= getCosteHabilidad();
            System.out.println(getNombre() + " usa GOLPE FURIOSO!");
            System.out.println("Inflige daño masivo de tipo " + getTipoDanioHabilidad());
            System.out.println("Furia restante: " + furia);
        } else {
            System.out.println("No hay suficiente furia para usar la habilidad especial");
        }
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