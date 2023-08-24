package br.study.mixing.base64.grouping.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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
    void should() {
    }

    @ParameterizedTest
    @MethodSource("sourceAdd")
    void shouldAddWhenIndexIsFull(String source, String expected, List<String> list) {
    }

    private static Stream<Arguments> sourceAdd() {
        var emptyList = new ArrayList<>();

        var listWithTwo = new ArrayList<>(List.of("01"));
        var listWithSix = new ArrayList<>(List.of("012345"));

        var listWithSixAndTwo = new ArrayList<>(List.of("012345", "67"));

        return Stream.of(
            Arguments.of( SEQUENCE_OF_EIGHT, "012345 67", emptyList),
            Arguments.of(SEQUENCE_OF_EIGHT_LETTER, "01abcd ef", listWithTwo),
            Arguments.of(SEQUENCE_OF_EIGHT_LETTER, "012345 abcdef gh", listWithSix)
//            Arguments.of(SEQUENCE_OF_EIGHT_LETTER, "012345 67abcf", listWithSixAndTwo)
        );
    }
}