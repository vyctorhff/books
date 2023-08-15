package br.study.mixing.base64.converts.impl;

import br.study.mixing.base64.Base64Exception;
import br.study.mixing.base64.converts.ConvertStringAndNumber;
import br.study.mixing.base64.unicode.UnicodeTable;

/**
 * Using the ASC II(UNICODE), transform a character to a decimal.
 */
public class ConvertStringAndNumberImpl implements ConvertStringAndNumber {

    private UnicodeTable unicodeTable;

    public ConvertStringAndNumberImpl(UnicodeTable unicodeTable) {
        this.unicodeTable = unicodeTable;
    }

    public int convert(String input) throws Base64Exception {
        var optInt = this.unicodeTable.findByCharacter(input);
        if (optInt.isEmpty()) {
            throw new Base64Exception("Could not find input in unicode table");
        }

        return optInt.get().getCodeAsInteger();
    }

    public String unconvert(int number) throws Base64Exception {
        var opt = this.unicodeTable.findByCode(number);
        if (opt.isEmpty()) {
            throw new Base64Exception("Could not find code in unicode table");
        }
        return opt.get().getCharacterAsString();
    }
}
