/*
 * Created on 23/02/2011, 10:26:33
 * Locate at Natal, Rio Grande do Norte
 *
 * PilhaArranjo.java
 *
 * @autor torugo
 */
package base.cap5.pilhas;

/**
 * Implementacao de um pilha usando arranjo.
 */
public class PilhaArranjo<T> implements Pilha<T> {

    private final int INDICE_PILHA_VAZIA = -1;

    private final Object[] arranjoPilha;
    private int indiceAtual;
    private final int tamanhoPilha;

    public PilhaArranjo(int tamanho) {
        arranjoPilha = new Object[tamanho];
        tamanhoPilha = tamanho;

        indiceAtual = INDICE_PILHA_VAZIA;
    }

    @Override
    public void push(T objeto) {
        if (isFull()) {
            throw new IllegalStateException("A pilha esta cheia");
        }

        arranjoPilha[++indiceAtual] = objeto;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Pilha vazia");
        }

        Object objeto = arranjoPilha[indiceAtual];

        arranjoPilha[indiceAtual] = null;
        indiceAtual--;

        return (T) objeto;
    }

    @Override
    public T top() {
        if (isEmpty()) {
            throw new IllegalStateException("Pilha vazia");
        }

        return (T) arranjoPilha[indiceAtual];
    }

    @Override
    public int size() {
        return indiceAtual + 1;
    }

    @Override
    public boolean isEmpty() {
        return indiceAtual == INDICE_PILHA_VAZIA;
    }

    @Override
    public boolean isFull() {
        return indiceAtual == tamanhoPilha - 1;
    }

    public Object[] getArranjoPilha() {
        return arranjoPilha;
    }

    public int getIndice() {
        return indiceAtual;
    }
}
