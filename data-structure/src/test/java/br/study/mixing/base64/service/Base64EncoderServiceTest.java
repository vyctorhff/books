package br.study.mixing.base64.service;

import br.study.mixing.base64.Base64Exception;
import br.study.mixing.base64.converts.ConvertStringAndNumber;
import br.study.mixing.base64.converts.impl.ConvertNumberAndBinary;
import br.study.mixing.base64.converts.impl.ConvertStringAndNumberImpl;
import br.study.mixing.base64.grouping.GrouppingBytes;
import br.study.mixing.base64.grouping.impl.GroupByteInSixParts;
import br.study.mixing.base64.table.unicode.UnicodeTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({MockitoExtension.class})
class Base64EncoderServiceTest {

    @InjectMocks
    private Base64EncoderService sut;

    private GrouppingBytes grouping;

    private ConvertStringAndNumber convertStringAndNumber;

    private ConvertNumberAndBinary convertNumberAndBinary;

    @BeforeEach
    void setUp() {
        this.grouping = new GroupByteInSixParts();

        this.convertStringAndNumber = new ConvertStringAndNumberImpl(new UnicodeTable());

        this.convertNumberAndBinary = new ConvertNumberAndBinary();

        sut = new Base64EncoderService(
            grouping,
            convertStringAndNumber,
            convertNumberAndBinary
        );
    }

    @ParameterizedTest
    @MethodSource("sourceEncodeSuccessfuly")
    void shouldEncodeSuccessfuly(String input, String expect) throws Base64Exception {
        var result = sut.procss(input);
        assertEquals(expect, result);
    }

    private static Stream<Arguments> sourceEncodeSuccessfuly() {
        return Stream.of(
            Arguments.of("victor", "dmljdG9y")
        );
    }
}