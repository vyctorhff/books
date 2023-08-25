package br.study.mixing.base64.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableInfo {

    private short code;

    private Character value;

    public TableInfo(int code, Character character) {
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
