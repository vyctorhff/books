package br.study.mixing.base64.converts.impl;

import br.study.mixing.base64.Base64Exception;
import br.study.mixing.base64.table.TableInfo;
import br.study.mixing.base64.table.unicode.UnicodeTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConvertStringAndNumberImplTest {

    public static final TableInfo UNICODE_INFO =
        new TableInfo(2, 'A');

    public static final Optional<TableInfo> UNICODE_INFO_OPT =
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
        assertEquals(UNICODE_INFO.getCodeAsInteger(), code);
    }

    @Test
    void shouldNotConvertStringToInteger() {
        assertThrows(Base64Exception.class, () -> {
            sut.convert("teste");
        });
    }

    @Test
    void shouldConvertIntToStringSuccessfully() throws Base64Exception {
        when(unicodeTable.findByCode(UNICODE_INFO.getCodeAsInteger()))
            .thenReturn(UNICODE_INFO_OPT);

        String result = this.sut.unconvert(UNICODE_INFO.getCodeAsInteger());

        assertEquals(result, UNICODE_INFO_OPT.get().getCharacterAsString());
    }

    @Test
    void shouldNotConvertIntegerToString() {
        assertThrows(Base64Exception.class, () -> {
            sut.unconvert(-1);
        });
    }
}