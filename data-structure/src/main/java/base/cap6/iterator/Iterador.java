/*
 * Created on 19/06/2011, 19:36:01
 * Locate at Natal, Rio Grande do Norte
 *
 * Iterador.java
 *
 * @autor torugo
 */
package base.cap6.iterator;

/**
 *
 */
public interface Iterador<E> {

    public E next();


    public boolean hasNext();


    /**
     * Acrecenta o lemento na posicao corrente do iterador
     *
     * @param elemento
     */
    public void add(E elemento);


    /**
     * Remove o elemento na posicao corrente do iterador.
     *
     * @return elemento removido.
     */
    public E remove();
}
