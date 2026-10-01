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