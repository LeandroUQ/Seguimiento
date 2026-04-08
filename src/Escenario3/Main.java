import Escenario3.ListaSimplementeCircular;

void main() {
    ListaSimplementeCircular playlist = new ListaSimplementeCircular();

    // Agregamos canciones
    playlist.agregar("Bohemian Rhapsody");
    playlist.agregar("Stairway to Heaven");
    playlist.agregar("Hotel California");
    playlist.agregar("Imagine");

    // Mostramos la lista
    playlist.mostrar();

    // Simulamos la reproducción continua y avanzar de canción
    playlist.avanzarCancion();
    playlist.avanzarCancion();
    playlist.mostrar(); // Veremos que el marcador [▶] ha avanzado

    // Buscamos una canción
    String buscar = "Hotel California";
    System.out.println("¿Está '" + buscar + "' en la lista?: " + (playlist.buscar(buscar) ? "Sí" : "No"));

    // Eliminamos una canción del medio
    playlist.eliminar("Stairway to Heaven");
    playlist.mostrar();

    // Eliminamos la cabeza para probar que la circularidad se mantiene
    playlist.eliminar("Bohemian Rhapsody");
    playlist.mostrar();

    // Simular que la lista "nunca termina" (avanzar varias veces)
    System.out.println("Simulando reproducción continua (Loop infinito):");
    for (int i = 0; i < 5; i++) {
        playlist.avanzarCancion();
    }
}
