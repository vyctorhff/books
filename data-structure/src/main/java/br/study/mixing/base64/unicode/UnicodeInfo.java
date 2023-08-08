package br.study.mixing.base64.unicode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnicodeInfo {

    private short code;

    private Character value;

    public UnicodeInfo(int code, Character character) {
        this.code = (short) code;
        this.value = character;
    }

    public String getCharacterAsString() {
        return value.toString();
    }

    public int getCodeAsInteger() {
        return (int) code;
    }

    @Override
    public String toString() {
        return "[%s] - [%s]".formatted(code, value);
    }
}
