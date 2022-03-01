/*
 * Created on 19/06/2011, 15:22:19
 * Locate at Natal, Rio Grande do Norte
 *
 * ListaPosicao.java
 *
 * @autor torugo
 */
package base.cap6.listas;

/**
 * TAD Lista acessada por meio de objetos Position.
 */
public interface ListaPosicao<T> {

    /**
     * A posicao do primeiro elemento da lista. Ocorre um erro
     * se a lista esta vazia.
     *
     * @return A posicao do primeiro elemento da lista.
     */
    Position<T> first();

    /**
     * Retorna a posicao do ultimo elementos da lista; ocorre um
     * erro se a lista esta vazia.
     *
     * @return
     */
    Position<T> last();

    /**
     * Retorna a posicao do elemento da lista que precede o que se
     * encontra na posicao 'position'; ocorre um erro se 'position'
     * for a primeira posicao.
     *
     * @param position
     * @return
     */
    Position<T> prev(Position<T> position);

    /**
     * Retorna a posicao do elemento da lista que segue o que se
     * encontra na posicao 'position'; ocorre um erro se 'position'
     * for a ultimo posicao.
     *
     * @param position
     * @return
     */
    Position<T> next(Position<T> position);

    int size();

    boolean isEmpty();

    void addFirst(Position<T> position, T elemento);

    void addLast(Position<T> position, T elemento);

    void addBefore(Position<T> position, T elemento);

    void addAfter(Position<T> position, T elemento);

    T remover(Position<T> position);

    T set(Position<T> position, T elemento);
}
