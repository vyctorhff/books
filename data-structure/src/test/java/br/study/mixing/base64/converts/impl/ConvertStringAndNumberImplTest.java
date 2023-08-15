package br.study.mixing.base64.converts.impl;

import br.study.mixing.base64.Base64Exception;
import br.study.mixing.base64.unicode.UnicodeInfo;
import br.study.mixing.base64.unicode.UnicodeTable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConvertStringAndNumberImplTest {

    public static final UnicodeInfo UNICODE_INFO =
        new UnicodeInfo(2, 'A');

    public static final Optional<UnicodeInfo> UNICODE_INFO_OPT =
        Optional.of(UNICODE_INFO);

    @InjectMocks
    private ConvertStringAndNumberImpl sut;

    @Mock
    private UnicodeTable unicodeTable;

    @BeforeEach
    void setup() {
        this.sut = new ConvertStringAndNumberImpl(unicodeTable);
    }

    @Test
    void shouldConvertStringToCodeSuccessfully() throws Base64Exception {
        when(unicodeTable.findByCharacter(UNICODE_INFO.getCharacterAsString()))
            .thenReturn(UNICODE_INFO_OPT);

        int code = this.sut.convert(UNICODE_INFO.getCharacterAsString());
        Assertions.assertEquals(UNICODE_INFO.getCodeAsInteger(), code);
    }

    @Test
    void shouldNotConvertStringToInteger() {
        Assertions.assertThrows(Base64Exception.class, () -> {
            sut.convert("teste");
        });
    }

    @Test
    void shouldConvertIntToStringSuccessfully() throws Base64Exception {
        when(unicodeTable.findByCode(UNICODE_INFO.getCodeAsInteger()))
            .thenReturn(UNICODE_INFO_OPT);

        String result = this.sut.unconvert(UNICODE_INFO.getCodeAsInteger());

        Assertions.assertEquals(result, UNICODE_INFO_OPT.get().getCharacterAsString());
    }

    @Test
    void shouldNotConvertIntegerToString() {
        Assertions.assertThrows(Base64Exception.class, () -> {
            sut.unconvert(-1);
        });
    }
}