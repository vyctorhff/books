package br.study.mixing.base64.grouping.buffers;

public class NumberBufferDecode extends NumberBuffer {

    private static final int MAX_GROUP_SIZE = 8;

    private static final int MIN_PADDING_GROUP_LENGTH = 2;
    private static final int MAX_PADDING_GROUP_LENGTH = 4;

    public NumberBufferDecode() {
        super(MAX_GROUP_SIZE);
    }

    public void adjustes() {
        if (this.sb.isEmpty()) {
            return;
        }

        // FIXME: remove zeros

        this.pack();
    }
}
