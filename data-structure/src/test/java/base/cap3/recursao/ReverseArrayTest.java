package base.cap3.recursao;

import br.study.base.cap3.recursao.ReverseArray;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseArrayTest {

    private ReverseArray reverseArray;

    @BeforeEach
    void setup() {
        this.reverseArray = new ReverseArray();
    }

    @ParameterizedTest
    @MethodSource("sourceReverse")
    void testReverse(int[] array) {
        int[] reverso = this.reverseArray.process(array);

        assertEquals(array.length, reverso.length);

        var expected = array.clone();
        ArrayUtils.reverse(expected);

        assertArrayEquals(expected, reverso);
    }

    private static Stream<Arguments> sourceReverse() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}),
            Arguments.of(new int[]{7, 6, 5, 4, 3, 2, 1}),
            Arguments.of(new int[]{4, 1, 6, 3, 5, 7, 2}),
            Arguments.of(new int[]{7, 7, 7, 7, 7, 7, 7})
        );
    }
}