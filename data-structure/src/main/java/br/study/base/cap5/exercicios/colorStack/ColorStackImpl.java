/*
 * Created on 23/02/2011, 15:53:21
 * Locate at Natal, Rio Grande do Norte
 *
 * PilhaAzulVermelha.java
 *
 * @autor torugo
 */
package br.study.base.cap5.exercicios.colorStack;

import br.study.base.cap5.pilhas.Pilha;

public class ColorStackImpl<T> implements ColorStack<T> {

    private final ColorAndStack[] colorAndStacks;

    public ColorStackImpl(ColorAndStack[] colorAndStacks) {
        this.colorAndStacks = colorAndStacks;
    }

    @Override
    public void push(T element, ColorStackEnum color) {
        findStackByColor(color).push(element);
    }

    @Override
    public T pop(ColorStackEnum color) {
        return findStackByColor(color).pop();
    }

    @Override
    public T top(ColorStackEnum color) {
        return findStackByColor(color).top();
    }

    @Override
    public boolean isEmpty(ColorStackEnum color) {
        return findStackByColor(color).isEmpty();
    }

    @Override
    public boolean isFull(ColorStackEnum color) {
        return findStackByColor(color).isFull();
    }

    @Override
    public int size(ColorStackEnum color) {
        return findStackByColor(color).size();
    }

    private Pilha<T> findStackByColor(ColorStackEnum color) {
        for (ColorAndStack colorAndStack : colorAndStacks) {

            if (colorAndStack.color().equals(color)) {
                return colorAndStack.pilha();
            }
        }

        throw new IllegalArgumentException("Stack does not exist");
    }
}
