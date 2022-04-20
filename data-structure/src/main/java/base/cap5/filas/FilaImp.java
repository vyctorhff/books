/*
 * Created on 13/03/2011, 14:30:39
 * Locate at Natal, Rio Grande do Norte
 *
 * FilaGenerica.java
 *
 * @autor torugo
 */
package base.cap5.filas;

public class FilaImp<E> implements Fila<E> {

    private int tamanho;

    private NodoFila<E> head;

    private NodoFila<E> tail;

    @Override
    public int size() {
        return tamanho;
    }

    @Override
    public boolean isEmpty() {
        return tamanho == 0;
    }

    @Override
    public E front() {
        if (isEmpty())
            throw new IllegalStateException("Fila vazia!");

        return head.getElemento();
    }

    @Override
    public void enqueue(E element) {

        if (isEmpty()) {
            head = new NodoFila<E>(element);
            tail = head;

        } else {
            NodoFila<E> nodo = new NodoFila<E>(element);

            tail.setProximo(nodo);
            tail = nodo;
        }

        tamanho++;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalStateException("Fila esta vazia.");

        NodoFila<E> nodo = head;
        head = head.getProximo();

        tamanho--;
        return nodo.getElemento();
    }

}
