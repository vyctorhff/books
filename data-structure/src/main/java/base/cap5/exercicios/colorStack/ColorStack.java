/*
 * Created on 23/02/2011, 16:08:51
 * Locate at Natal, Rio Grande do Norte
 *
 * PilhaAzul.java
 *
 * @autor torugo
 */
package base.cap5.exercicios.colorStack;

public interface ColorStack<T> {

    void push(T element, ColorStackEnum color);

    T pop(ColorStackEnum color);

    T top(ColorStackEnum color);

    boolean isEmpty(ColorStackEnum color);

    boolean isFull(ColorStackEnum color);

    int size(ColorStackEnum color);

}