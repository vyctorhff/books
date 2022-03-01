/*
 * Created on 15/02/2011, 21:40:56
 * Locate at Natal, Rio Grande do Norte
 *
 * ListaSimples.java
 *
 * @autor torugo
 */
package base.cap3.listas.simples;

/**
 * Lista simplesmente encadeada.
 */
public class ListaSimples {

    private int numeroElementos;

    private NodoSimples cabeca;

    public void inserirCabeca(int elemento) {

        if (cabeca == null)
            cabeca = new NodoSimples(elemento);
        else {
            NodoSimples no = new NodoSimples(elemento);

            no.setProximo(cabeca);
            cabeca = no;
        }

        numeroElementos++;
    }

    public void inserirOrdenada(int elemento) {
    }

    public void inserirElementoApos(int elementoProcurado, int elementoInsercao) {

        NodoSimples nodoProcurado = procurarNodoByElemento(elementoProcurado);


        if (nodoProcurado != null) {
            NodoSimples nodoInsercao = new NodoSimples(elementoInsercao);

            nodoInsercao.setProximo(nodoProcurado.getProximo());
            nodoProcurado.setProximo(nodoInsercao);

            numeroElementos++;
        } else
            throw new IllegalArgumentException("Elemeneto nao encontrado na lista");
    }

    /**
     * Metodo que pesquisa por um elemento na lista e retorna o no contendo
     * o elemento.
     * <p>
     * Caso nao encontre, retorna null.
     *
     * @param elemento
     * @return
     */
    public NodoSimples procurarNodoByElemento(int elemento) {

        NodoSimples nodo = cabeca;

        while (true) {

            if (nodo == null)
                break;


            if (elemento == nodo.getElemento())
                break;


            nodo = nodo.getProximo();
        }

        return nodo;
    }

    public void removerNodoByElemento(int elemento) {

        if (cabeca == null)
            throw new IllegalArgumentException("Remocao invalida por a lista esta vazia!");

        //Remocao quando o elemento estiver no cabeca.
        if (elemento == cabeca.getElemento()) {
            NodoSimples nodo = cabeca.getProximo();
            cabeca.setProximo(null);

            cabeca = nodo;
        }

        NodoSimples nodo = cabeca.getProximo();
        NodoSimples anteriorAoElemento = cabeca;

        while (true) {

            if (nodo == null)
                break;

            if (elemento == nodo.getElemento()) {

                anteriorAoElemento.setProximo(nodo.getProximo());
                nodo.setProximo(null);

                break;
            }

            anteriorAoElemento = nodo;
            nodo = nodo.getProximo();
        }

        if (nodo == null)
            throw new IllegalArgumentException("Elemento nao encontrado!");

        numeroElementos--;
    }

    public void substituirElemento(int elementoAntigo, int elementoNovo) {

        NodoSimples nodo = procurarNodoByElemento(elementoAntigo);

        if (nodo != null)
            nodo.setElemento(elementoNovo);
        else
            throw new IllegalArgumentException("Elemento nao encontrado!");
    }

    public void ordenarLista() {
    }

    public NodoSimples getCabeca() {
        return cabeca;
    }

    public int getNumeroElementos() {
        return numeroElementos;
    }

}
