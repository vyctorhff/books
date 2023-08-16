package br.study.mixing.base64.grouping.impl;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.platform.commons.util.StringUtils;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class GroupByteInSixPartsTest {

    private GroupByteInSixParts sut;

    @ParameterizedTest
    @MethodSource("sourceGroupParts")
    void shouldGroupParts(String input, String expected) {
        String result = sut.process(input);

        assertFalse(StringUtils.isNotBlank(result));
        assertEquals(expected, result);
    }

    private static Stream<Arguments> sourceGroupParts() {
        return Stream.of(
            Arguments.of("00000000", "000000 00"),
            Arguments.of("00000000 00000000", "000000 000000 0000"),
            Arguments.of("00000000 00000000 00000000", "000000 000000 000000 000000")
        );
    }
}