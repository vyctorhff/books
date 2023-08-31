package br.study.mixing.base64;

import lombok.Data;

@Data
public class DecodeInput {

    private static final char PADDING_SYMBLO = '=';

    private String code;

    public DecodeInput(String code) {
        this.code = code;
    }

    public Base64Padding getPadding() {
        var oneSymblo = PADDING_SYMBLO == this.getLastCharacter();
        var secondSymblo = PADDING_SYMBLO == this.getSecondLastCharacter();

        if (oneSymblo && secondSymblo) {
            return Base64Padding.DOUBLE;

        } else if (oneSymblo || secondSymblo) {
            return Base64Padding.SINGLE;
        }

        return Base64Padding.NODE;
    }

    private char getLastCharacter() {
        return this.code.charAt(this.code.length() - 1);
    }

    private char getSecondLastCharacter() {
        return this.code.charAt(this.code.length() - 2);
    }
}
