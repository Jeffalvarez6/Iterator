import java.util.Iterator;

public class ColaExtendida extends Cola {

    // (a) Obtener un iterador sobre la cola[cite: 100]
    @Override
    public Iterator iterador() {
        return new MiIterador();
    }

    private class MiIterador implements Iterator {
        private Nodo posicion = inicio;

        @Override
        public boolean hasNext() {
            return posicion != null;
        }

        @Override
        public Object next() {
            if (hasNext()) {
                Object elem = posicion.elemento;
                posicion = posicion.sgte;
                return elem;
            }
            return null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    // (b) Obtener el último elemento de una cola[cite: 101]
    public Object obtenerUltimo() {
        if (estaVacia()) return null;
        return fin.elemento;
    }

    // (c) Producir una cola al revés usando una Pila auxiliar[cite: 101]
    public ColaExtendida invertir() {
        ColaExtendida colaInvertida = new ColaExtendida();
        Pila pilaAuxiliar = new Pila();

        Nodo aux = inicio;
        while (aux != null) {
            pilaAuxiliar.push(aux.elemento);
            aux = aux.sgte;
        }

        while (!pilaAuxiliar.estaVacia()) {
            colaInvertida.agregar(pilaAuxiliar.pop());
        }

        return colaInvertida;
    }

    // (d) Concatenar dos colas (agrega la cola c2 al final de la actual)[cite: 101]
    public void concatenar(ColaExtendida c2) {
        if (c2 == null || c2.estaVacia()) return;

        Iterator it = c2.iterador();
        while (it.hasNext()) {
            this.agregar(it.next());
        }
    }

    // (e) Intercalar los elementos de dos colas[cite: 101]
    public static ColaExtendida intercalar(ColaExtendida c1, ColaExtendida c2) {
        ColaExtendida resultado = new ColaExtendida();
        Iterator it1 = (c1 != null) ? c1.iterador() : null;
        Iterator it2 = (c2 != null) ? c2.iterador() : null;

        while ((it1 != null && it1.hasNext()) || (it2 != null && it2.hasNext())) {
            if (it1 != null && it1.hasNext()) {
                resultado.agregar(it1.next());
            }
            if (it2 != null && it2.hasNext()) {
                resultado.agregar(it2.next());
            }
        }
        return resultado;
    }
}