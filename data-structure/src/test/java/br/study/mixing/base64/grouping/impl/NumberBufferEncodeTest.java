package br.study.mixing.base64.grouping.impl;

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
class NumberBufferEncodeTest {

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
        var numberBuffer = helper.createEncodeWithValues(input);
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
    void shouldPackSixCharacter() {
        var numberBuffer = helper.createEncodeWithSixValues();

        assertFalse(numberBuffer.getList().isEmpty());
    }

    @Test
    void shouldPackWithZerosWhenFourNumber() {
        var numberBuffer = helper.createEncodeWithFourValues();

        numberBuffer.adjustes();
        assertEquals("012300", numberBuffer.getList().get(0));
    }

    @Test
    void shouldPackWithZerosWhenTwoNumber() {
        var numberBuffer = helper.createEncodeWithValues('0', '1');

        numberBuffer.adjustes();
        assertEquals("010000", numberBuffer.getList().get(0));
    }

    @Test
    void shouldPackSixButNotTwoNext() {
        var numberBuffer = helper.createEncodeWithSixValues();

        assertFalse(numberBuffer.getList().isEmpty());
        assertEquals(1, numberBuffer.getList().size());

        numberBuffer.add('6');
        numberBuffer.add('7');

        assertEquals(1, numberBuffer.getList().size());
    }
}