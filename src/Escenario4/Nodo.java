package Escenario4;

public class Nodo {
    String jugador;
    Nodo siguiente;
    Nodo anterior;

    public Nodo(String jugador) {
        this.jugador = jugador;
        this.siguiente = null;
        this.anterior = null;
    }
}