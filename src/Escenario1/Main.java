package Escenario1;

public class Main {
    public static void main(String[] args) {
        Cola cola = new Cola();

        // Agregar clientes
        cola.agregar("Cliente 1");
        cola.agregar("Cliente 2");
        cola.agregar("Cliente 3");

        System.out.println("Cola actual:");
        cola.mostrar();

        // Atender cliente
        cola.eliminar();

        System.out.println("Después de atender uno:");
        cola.mostrar();

        // Buscar cliente
        System.out.println("¿Está Cliente 2? " + cola.buscar("Cliente 2"));
        System.out.println("¿Está Cliente 5? " + cola.buscar("Cliente 5"));

        // Atender todos
        cola.eliminar();
        cola.eliminar();
        cola.eliminar(); // prueba cola vacía

        System.out.println("Estado final:");
        cola.mostrar();
    }
}

