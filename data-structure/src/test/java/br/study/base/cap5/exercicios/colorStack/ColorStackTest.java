/*
 * Created on 28/02/2022, 16:30:33
 * Locate at Parnamirim, Rio Grande do Norte
 *
 * PilhaAzulTest.java
 *
 * @autor torugo
 */
package br.study.base.cap5.exercicios.colorStack;

import br.study.base.cap5.exercicios.colorStack.ColorAndStack;
import br.study.base.cap5.exercicios.colorStack.ColorStackEnum;
import br.study.base.cap5.exercicios.colorStack.ColorStackImpl;
import br.study.base.cap5.pilhas.Pilha;
import br.study.base.cap5.pilhas.PilhaArranjo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ColorStackTest {

    private static final int DEFAULT_STACK_SIZE = 10;

    private static Pilha<String> pilha;

    @BeforeAll
    public static void setupAll() {
        pilha = new PilhaArranjo<>(DEFAULT_STACK_SIZE);
    }

    @Test
    void testInitClass() {
        var colorStack = new ColorStackImpl<String>(new ColorAndStack[]{
            new ColorAndStack<>(pilha, ColorStackEnum.BLUE),
            new ColorAndStack<>(pilha, ColorStackEnum.RED)
        });

        assertNotNull(colorStack);
    }

    @Test
    void testStackColorOperation() {
        var colorStack = new ColorStackImpl<String>(new ColorAndStack[]{
            new ColorAndStack<>(pilha, ColorStackEnum.BLUE),
            new ColorAndStack<>(pilha, ColorStackEnum.RED)
        });

        colorStack.push("aaa", ColorStackEnum.BLUE);
        var element = colorStack.pop(ColorStackEnum.BLUE);

        assertEquals("aaa", element);
        assertTrue(colorStack.isEmpty(ColorStackEnum.BLUE));
        assertFalse(colorStack.isFull(ColorStackEnum.BLUE));
    }
}
