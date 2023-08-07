package br.study.mixing.base64.unicode;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UnicodeInfo {

    private short code;

    private Character character;

    public String characterToString() {
        return character.toString();
    }

    @Override
    public String toString() {
        return "[%s] - [%s]".formatted(code, character);
    }
}
