/*
 * Created on 16/03/2011, 15:10:45
 * Locate at Natal, Rio Grande do Norte
 *
 * NodoGenerico.java
 *
 * @autor torugo
 */
package br.study.base.cap3.listas.simples;

/**
 * Representa uma nodo para a lista capaz de armazenar qualquer tipo de elemento.
 */
public class NodoGenerico<T> {

    private long identificador;

    private T elemento;

    private NodoGenerico<T> proximo;


    public NodoGenerico(T elemento) {
        this.setElemento(elemento);

        identificador = System.nanoTime();
    }


    /**
     * @return the elemento
     */
    public T getElemento() {
        return elemento;
    }

    /**
     * @param elemento the elemento to set
     */
    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    /**
     * @return the proximo
     */
    public NodoGenerico<T> getProximo() {
        return proximo;
    }

    /**
     * @param proximo the proximo to set
     */
    public void setProximo(NodoGenerico<T> proximo) {
        this.proximo = proximo;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {

        NodoGenerico<T> nodo = (NodoGenerico<T>) obj;
        return this.elemento.equals(nodo.getElemento());
    }


    /**
     * @return the identificador
     */
    public long getIdentificador() {
        return identificador;
    }


    /**
     * @param identificador the identificador to set
     */
    public void setIdentificador(long identificador) {
        this.identificador = identificador;
    }
}
