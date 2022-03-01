/*
 * Created on 23/02/2011, 11:10:23
 * Locate at Natal, Rio Grande do Norte
 *
 * ListaGenerica.java
 *
 * @autor torugo
 */
package base.cap3.listas.simples;

/**
 * Implementacao para uma lista generica.
 */
public class ListaGenerica<T> {

    private NodoGenerico<T> cabeca;

    private int tamanho;

    public ListaGenerica() {
    }

    public void inserirNaFrente(T objeto) {

        if (isEmpty())
            cabeca = new NodoGenerico<T>(objeto);

        else {
            NodoGenerico<T> nodo = new NodoGenerico<T>(objeto);
            nodo.setProximo(cabeca);

            cabeca = nodo;
        }

        tamanho++;
    }

    public T removerNaFrente() {

        if (isEmpty())
            throw new IllegalStateException("Lista Vazia");


        NodoGenerico<T> nodo = cabeca;
        cabeca = cabeca.getProximo();

        tamanho--;
        return nodo.getElemento();
    }

    public boolean isEmpty() {
        return cabeca == null;
    }

    /**
     * @return the tamanho
     */
    public int getTamanho() {
        return tamanho;
    }

    public T getPrimeiroElemento() {
        return cabeca.getElemento();
    }

}
