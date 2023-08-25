package br.study.mixing.base64.table;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class TableList {

    private List<TableInfo> list;

    public TableList() {
        this.init();
    }

    public void init() {
        this.list = new ArrayList<>();
        this.list.addAll(this.getBasicLetters());
    }

    public abstract List<TableInfo> getBasicLetters();

    public Optional<TableInfo> findByCharacter(String input) {
        return this.list.stream()
            .filter(tableInfo -> input.equals(tableInfo.getCharacterAsString()))
            .findFirst();
    }

    public Optional<TableInfo> findByCode(int code) {
        return this.list.stream()
            .filter(tableInfo -> code == tableInfo.getCode())
            .findFirst();
    }
}
