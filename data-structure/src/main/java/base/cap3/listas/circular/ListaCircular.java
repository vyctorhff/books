/*
 * Created on 16/02/2011, 15:14:30
 * Locate at Natal, Rio Grande do Norte
 *
 * ListaCircular.java
 *
 * @autor torugo
 */
package base.cap3.listas.circular;

public class ListaCircular {

    //Nao e um elemento, funciona com um sentinela de lista duplamente enc.
    private NodoCircular cursor;

    public void inserir(NodoCircular nodoInsercao) {

        if (nodoInsercao == null) {
            throw new IllegalArgumentException("No invalido");
        }

        if (cursor == null) {
            cursor = nodoInsercao;
            nodoInsercao.setProximo(nodoInsercao);

        } else {
            NodoCircular nodo = cursor.getProximo();
            cursor.setProximo(nodoInsercao);

            nodoInsercao.setProximo(nodo);
        }
    }

    public void avancar() {
        if (cursor == null)
            throw new IllegalStateException("A lista esta vazia");

        cursor = cursor.getProximo();
    }

    public NodoCircular remover() {

        if (cursor == null) {
            return null;
        }

        NodoCircular nodoRemovido = cursor.getProximo();

        //No caso da lista possuir 1 elemento
        if (cursor.getNome().equals(nodoRemovido.getNome())) {
            cursor = null;
        } else {
            cursor.setProximo(nodoRemovido.getProximo());
            nodoRemovido.setProximo(null);
        }

        return nodoRemovido;
    }

    public String getElementoCursor() {
        return cursor.getProximo().getNome();
    }
}
