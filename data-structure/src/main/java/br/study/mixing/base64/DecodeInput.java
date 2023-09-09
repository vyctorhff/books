package br.study.mixing.base64;

import lombok.Data;

@Data
public class DecodeInput {

    public static final char PADDING_SYMBOL = '=';

    private String code;

    public DecodeInput(String code) {
        this.code = code;
    }

    public Base64Padding getPadding() {
        var oneSymbol = PADDING_SYMBOL == this.getLastCharacter();
        var secondSymbol = PADDING_SYMBOL == this.getSecondLastCharacter();

        if (oneSymbol && secondSymbol) {
            return Base64Padding.DOUBLE;
        }

        if (oneSymbol || secondSymbol) {
            return Base64Padding.SINGLE;
        }

        return Base64Padding.NONE;
    }

    private char getLastCharacter() {
        return this.code.charAt(this.code.length() - 1);
    }

    private char getSecondLastCharacter() {
        return this.code.charAt(this.code.length() - 2);
    }
}
