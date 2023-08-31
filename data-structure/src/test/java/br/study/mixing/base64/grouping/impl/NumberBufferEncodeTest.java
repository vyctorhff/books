package br.study.mixing.base64.grouping.impl;

import br.study.mixing.base64.grouping.buffers.NumberBuffer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class NumberBufferTest {

    // for testing, i will put any number not binary
    private static final String SEQUENCE_OF_EIGHT = "01234567";

    // for testing, i will put any number not binary
    private static final String SEQUENCE_OF_EIGHT_LETTER = "abcdefgh";

    @BeforeEach
    void setUp() {
    }

    @Test
    void shouldBeEmptyListWhenNotWasAdded() {
        var numberBuffer = new NumberBuffer();
        assertTrue(numberBuffer.getList().isEmpty());
    }

    @Test
    void shouldPackSixCharacter() {
        var numberBuffer = createNumberBufferWithValues(
            '0', '1', '2', '3', '4', '5'
        );

        assertFalse(numberBuffer.getList().isEmpty());
    }

    @Test
    void shouldNotPackFourCharacter() {
        var numberBuffer = createNumberBufferWithValues(
            '0', '1', '2', '3', '4'
        );

        assertTrue(numberBuffer.getList().isEmpty());
    }

    @Test
    void shouldNotPackSixEmptySpace() {
        var numberBuffer = createNumberBufferWithValues(' ', ' ', ' ', ' ', ' ', ' ');

        assertTrue(numberBuffer.getList().isEmpty());
    }

    @Test
    void shouldPackWithZerosWhenFourNumber() {
        var numberBuffer = createNumberBufferWithValues('0', '1', '2', '3');

        numberBuffer.adjustes();
        assertEquals("012300", numberBuffer.getList().get(0));
    }

    @Test
    void shouldPackWithZerosWhenTwoNumber() {
        var numberBuffer = createNumberBufferWithValues('0', '1');

        numberBuffer.adjustes();
        assertEquals("010000", numberBuffer.getList().get(0));
    }

    @Test
    void shouldPackSixButNotTwoNext() {
        var numberBuffer = createNumberBufferWithValues(
            '0', '1', '2', '3', '4', '5'
        );

        assertFalse(numberBuffer.getList().isEmpty());
        assertEquals(1, numberBuffer.getList().size());

        numberBuffer.add('6');
        numberBuffer.add('7');

        assertEquals(1, numberBuffer.getList().size());
    }

    private NumberBuffer createNumberBufferWithValues(char... arrayChar) {
        var numberBuffer = new NumberBuffer();

        for (char value : arrayChar) {
            numberBuffer.add(value);
        }

        return numberBuffer;
    }
}