package Escenario2;

public class ListaDoble {
        Nodo cabeza;
        Nodo actual;

        public void agregar(String dato) {
            Nodo nuevo = new Nodo(dato);

            if (cabeza == null) {
                cabeza = nuevo;
                actual = nuevo;
            } else {
                actual.siguiente = nuevo;
                nuevo.anterior = actual;
                actual = nuevo;
            }
        }

        public void eliminar() {
            if (actual == null) return;

            if (actual.anterior != null) {
                actual.anterior.siguiente = actual.siguiente;
            } else {
                cabeza = actual.siguiente;
            }

            if (actual.siguiente != null) {
                actual.siguiente.anterior = actual.anterior;
                actual = actual.siguiente;
            } else {
                actual = actual.anterior;
            }
        }

        public boolean buscar(String dato) {
            Nodo temp = cabeza;
            while (temp != null) {
                if (temp.dato.equals(dato)) {
                    return true;
                }
                temp = temp.siguiente;
            }
            return false;
        }

        public void mostrar() {
            Nodo temp = cabeza;
            while (temp != null) {
                System.out.print(temp.dato + " <-> ");
                temp = temp.siguiente;
            }
            System.out.println("null");
        }

        public void atras() {
            if (actual != null && actual.anterior != null) {
                actual = actual.anterior;
            }
        }

        public void adelante() {
            if (actual != null && actual.siguiente != null) {
                actual = actual.siguiente;
            }
        }

        public void mostrarActual() {
            if (actual != null) {
                System.out.println("Página actual: " + actual.dato);
            }
        }
    }
