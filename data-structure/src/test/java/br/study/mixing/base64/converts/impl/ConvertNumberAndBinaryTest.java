package br.study.mixing.base64.converts.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        // TODO: IMPLEMENT IT
    }

    static Stream<Arguments> sourceConvertToNumberResult() {
        return Stream.of(
            Arguments.of()
        );
    }
}