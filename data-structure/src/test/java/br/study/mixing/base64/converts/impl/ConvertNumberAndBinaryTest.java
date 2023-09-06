package br.study.mixing.base64.converts.impl;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith({MockitoExtension.class})
class ConvertNumberAndBinaryTest {

    private ConvertNumberAndBinary sut;

    @BeforeEach
    void setup() {
        this.sut = new ConvertNumberAndBinary();
    }

    @ParameterizedTest
    @MethodSource("sourceConvertToBinaryForResult")
    void shouldConvertForResult(int value, String expected) {
        var result = this.sut.convertToBinary(value);
        assertEquals(expected, result);
    }

    static Stream<Arguments> sourceConvertToBinaryForResult() {
        return Stream.of(
            Arguments.of(0, "00000000"),
            Arguments.of(1, "00000001"),
            Arguments.of(3, "00000011"),
            Arguments.of(255, "11111111")
        );
    }

    @ParameterizedTest
    @MethodSource("sourceConvertToNumberResult")
    void shouldConvertToBinaryForResult(String binary, int expected) {
        var result = this.sut.convertToNumber(binary);
        assertEquals(expected, result);
    }

    static Stream<Arguments> sourceConvertToNumberResult() {
        return Stream.of(
            Arguments.of("00000000", 0),
            Arguments.of("00000001", 1),
            Arguments.of("00000011", 3),
            Arguments.of("11111111", 255)
        );
    }

    @ParameterizedTest
    @MethodSource("sourceErrorWhenInvalidNumber")
    void shouldErrorWhenInvalidNumber(String input) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            this.sut.convertToNumber(input);
        });

        assertEquals("Invalid to convert: " + input, e.getMessage());
    }

    static Stream<Arguments> sourceErrorWhenInvalidNumber() {
        return Stream.of(
            Arguments.of(StringUtils.EMPTY),
            Arguments.of(StringUtils.SPACE)
        );
    }

    @ParameterizedTest
    @MethodSource("sourceErrorWhenValueIsNotSixOrEigth")
    void shouldErrorWhenValueIsNotSixOrEigth(String input) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            this.sut.convertToNumber(input);
        });

        assertEquals("Invalid size bit: " + input, e.getMessage());
    }

    static Stream<Arguments> sourceErrorWhenValueIsNotSixOrEigth() {
        return Stream.of(
            Arguments.of("00"),
            Arguments.of("0000"),
            Arguments.of("00000"),
            Arguments.of("0000000"),
            Arguments.of("00000000000")
        );
    }
}