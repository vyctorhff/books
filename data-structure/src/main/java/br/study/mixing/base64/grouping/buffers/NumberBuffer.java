package br.study.mixing.base64.grouping.buffers;

import java.util.ArrayList;
import java.util.List;

public abstract class NumberBuffer {

    private int maxGroupSize;

    protected StringBuilder sb;

    protected List<String> listResult;

    public NumberBuffer(int maxGroupSize) {
        this.maxGroupSize = maxGroupSize;

        this.sb = new StringBuilder();
        this.listResult = new ArrayList<>();
    }

    public void add(char charValue) {
        if (Character.isSpaceChar(charValue)) {
            return;
        }

        this.sb.append(charValue);

        if (hasLimitSizeNumber()) {
            this.pack();
        }
    }

    public void cleanBuffer() {
        this.sb.delete(0, this.sb.length());
    }

    protected boolean hasLimitSizeNumber() {
        return this.sb.length() == maxGroupSize;
    }

    public abstract void adjustes();

    protected void pack() {
        this.listResult.add(this.sb.toString());
        this.cleanBuffer();
    }

    public List<String> getList() {
        return listResult;
    }
}
