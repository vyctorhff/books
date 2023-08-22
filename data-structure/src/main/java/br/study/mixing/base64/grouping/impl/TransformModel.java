package br.study.mixing.base64.grouping.impl;

import java.util.List;

public record TransformModel(String groupPart, List<String> listResult) {

    private static final int INDEX_START = 0;
    private static final int INDEX_TWO = 2;
    private static final int INDEX_SIX = 6;
    private static final int INDEX_END = 8;

    public void add() {
        if (this.lastIndexIsFull()) {
            this.addSixNumberFromBeginning();
            this.addTwoNumberFromEnding();
        } else {
            this.addSixNumberFromEnding();
            this.addTwoNumberFromBeginning();
        }
    }

    public boolean lastIndexIsFull() {
        if (listResult == null || listResult.isEmpty()) {
            throw new IllegalArgumentException("List of groups invalide");
        }

        var last = listResult.get(listResult.size() - 1);
        return !last.isBlank() || last.length() == INDEX_SIX;
    }

    public void addSixNumberFromBeginning() {
        listResult.add(groupPart.substring(INDEX_START, INDEX_SIX));
    }

    public void addSixNumberFromEnding() {
        listResult.add(groupPart.substring(INDEX_TWO, INDEX_END));
    }

    public void addTwoNumberFromBeginning() {
        listResult.add(groupPart.substring(INDEX_START, INDEX_TWO));
    }

    public void addTwoNumberFromEnding() {
        listResult.add(groupPart.substring(INDEX_SIX, INDEX_END));
    }

}
