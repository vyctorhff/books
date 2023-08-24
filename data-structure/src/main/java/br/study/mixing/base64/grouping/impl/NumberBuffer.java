package br.study.mixing.base64.grouping.impl;

import java.util.ArrayList;
import java.util.List;

public class NumberBuffer {

    private static final int MIN_GROUP_LENGTH = 2;
    private static final int MAX_GROUP_LENGTH = 6;

    private StringBuilder sb;

    private List<String> listResult;

    public NumberBuffer() {
        this.sb = new StringBuilder();
        this.listResult = new ArrayList<>();
    }

    public void add(char charValue) {
        if (Character.isSpaceChar(charValue)) {
            return;
        }

        this.sb.append(charValue);

        if (hasSixNumber()) {
            this.pack();
        }
    }

    public void cleanBuffer() {
        this.sb.delete(0, this.sb.length());
    }

    public boolean hasSixNumber() {
        return this.sb.length() == MAX_GROUP_LENGTH;
    }

    private void pack() {
        this.listResult.add(this.sb.toString());
        this.cleanBuffer();
    }

    public void packWithZeros() {
        var result = this.sb.toString();

        if (this.sb.isEmpty()) {
            return;
        }

        if (this.sb.length() == MIN_GROUP_LENGTH) {
            this.sb.append("0");
            this.sb.append("0");
        } else {
            this.sb.append("0");
        }

        this.pack();
    }

    public List<String> getList() {
        return listResult;
    }
}
