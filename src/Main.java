import Personaje.*;

public class Main {
    public static void main(String[] args) {
        inicio();
    }

    public static void inicio() {
        Guerrero heroe = new Guerrero("Melinoë", 10, 100, 15);
        Mago nigromante = new Mago("Grigori Rasputín", 8, 60, 50);
        Monstruo licantropo = new Monstruo("Remus Lupin", 5, 80);

        heroe.atacar();
        nigromante.atacar();
        licantropo.atacar();
    }
}