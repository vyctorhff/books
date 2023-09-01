package br.study.mixing.base64;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({MockitoExtension.class})
class DecodeInputTest {

    @ParameterizedTest
    @MethodSource("souceBePaddingByParams")
    void shouldBePaddingByParams(String base64Code, Base64Padding expected) {
        var decodeInput = new DecodeInput(base64Code);
        assertEquals(expected, decodeInput.getPadding());
    }

    static Stream<Arguments> souceBePaddingByParams() {
        return Stream.of(
            Arguments.of("AjKenaER", Base64Padding.NONE),
            Arguments.of("AjKenaER=", Base64Padding.SINGLE),
            Arguments.of("AjKenaER==", Base64Padding.DOUBLE)
        );
    }
}
