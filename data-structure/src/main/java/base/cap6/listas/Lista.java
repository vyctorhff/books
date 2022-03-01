/*
 * Created on 17/06/2011, 14:42:36
 * Locate at Natal, Rio Grande do Norte
 *
 * Lista.java
 *
 * @autor torugo
 */
package base.cap6.listas;

/**
 * TAD lista.
 */
public interface Lista<T> {

    public int size();


    public boolean isEmpty();


    /**
     * Retorna o elemento da lista referente ao indice.
     *
     * @param indice
     * @return
     * @throws Exception
     */
    public T get(int indice) throws Exception;


    /**
     * Substitui por elemento o conteudo da lista referente ao indice.
     *
     * @param indice
     * @param elemento
     * @return
     * @throws Exception
     */
    public T set(int indice, T elemento) throws Exception;


    /**
     * Insere o elemento no indice determinado.
     *
     * @param indice
     * @param elemento
     * @throws Exception
     */
    public void add(int indice, T elemento) throws Exception;


    /**
     * Remove o elemento do indice determinado.
     *
     * @param indice
     * @return
     * @throws Exception
     */
    public T remove(int indice) throws Exception;
}
