import Personaje.*;

public class Main {
    public static void main(String[] args) {
        inicio();
    }

    public static void inicio() {
        Guerrero heroe = new Guerrero("Melinoë", 7, 100, 15);
        Mago nigromante = new Mago("Grigori Rasputín", 6, 60, 50);
        Monstruo licantropo = new Monstruo("Remus Lupin", 5, 80);

        System.out.println("\n=== INICIO DEL JUEGO ===");

        // Estados iniciales
        System.out.println("\n--- Estados iniciales ---");
        mostrarEstado(heroe);
        mostrarEstado(nigromante);
        mostrarEstado(licantropo);

        // Ataques
        System.out.println("\n--- Ataques ---");
        heroe.atacar();
        nigromante.atacar();
        licantropo.atacar();

        // Recibir daño
        System.out.println("\n--- Batalla ---");
        heroe.recibirDano(20);
        nigromante.recibirDano(15);
        licantropo.recibirDano(30);

        // Subir nivel
        System.out.println("\n--- Subir nivel ---");
        heroe.setNivel(8);  // de 7 a 8
        heroe.setNivel(10);  // Error: no se puede saltar niveles
        heroe.setNivel(6);  // Error: no se puede bajar nivel

        // Morir
        System.out.println("\n--- Prueba de muerte ---");
        heroe.recibirDano(200);
        heroe.atacar();  // Error: no puede atacar estando muerto
    }

    public static void mostrarEstado(Personaje personajeE) {
        System.out.println(personajeE.getNombre() +
                " | Nivel: " + personajeE.getNivel() +
                " | Vida: " + personajeE.getPuntosVida() +
                " | Vivo: " + personajeE.getEstaVivo());
    }
}