package Personaje;

public interface Habilidad {
    void usarHabilidad();
    int getCosteHabilidad();
    boolean puedeUsarHabilidad();
    TipoDanio getTipoDanioHabilidad();
}