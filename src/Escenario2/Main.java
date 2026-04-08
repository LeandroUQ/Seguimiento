package Escenario2;

public class Main {
    public static void main(String[] args) {
        ListaDoble historial = new ListaDoble();

        // Visitar páginas
        historial.agregar("google.com");
        historial.agregar("youtube.com");
        historial.agregar("facebook.com");

        System.out.println("Historial:");
        historial.mostrar();

        // Mostrar actual
        historial.mostrarActual();

        // Ir atrás
        historial.atras();
        historial.mostrarActual();

        // Ir atrás otra vez
        historial.atras();
        historial.mostrarActual();

        // Ir adelante
        historial.adelante();
        historial.mostrarActual();

        // Buscar página
        System.out.println("¿Está youtube.com? " + historial.buscar("youtube.com"));
        System.out.println("¿Está twitter.com? " + historial.buscar("twitter.com"));

        // Eliminar actual
        historial.eliminar();
        System.out.println("Después de eliminar:");
        historial.mostrar();

        historial.mostrarActual();
    }
}

