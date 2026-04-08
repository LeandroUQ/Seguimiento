package Escenario4;

public class Nodo {
    String jugador;
    Nodo siguiente;

    public Nodo(String jugador) {
        this.jugador = jugador;
        this.siguiente = null;
    }
}