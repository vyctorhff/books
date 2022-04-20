/*
 * Created on 19/06/2011, 15:37:37
 * Locate at Natal, Rio Grande do Norte
 *
 * ListaPosicaoImp.java
 *
 * @autor torugo
 */
package base.cap6.listas;

/**
 * Implementacao da TAD lista usando posicoes como localizador de objetos. Sera
 * usado um lista duplamente encadeada para armazenar os objetos.
 */
public class ListaPosicaoImp<E> implements ListaPosicao<E> {

    private final NodoListaPosicao<E> cabeca;
    private final NodoListaPosicao<E> cauda;

    private int numeroElementos;

    public ListaPosicaoImp() {
        cabeca = cauda = new NodoListaPosicao<E>(null);
    }

    @Override
    public Position<E> first() {
        if (isEmpty())
            throw new IllegalStateException("Lista vazia");

        return cabeca.getProximo();
    }

    @Override
    public Position<E> last() {
        if (isEmpty())
            throw new IllegalStateException("Lista vazia");


        return cauda.getAnterior();
    }

    @Override
    public Position<E> prev(Position<E> position) {
        this.validate(position);

        NodoListaPosicao<E> nodo = (NodoListaPosicao<E>) position;
        return nodo.getAnterior();
    }

    @Override
    public Position<E> next(Position<E> position) {
        this.validate(position);

        NodoListaPosicao<E> nodo = (NodoListaPosicao<E>) position;
        return nodo.getProximo();
    }

    @Override
    public int size() {
        return numeroElementos;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void addFirst(Position<E> position, E elemento) {
        this.addAfter(cabeca, elemento);
    }

    @Override
    public void addLast(Position<E> position, E elemento) {
        this.addBefore(cauda, elemento);
    }

    @Override
    public void addBefore(Position<E> position, E elemento) {
        validate(position);

        NodoListaPosicao<E> novoNodo = new NodoListaPosicao<E>(elemento);

        NodoListaPosicao<E> atualNodo = (NodoListaPosicao<E>) position;
        NodoListaPosicao<E> anterior = atualNodo.getAnterior();

        this.conectarNodos(anterior, novoNodo);
        this.conectarNodos(novoNodo, atualNodo);

        numeroElementos++;
    }

    @Override
    public void addAfter(Position<E> position, E elemento) {
        validate(position);

        NodoListaPosicao<E> novoNodo = new NodoListaPosicao<E>(elemento);

        NodoListaPosicao<E> atualNodo = (NodoListaPosicao<E>) position;
        NodoListaPosicao<E> proximo = atualNodo.getProximo();

        this.conectarNodos(atualNodo, novoNodo);
        this.conectarNodos(novoNodo, proximo);

        numeroElementos++;
    }

    @Override
    public E remover(Position<E> position) {
        validate(position);

        NodoListaPosicao<E> nodoRemovido = (NodoListaPosicao<E>) position;

        NodoListaPosicao<E> nodoAnterior = nodoRemovido.getAnterior();
        NodoListaPosicao<E> nodoProximo = nodoRemovido.getProximo();

        this.conectarNodos(nodoAnterior, nodoProximo);

        nodoRemovido.setAnterior(null);
        nodoRemovido.setProximo(null);

        return nodoRemovido.getElemento();
    }

    @Override
    public E set(Position<E> position, E elemento) {
        validate(position);

        NodoListaPosicao<E> nodoAtual = (NodoListaPosicao<E>) position;
        E elementoRemovido = nodoAtual.getElemento();

        nodoAtual.setElemento(elemento);

        return elementoRemovido;
    }

    /**
     * Relaciona dois nodo um para o outro. Nodo1 sera configurado
     * para anterior de nodo2; e nodo2 sera configurado para proximo
     * de nodo1
     *
     * @param nodo1
     * @param nodo2
     */
    public void conectarNodos(NodoListaPosicao<E> nodo1, NodoListaPosicao<E> nodo2) {
        nodo1.setProximo(nodo2);
        nodo2.setAnterior(nodo1);
    }

    /**
     * Valida se a posicao e um objeto valido para acessar os nodos da lista.
     *
     * @param position
     */
    public void validate(Position<E> position) {

        final String MENSAGEM_ERRO = "Posicao invalida!";

        if (position == null) {
            throw new IllegalArgumentException(MENSAGEM_ERRO);
        }

        if (!(position instanceof NodoListaPosicao)) {
            throw new IllegalArgumentException(MENSAGEM_ERRO);
        }

        NodoListaPosicao<E> nodo = (NodoListaPosicao<E>) position;

        if ((nodo == cabeca) || (nodo == cauda)) {
            throw new IllegalArgumentException(MENSAGEM_ERRO);
        }
    }

}
