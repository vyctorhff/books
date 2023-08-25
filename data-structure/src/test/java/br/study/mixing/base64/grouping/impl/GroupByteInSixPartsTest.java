package br.study.mixing.base64.grouping.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.platform.commons.util.StringUtils;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class GroupByteInSixPartsTest {

    private GroupByteInSixParts sut;

    @BeforeEach
    void setup() {
        this.sut = new GroupByteInSixParts();
    }

    @ParameterizedTest
    @MethodSource("sourceGroupParts")
    void shouldGroupParts(String input, String expected) {
        String result = sut.process(input);

        assertTrue(StringUtils.isNotBlank(result));
        assertEquals(expected, result);
    }

    private static Stream<Arguments> sourceGroupParts() {
        return Stream.of(
            Arguments.of("00000000", "000000 000000"),
            Arguments.of("00000000 00000000", "000000 000000 000000"),
            Arguments.of("00000000 00000000 00000000", "000000 000000 000000 000000")
        );
    }
}