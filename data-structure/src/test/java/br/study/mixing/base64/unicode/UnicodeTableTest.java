package br.study.mixing.base64.unicode;

import br.study.mixing.base64.table.unicode.UnicodeTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class UnicodeTableTest {

    private UnicodeTable unicodeTable;

    @BeforeEach
    void setup() {
        this.unicodeTable = new UnicodeTable();
        this.unicodeTable.init();
    }

    @ParameterizedTest
    @MethodSource("sourceUnicodeTable")
    void shouldConvertStringToCode(int code, String input) {
        var opt = this.unicodeTable.findByCharacter(input);

        assertTrue(opt.isPresent());
        assertEquals(code, opt.get().getCodeAsInteger());
    }

    static Stream<Arguments> sourceUnicodeTable() {
        return Stream.of(
            Arguments.of(32, " "),
            Arguments.of(48, "0"),
            Arguments.of(57, "9"),
            Arguments.of(61, "="),
            Arguments.of(76, "L"),
            Arguments.of(97, "a"),
            Arguments.of(118,	"v"),
            Arguments.of(123, "{")
        );
    }

    @Test
    void shouldNotReturnCodeBecauseDoesNotExists() {
        var opt = this.unicodeTable.findByCharacter("test");
        assertFalse(opt.isPresent());
    }

    @ParameterizedTest
    @MethodSource("sourceUnicodeTable")
    void shouldConvertCodeToString(int code, String input) {
        var opt = this.unicodeTable.findByCode(code);

        assertTrue(opt.isPresent());
        assertEquals(input, opt.get().getCharacterAsString());
    }

    @Test
    void shouldNotreturnStringBecauseNotExists() {
        var opt = this.unicodeTable.findByCode(-1);
        assertFalse(opt.isPresent());
    }
}