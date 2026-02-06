import Personaje.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        inicio();
    }

    public static void inicio() {
        System.out.println("=== INICIO DEL JUEGO ===");

        ArrayList<Personaje> listaPers = new ArrayList<>();

        listaPers.add(new Guerrero("Melinoë", 7, 100, 15));
        listaPers.add(new Mago("Grigori Rasputín", 6, 60, 50));
        listaPers.add(new Monstruo("Remus Lupin", 5, 80));

        System.out.println("\n--- ESTADO INICIAL ---");
        mostrarEstadol(listaPers);

        //Ronda 1
        System.out.println("\n=== RONDA DE COMBATE ===");
        System.out.println("Cada entidad ataca una vez:");

        for (int i = 0; i < listaPers.size(); i++) {
            Personaje personajeE = listaPers.get(i);
            System.out.println("\nTurno " + (i+1) + ": " + personajeE.getNombre());
            personajeE.atacar();
        }

        //Ronda 2
        System.out.println("\n=== SEGUNDA RONDA (Recibir Daño) ===");

        for (int i = 0; i < 3 && i < listaPers.size(); i++) {
            Personaje personajeE = listaPers.get(i);
            int dano = 20 + (i * 5); // Daño variable: 20, 25, 30
            System.out.println("\n" + personajeE.getNombre() + " recibe ataque:");
            personajeE.recibirDano(dano);
        }

        System.out.println("\n--- ESTADO DESPUÉS DEL COMBATE ---");
        mostrarEstadol(listaPers);

        //Test "hacker"
        System.out.println("\nIntentando hackear el sistema...");
        intentarHackear(listaPers.get(0));

        System.out.println("\n--- COMPROBACIÓN HACKEO ---");
        mostrarEstadol(listaPers);
    }

    public static void mostrarEstadol(ArrayList<Personaje> lista) {
        System.out.println("Personajes: " + lista.size());
        System.out.println("");

        for (Personaje personajeE : lista) {
            System.out.println(personajeE.getNombre() +
                    " | Nivel: " + personajeE.getNivel() +
                    " | Vida: " + personajeE.getPuntosVida() +
                    " | Vivo: " + personajeE.getEstaVivo());
        }
    }

    public static void intentarHackear(Personaje personajeE) {
        System.out.println("\n--- Intentos de hackeo sobre " + personajeE.getNombre() + " ---");

        System.out.println("1. Modificar vida.");
        //personajeE.puntosVida = 999;  ERROR de por si del compilador
        System.out.println("   Fallido: Atributo 'puntosVida' es private.");

        System.out.println("2. Modificar vida a negativo.");
        personajeE.setPuntosVida(-100);
        System.out.println("   Vida actual: " + personajeE.getPuntosVida() +
                " | Vida mínima permitida es 0.");

        System.out.println("3. Modificar nivel a 100.");
        System.out.print("   ");
        personajeE.setNivel(100);
        System.out.println("   Nivel actual: " + personajeE.getNivel() +
                " | Solo permite subir en 1.");

        System.out.println("4. Modificar nivel a 1.");
        personajeE.setNivel(1);
        System.out.println("   Nivel actual: " + personajeE.getNivel() +
                " | No se puede bajar el nivel.");

        //ARREGLAR, DE MOMENTO SE PUEDE HACKEAR
        System.out.println("5. Revivir.");
        personajeE.setPuntosVida(50);
        System.out.println("   Vida actual: " + personajeE.getPuntosVida() +
                " | Vivo: " + personajeE.getEstaVivo());

        System.out.println("6. Atacar a muerto.");
        System.out.print("   ");
        personajeE.atacar();
    }
}