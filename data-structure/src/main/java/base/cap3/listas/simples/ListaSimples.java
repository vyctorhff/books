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

    private int size;

    private SimpleNode head;

    public void insertHead(int elemento) {

        if (head == null) {
            head = new SimpleNode(elemento);
        } else {
            SimpleNode no = new SimpleNode(elemento);

            no.setProximo(head);
            head = no;
        }

        size++;
    }

    public void insertAfter(int elementoProcurado, int elementoInsercao) {

        var nodoProcurado = findNodeByElement(elementoProcurado);

        if (nodoProcurado != null) {
            var nodoInsercao = new SimpleNode(elementoInsercao);

            nodoInsercao.setProximo(nodoProcurado.getProximo());
            nodoProcurado.setProximo(nodoInsercao);

            size++;
        } else {
            throw new IllegalArgumentException("Elemento nao encontrado na lista");
        }
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
    public SimpleNode findNodeByElement(int elemento) {
        SimpleNode nodo = head;

        while (true) {
            if (nodo == null) break;

            if (elemento == nodo.getElemento()) break;

            nodo = nodo.getProximo();
        }

        return nodo;
    }

    public int removeHead() {
        if (head == null) {
            throw new IllegalStateException("Empty list");
        }

        var removed = head;
        head = head.getProximo();

        size--;
        return removed.getElemento();
    }

    public void removerNodoByElemento(int elemento) {

        if (head == null) {
            throw new IllegalArgumentException("Remocao invalida por a lista esta vazia!");
        }

        //Remocao quando o elemento estiver no cabeca.
        if (elemento == head.getElemento()) {
            SimpleNode nodo = head.getProximo();
            head.setProximo(null);

            head = nodo;
        }

        SimpleNode nodo = head.getProximo();
        SimpleNode anteriorAoElemento = head;

        while (true) {

            if (nodo == null) break;

            if (elemento == nodo.getElemento()) {

                anteriorAoElemento.setProximo(nodo.getProximo());
                nodo.setProximo(null);

                break;
            }

            anteriorAoElemento = nodo;
            nodo = nodo.getProximo();
        }

        if (nodo == null) {
            throw new IllegalArgumentException("Elemento nao encontrado!");
        }

        size--;
    }

    public void substituirElemento(int elementoAntigo, int elementoNovo) {
        SimpleNode nodo = findNodeByElement(elementoAntigo);

        if (nodo == null) {
            throw new IllegalArgumentException("Elemento nao encontrado!");
        }

        nodo.setElemento(elementoNovo);
    }

    public void sort() {
        var count = 0;


        while (count < (size * 2)) {

            var nodo = head;

            while (nodo.getProximo() != null) {
                if (nodo.getElemento() > nodo.getProximo().getElemento()) {
                    swapElement(nodo, nodo.getProximo());
                }

                nodo = nodo.getProximo();
            }

            count++;
        }
    }

    private void swapElement(SimpleNode nodo, SimpleNode proximo) {
        var value = nodo.getElemento();

        nodo.setElemento(proximo.getElemento());
        proximo.setElemento(value);
    }

    public SimpleNode getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

}
