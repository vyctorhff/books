/*
 * Created on 17/06/2011, 14:49:15
 * Locate at Natal, Rio Grande do Norte
 *
 * ListaArranjo.java
 *
 * @autor torugo
 */
package base.cap6.listas;

/**
 * TAD lista implementada com um arranjo dinamico.
 */
public class ListaArranjo<T> implements Lista<T> {

    private final int TAMANHO_INCIAL = 10;
    private Object arranjo[];
    private int numeroElementos;

    // Indice do ultimo elemento do arranjo.
    private int posicaoAtual;


    public ListaArranjo() {
        arranjo = new Object[TAMANHO_INCIAL];

        numeroElementos = 0;
    }


    @Override
    public int size() {
        return numeroElementos;
    }


    @Override
    public boolean isEmpty() {
        return numeroElementos == 0;
    }


    @SuppressWarnings("unchecked")
    @Override
    public T get(int indice) throws Exception {

        if (this.isEmpty())
            throw new IllegalStateException("Lista vazia");

        if (indice < 0 || indice > arranjo.length)
            throw new IllegalArgumentException("Indice invalido!");


        return (T) arranjo[indice];
    }


    @SuppressWarnings("unchecked")
    @Override
    public T set(int indice, T elemento) throws Exception {

        if (isEmpty() || indice >= arranjo.length)
            throw new IllegalArgumentException("Indice invalido");


        if (indice >= arranjo.length)
            this.dobraTamanhoArranjo();


        Object objeto = arranjo[indice];
        arranjo[indice] = elemento;


        return (T) objeto;
    }


    @Override
    public void add(int indice, T elemento) throws Exception {

        if (indice > arranjo.length)
            this.dobraTamanhoArranjo();


        // Verifica se a posicao ja esta ocupada.
        if (arranjo[indice] != null)
            this.fastarElementosPorIndice(indice);


        arranjo[indice] = elemento;

        numeroElementos++;

        // Configura para o ultimo indice do arranjo.
        if (posicaoAtual < indice)
            posicaoAtual = indice;
    }


    @SuppressWarnings("unchecked")
    @Override
    public T remove(int indice) throws Exception {

        if (isEmpty() || indice >= arranjo.length)
            throw new IllegalArgumentException("Indice invalido");


        Object objeto = arranjo[indice];
        arranjo[indice] = null;


        numeroElementos--;


        return (T) objeto;
    }


    /**
     * Fastar todos os elementos para a proxima posicao a partir
     * de um indice.
     *
     * @param indice
     */
    private void fastarElementosPorIndice(int indice) {

        if (indice >= arranjo.length || isEmpty())
            throw new IllegalArgumentException("Indice invalido!");


        int cont = posicaoAtual;

        while (cont >= indice) {

            if (arranjo[cont] != null)
                arranjo[cont + 1] = arranjo[cont]; // Coloca o elemento atual para uma posicao a frente.

            cont--;
        }
    }


    /**
     * Aumenta o tamanho do arranjo para o seu dobro.
     */
    private void dobraTamanhoArranjo() {

        Object novoArranjo[] = new Object[arranjo.length * 2];

        for (int cont = 0; cont < arranjo.length; cont++)
            novoArranjo[cont] = arranjo[cont];

        arranjo = novoArranjo;
    }

}
