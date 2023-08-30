package br.study.mixing.base64.grouping.buffers;

import java.util.ArrayList;
import java.util.List;

public class NumberBuffer {

    private static final int MIN_PADDING_GROUP_LENGTH = 2;
    private static final int MAX_PADDING_GROUP_LENGTH = 4;
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

    private boolean hasSixNumber() {
        return this.sb.length() == MAX_GROUP_LENGTH;
    }

    private void pack() {
        this.listResult.add(this.sb.toString());
        this.cleanBuffer();
    }

    public void packWithZeros() {
        if (this.sb.isEmpty()) {
            return;
        }

        if (this.sb.length() == MAX_PADDING_GROUP_LENGTH) {
            this.sb.append("0");
            this.sb.append("0");
        } else if (this.sb.length() == MIN_PADDING_GROUP_LENGTH) {
            this.sb.append("0");
            this.sb.append("0");
            this.sb.append("0");
            this.sb.append("0");
        } else {
            throw new IllegalStateException("group could not be padding: " + this.sb);
        }

        this.pack();
    }

    public List<String> getList() {
        return listResult;
    }
}
