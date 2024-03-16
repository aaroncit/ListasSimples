package umg.edu.progra.listas;

import java.util.HashSet;
import java.util.Set;

public class Lista {

    private Nodo primero;

    public Lista() {
        primero = null;
    }

    public Nodo leerPrimero() {
        return primero;
    }

    public void insertarCabezaLista(int entrada) {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.enlace = primero;
        primero = nuevo;
    }

    public void visualizar() {
        Nodo n;
        n = primero;
        while (n != null) {
            System.out.print(n.dato + " ");
            n = n.enlace;
        }
    }

    public void invertirLista() {
        Nodo actual = primero;
        Nodo anterior = null;
        Nodo siguiente = null;

        while (actual != null) {
            siguiente = actual.enlace;
            actual.enlace = anterior;
            anterior = actual;
            actual = siguiente;
        }

        primero = anterior;
    }

    public int obtenerDesdeElFinal(int posicion) {
        int tamaño = obtenerTamaño();
        int posicionDesdeInicio = tamaño - posicion - 1;
        Nodo actual = primero;

        if (posicionDesdeInicio < 0) {
            return -1;
        }

        for (int i = 0; i < posicionDesdeInicio; i++) {
            actual = actual.enlace;
        }

        return actual.dato;
    }

    public void eliminarDuplicados() {
        Set<Integer> valores = new HashSet<>();
        Nodo actual = primero;
        Nodo anterior = null;

        while (actual != null) {
            if (valores.contains(actual.dato)) {
                anterior.enlace = actual.enlace;
            } else {
                valores.add(actual.dato);
                anterior = actual;
            }
            actual = actual.enlace;
        }
    }

    public int obtenerTamaño() {
        int tamaño = 0;
        Nodo actual = primero;

        while (actual != null) {
            tamaño++;
            actual = actual.enlace;
        }

        return tamaño;
    }
}

