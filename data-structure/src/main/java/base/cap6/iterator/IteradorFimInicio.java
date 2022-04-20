/*
 * Created on 19/06/2011, 19:39:45
 * Locate at Natal, Rio Grande do Norte
 *
 * IteradorFimInicio.java
 *
 * @autor torugo
 */
package base.cap6.iterator;

/**
 * Percorre um lista do fim ate o inicio.
 */
public class IteradorFimInicio<E> implements Iterador<E> {

    @Override
    public E next() {
        return null;
    }


    @Override
    public boolean hasNext() {
        return false;
    }


    @Override
    public void add(E elemento) {
    }


    @Override
    public E remove() {
        return null;
    }

}
