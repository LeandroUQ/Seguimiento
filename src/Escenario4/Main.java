package Escenario4;

public class Main {
    public static void main(String[] args) {
        ListaDoblementeCircular partida = new ListaDoblementeCircular();

        // 1. Sentamos a los jugadores
        partida.agregar("Mago");
        partida.agregar("Guerrero");
        partida.agregar("Arquero");
        partida.agregar("Pícaro");

        partida.mostrar();

        // 2. Jugamos algunos turnos hacia adelante
        partida.avanzarTurno(); // Pasa a Guerrero
        partida.avanzarTurno(); // Pasa a Arquero
        partida.mostrar();

        // 3. El sistema necesita retroceder el turno
        partida.retrocederTurno(); // Vuelve a Guerrero
        partida.mostrar();

        // 4. Consultamos quién juega antes y después del Pícaro
        partida.buscar("Pícaro");

        // 5. Expulsamos a un jugador en mitad de la partida
        partida.eliminar("Guerrero"); // El Guerrero tenía el turno, pasará al Arquero
        partida.mostrar();
    }
}
