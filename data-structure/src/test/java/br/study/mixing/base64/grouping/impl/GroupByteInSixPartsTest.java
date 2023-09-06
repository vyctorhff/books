package br.study.mixing.base64.grouping.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(MockitoExtension.class)
class GroupByteInSixPartsTest {

    private GroupByteInSixParts sut;

    @BeforeEach
    void setup() {
        this.sut = new GroupByteInSixParts();
    }

    @ParameterizedTest
    @MethodSource("sourceGroupParts")
    void shouldGroupParts(String input, List<String> expected) {
        List<String> result = sut.process(input);

        assertFalse(result.isEmpty());
        assertArrayEquals(expected.toArray(), result.toArray());
    }

    private static Stream<Arguments> sourceGroupParts() {
        String zerosSix = "000000";

        return Stream.of(
            Arguments.of("00000000", List.of(zerosSix, zerosSix)),
            Arguments.of("00000000 00000000", List.of(zerosSix, zerosSix, zerosSix)),
            Arguments.of("00000000 00000000 00000000", List.of(zerosSix, zerosSix, zerosSix, zerosSix))
        );
    }
}