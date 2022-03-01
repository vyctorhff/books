package base.cap3.exercicios.criptografia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayCharacterMergeTest {

    private ArrayCharacterMerge merge;

    @Test
    void testMergeArrayDestinyEmpty() {
        char[] source = new char[]{'a', 'b', 'c'};
        char[] destiny = new char[]{};

        executActionAndTest(source, destiny, source);
    }

    @Test
    void testMergeArrayDestinyWithOneElement() {
        char[] source = new char[]{'a', 'b', 'c'};
        char[] destiny = new char[]{'b'};
        char[] expeted = new char[]{'a', 'c'};

        executActionAndTest(source, destiny, expeted);
    }

    @Test
    void testMergeArraySourceEmpty() {
        char[] source = new char[]{};
        char[] destiny = new char[]{'a', 'b', 'c'};

        executActionAndTest(source, destiny, destiny);
    }

    private void executActionAndTest(char[] source, char[] destiny, char[] expeted) {
        merge = new ArrayCharacterMerge(source, destiny);
        var result = merge.merge();

        Assertions.assertArrayEquals(expeted, result);
    }
}