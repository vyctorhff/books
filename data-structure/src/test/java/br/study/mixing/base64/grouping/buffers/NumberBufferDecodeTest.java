package br.study.mixing.base64.grouping.buffers;

import br.study.mixing.base64.DecodeInput;
import helpers.NumberBufferTestHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class NumberBufferDecodeTest {

    // for testing, i will put any number not binary
    private static final String SEQUENCE_OF_EIGHT = "01234567";

    // for testing, i will put any number not binary
    private static final String SEQUENCE_OF_EIGHT_LETTER = "abcdefgh";

    private static NumberBufferTestHelper helper;

    @BeforeAll
    static void beforeAll() {
        helper = new NumberBufferTestHelper();
    }

    @BeforeEach
    void setUp() {
    }

    @ParameterizedTest
    @MethodSource("sourceResultEmptyList")
    void shouldResultEmptyList(char[] input) {
        var numberBuffer = helper.createDecodeWithValues(input);
        assertTrue(numberBuffer.getList().isEmpty());
    }

    static Stream<Arguments> sourceResultEmptyList() {
        var inputWithNonde = new char[] {};
        var inputWithFour = new char[] {'0', '1', '2', '3', '4'};
        var inputWithEmpty = new char[] {' ', ' ', ' ', ' ', ' ', ' '};

        return Stream.of(
            Arguments.of(inputWithNonde),
            Arguments.of(inputWithFour),
            Arguments.of(inputWithEmpty)
        );
    }

    @Test
    void shouldCreateOneGroupOfEight() {
        var numberBuffer = helper.createDecodeWithValues(new char[]{
            '0', '1', '2', '3', '4', '5',
            ' ',
            'a', 'b', 'c', 'd', 'e', 'f'
        });

        assertEquals("012345ab", numberBuffer.getList().get(0));
        assertEquals(1, numberBuffer.getList().size());
    }

    @Test
    void shouldCreateTwoGroupOfEight() {
        var numberBuffer = helper.createDecodeWithValues(new char[]{
            '0', '1', '2', '3', '4', '5',
            ' ',
            'a', 'b', 'c', 'd', 'e', 'f',
            ' ',
            'g', 'h', 'i', 'j', '0', '0'
        });

        assertEquals("012345ab", numberBuffer.getList().get(0));
        assertEquals("cdefghij", numberBuffer.getList().get(1));
    }

    @Test
    void shouldThrowErrorIfNotZerosLeft() {
        var numberBuffer = helper.createDecodeWithValues(new char[]{
            '0', '1', '2', '3', '4', '5',
            ' ',
            'g', 'h', 'i', 'j', '*', '#'
        });

        assertThrows(IllegalArgumentException.class, () -> {
            numberBuffer.adjustes();
        });
    }

    @Test
    void shouldThrowErrorIfFourZerosWhenOnePadding() {
        DecodeInput input = new DecodeInput("ScEaQB=");
        var numberBuffer = helper.createDecodeWithValues(input, new char[]{
            '0', '1', '2', '3', '4', '5',
            ' ',
            'g', 'h', '0', '0', '0', '0',
        });

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            numberBuffer.adjustes();
        });

        assertEquals("number of padding is differente", exception.getMessage());
    }

    @Test
    void shouldThrowErrorIfTwoZerosWhenTwoPaddingPadding() {
    }
}