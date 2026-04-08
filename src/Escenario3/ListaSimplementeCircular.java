package Escenario3;

public class ListaSimplementeCircular {
    Nodo cabeza;
    Nodo cola;
    Nodo reproduccionActual;

    public ListaSimplementeCircular() {
        this.cabeza = null;
        this.cola = null;
        this.reproduccionActual = null;
    }

    public void agregar(String cancion) {
        Nodo nuevoNodo = new Nodo(cancion);

        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
            cola.siguiente = cabeza;
            reproduccionActual = cabeza;
        } else {
            cola.siguiente = nuevoNodo;
            cola = nuevoNodo;
            cola.siguiente = cabeza;
        }
        System.out.println("Canción agregada: " + cancion);
    }

    public void eliminar(String cancion) {
        if (cabeza == null) {
            System.out.println("La lista está vacía. No hay nada que eliminar.");
            return;
        }

        Nodo actual = cabeza;
        Nodo anterior = cola;
        boolean encontrado = false;

        do {
            if (actual.cancion.equals(cancion)) {
                encontrado = true;

                if (actual == reproduccionActual) {
                    avanzarCancion();
                }

                if (actual == cabeza && actual == cola) {
                    // Caso 1: Solo hay un elemento en la lista
                    cabeza = null;
                    cola = null;
                    reproduccionActual = null;
                } else if (actual == cabeza) {
                    // Caso 2: El elemento a eliminar es la cabeza
                    cabeza = cabeza.siguiente;
                    cola.siguiente = cabeza;
                } else if (actual == cola) {
                    // Caso 3: El elemento a eliminar es la cola
                    anterior.siguiente = cabeza;
                    cola = anterior;
                } else {
                    // Caso 4: El elemento a eliminar está en el medio
                    anterior.siguiente = actual.siguiente;
                }
                System.out.println("❌ Eliminada: " + cancion);
                break;
            }
            anterior = actual;
            actual = actual.siguiente;
        } while (actual != cabeza);

        if (!encontrado) {
            System.out.println("⚠️ Canción no encontrada: " + cancion);
        }
    }

    public boolean buscar(String cancion) {
        if (cabeza == null) return false;

        Nodo actual = cabeza;
        do {
            if (actual.cancion.equals(cancion)) {
                return true;
            }
            actual = actual.siguiente;
        } while (actual != cabeza);

        return false;
    }

    public void mostrar() {
        if (cabeza == null) {
            System.out.println("📭 La lista de reproducción está vacía.");
            return;
        }

        Nodo actual = cabeza;
        System.out.println("\n--- 🎧 Lista de Reproducción Actual ---");
        do {
            if (actual == reproduccionActual) {
                System.out.print("[▶ " + actual.cancion + "] -> "); // Marca la que está sonando
            } else {
                System.out.print("[" + actual.cancion + "] -> ");
            }
            actual = actual.siguiente;
        } while (actual != cabeza);

        System.out.println("(Vuelve a: " + cabeza.cancion + ")\n");
    }

    public void avanzarCancion() {
        if (reproduccionActual != null) {
            reproduccionActual = reproduccionActual.siguiente;
            System.out.println("⏭️ Avanzando a: " + reproduccionActual.cancion);
        }
    }

}
