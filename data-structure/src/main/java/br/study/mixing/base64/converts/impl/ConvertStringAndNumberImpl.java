package br.study.mixing.base64.converts.impl;

import br.study.mixing.base64.Base64Exception;
import br.study.mixing.base64.converts.ConvertStringAndNumber;
import br.study.mixing.base64.unicode.UnicodeTable;

import java.util.OptionalInt;

/**
 * Using the ASC II(UNICODE), transform a character to a decimal.
 */
public class ConvertStringAndNumberImpl implements ConvertStringAndNumber {

    private UnicodeTable unicodeTable;

    public ConvertStringAndNumberImpl(UnicodeTable unicodeTable) {
        this.unicodeTable = unicodeTable;
    }

    public int convert(String input) throws Base64Exception {
        OptionalInt optInt = this.unicodeTable.findByCharacter(input);
        if (optInt.isEmpty()) {
            throw new Base64Exception("Could not find input in unicode table");
        }

        return optInt.getAsInt();
    }

    public String unconvert(int number) throws Base64Exception {
        return "";
    }
}
