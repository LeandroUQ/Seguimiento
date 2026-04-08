package Escenario1;

public class Cola {
    Nodo frente;
    Nodo fin;

    public void agregar(String dato) {
        Nodo nuevo = new Nodo(dato);
        if (fin == null) {
            frente = fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    public void eliminar() {
        if (frente == null) {
            System.out.println("La cola está vacía");
            return;
        }
        System.out.println("Atendiendo a: " + frente.dato);
        frente = frente.siguiente;

        if (frente == null) {
            fin = null;
        }
    }

    public boolean buscar(String dato) {
        Nodo temp = frente;
        while (temp != null) {
            if (temp.dato.equals(dato)) {
                return true;
            }
            temp = temp.siguiente;
        }
        return false;
    }

    public void mostrar() {
        Nodo temp = frente;
        if (temp == null) {
            System.out.println("Cola vacía");
            return;
        }
        while (temp != null) {
            System.out.print(temp.dato + " -> ");
            temp = temp.siguiente;
        }
        System.out.println("null");
    }
}

