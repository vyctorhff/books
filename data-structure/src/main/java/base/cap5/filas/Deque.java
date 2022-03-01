/*
 * Created on 02/03/2011, 14:48:24
 * Locate at Natal, Rio Grande do Norte
 *
 * Deque.java
 *
 * @autor torugo
 */
package base.cap5.filas;

/**
 * Contem as funcionalidades da TAD Deque.
 * <p>
 * Deques permitem a insercao na frente e no final, apenas.
 */
public interface Deque<E> {

    int size();

    boolean isEmpty();

    E getFirst();

    E getLast();

    void addFirst(E element);

    void addLast(E element);

    E removeFirst();

    E removeLast();
}
