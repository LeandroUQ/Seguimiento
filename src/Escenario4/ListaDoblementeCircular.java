package Escenario4;

public class ListaDoblementeCircular {
    Nodo cabeza;
    Nodo cola;
    Nodo turnoActual; // Puntero que indica de quién es el turno

    public ListaDoblementeCircular() {
        this.cabeza = null;
        this.cola = null;
        this.turnoActual = null;
    }

    public void agregar(String jugador) {
        Nodo nuevoNodo = new Nodo(jugador);

        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
            cabeza.siguiente = cabeza;
            cabeza.anterior = cabeza;
            turnoActual = cabeza;    // El primer jugador en entrar tiene el primer turno
        } else {
            cola.siguiente = nuevoNodo;
            nuevoNodo.anterior = cola;
            nuevoNodo.siguiente = cabeza;
            cabeza.anterior = nuevoNodo;
            cola = nuevoNodo;
        }
        System.out.println("🎮 Jugador añadido: " + jugador);
    }

    public void eliminar(String jugador) {
        if (cabeza == null) {
            System.out.println("La mesa está vacía.");
            return;
        }

        Nodo actual = cabeza;
        boolean encontrado = false;

        do {
            if (actual.jugador.equals(jugador)) {
                encontrado = true;

                if (actual == turnoActual) {
                    System.out.println("⚠️ " + jugador + " fue expulsado en su turno.");
                    avanzarTurno();
                    if (actual.siguiente == actual) {
                        turnoActual = null;
                    }
                }

                if (actual == cabeza && actual == cola) {
                    cabeza = null;
                    cola = null;
                } else if (actual == cabeza) {
                    cabeza = cabeza.siguiente;
                    cola.siguiente = cabeza;
                    cabeza.anterior = cola;
                } else if (actual == cola) {
                    cola = actual.anterior;
                    cola.siguiente = cabeza;
                    cabeza.anterior = cola;
                } else {
                    actual.anterior.siguiente = actual.siguiente;
                    actual.siguiente.anterior = actual.anterior;
                }
                System.out.println("🚪 Expulsado: " + jugador);
                break;
            }
            actual = actual.siguiente;
        } while (actual != cabeza);

        if (!encontrado) {
            System.out.println("El jugador " + jugador + " no está en la partida.");
        }
    }

    public boolean buscar(String jugador) {
        if (cabeza == null) return false;

        Nodo actual = cabeza;

        do {
            if (actual.jugador.equals(jugador)) {
                System.out.println("🔍 Búsqueda de [" + jugador + "]:");
                System.out.println("   ⬅️ Jugó antes: " + actual.anterior.jugador);
                System.out.println("   ➡️ Juega después: " + actual.siguiente.jugador);
                return true;
            }
            actual = actual.siguiente;
        } while (actual != cabeza);

        System.out.println("❌ El jugador " + jugador + " no fue encontrado.");
        return false;
    }

    public void mostrar() {
        if (cabeza == null) {
            System.out.println("🪑 La mesa está vacía.");
            return;
        }

        Nodo actual = cabeza;
        System.out.println("\n--- 🎲 Orden de la Mesa ---");
        do {
            if (actual == turnoActual) {
                System.out.print("[⭐ Turno: " + actual.jugador + "] -> ");
            } else {
                System.out.print("[" + actual.jugador + "] -> ");
            }
            actual = actual.siguiente;
        } while (actual != cabeza);
        System.out.println("(Vuelve a " + cabeza.jugador + ")\n");
    }


    public void avanzarTurno() {
        if (turnoActual != null) {
            turnoActual = turnoActual.siguiente;
            System.out.println("⏩ Turno avanzado. Ahora juega: " + turnoActual.jugador);
        }
    }

    public void retrocederTurno() {
        if (turnoActual != null) {
            turnoActual = turnoActual.anterior;
            System.out.println("⏪ Turno retrocedido. Ahora juega: " + turnoActual.jugador);
        }
    }
}
