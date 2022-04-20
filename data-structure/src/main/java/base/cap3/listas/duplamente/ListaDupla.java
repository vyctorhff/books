/*
 * Created on 16/02/2011, 12:44:16
 * Locate at Natal, Rio Grande do Norte
 *
 * ListaDupla.java
 *
 * @autor torugo
 */
package base.cap3.listas.duplamente;

import lombok.Data;

/**
 * Implementação de uma lista duplamente encadeada.
 */
@Data
public class ListaDupla {

    private int numeroElementos;

    /*
     * Sentinelas da lista, nao possuem elementos, mas apenas referencias para o
     * proximo ou o anterior.
     */
    private NodoDuplo cabeca, calda;


    public ListaDupla() {
        cabeca = new NodoDuplo();
        calda = new NodoDuplo();
    }


    public void inserirCabeca(int elemento) {
        NodoDuplo nodoInserido = new NodoDuplo(elemento);

        if (cabeca.getProximo() == null) {
            this.configuraReferenciaInsercaoCabeca(cabeca, calda, nodoInserido);

        } else {
            NodoDuplo nodo = cabeca.getProximo();
            this.configuraReferenciaInsercaoCabeca(cabeca, nodo, nodoInserido);
        }

        numeroElementos++;
    }


    /**
     * Configura o novo nodo como sendo o primeiro, o antigo primeiro como sendo o proximo elemento
     * do nodo novo, ou seja, como segundo da lista.
     *
     * @param primeiro
     * @param aposPrimeiro
     * @param nodoInserido
     */
    private void configuraReferenciaInsercaoCabeca(NodoDuplo primeiro, NodoDuplo aposPrimeiro, NodoDuplo nodoInserido) {
        primeiro.setProximo(nodoInserido);

        nodoInserido.setAnterior(primeiro);
        nodoInserido.setProximo(aposPrimeiro);

        aposPrimeiro.setAnterior(nodoInserido);
    }


    public void inserirCalda(int elemento) {

        NodoDuplo nodoInserido = new NodoDuplo(elemento);

        if (calda.getAnterior() == null) {
            this.configuraReferenciaInsercaoCalda(cabeca, calda, nodoInserido);

        } else {
            NodoDuplo nodo = calda.getAnterior();
            this.configuraReferenciaInsercaoCalda(nodo, calda, nodoInserido);
        }

        numeroElementos++;
    }


    /**
     * Configura o novo node como sendo o ultimo, e aponta o antigo ultimo para como sendo o
     * penultimo, ou seja, faz o antigo ultimo apontar para o novo ultimo.
     *
     * @param antePenultimo
     * @param ultimo
     * @param nodoInserido
     */
    private void configuraReferenciaInsercaoCalda(NodoDuplo antePenultimo, NodoDuplo ultimo, NodoDuplo nodoInserido) {
        ultimo.setAnterior(nodoInserido);

        nodoInserido.setProximo(ultimo);
        nodoInserido.setAnterior(antePenultimo);

        antePenultimo.setProximo(nodoInserido);
    }

    public void inserirAposElemento(int elementoProcurado, int elementoInsercao) {

        NodoDuplo nodoProcurado = procurarByElemento(elementoProcurado);

        if (nodoProcurado == null)
            throw new IllegalArgumentException("Elemento nao encontrado");

        NodoDuplo nodoInsercao = new NodoDuplo(elementoInsercao);

        nodoInsercao.setAnterior(nodoProcurado);
        nodoInsercao.setProximo(nodoProcurado.getProximo());

        nodoProcurado.getProximo().setAnterior(nodoInsercao);
        nodoProcurado.setProximo(nodoInsercao);

        numeroElementos++;
    }

    public NodoDuplo procurarByElemento(int elemento) {
        NodoDuplo nodo = cabeca;

        do {
            if (nodo == null)
                break;

            if (elemento == nodo.getElemento())
                break;

            nodo = nodo.getProximo();

        } while (true);

        return nodo;
    }

    public void removerByElemento(int elemento) {

        NodoDuplo nodoProcurado = procurarByElemento(elemento);
        if (nodoProcurado == null)
            throw new IllegalArgumentException("Elemento nao encontrado");


        nodoProcurado.getAnterior().setProximo(nodoProcurado.getProximo());
        nodoProcurado.getProximo().setAnterior(nodoProcurado.getAnterior());

        nodoProcurado.setAnterior(null);
        nodoProcurado.setProximo(null);

        numeroElementos--;
    }

}
