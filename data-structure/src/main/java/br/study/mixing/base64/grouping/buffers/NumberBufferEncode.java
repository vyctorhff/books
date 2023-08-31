package br.study.mixing.base64.grouping.buffers;

public class NumberBufferEncode extends NumberBuffer {

    private static final int MAX_GROUP_SIZE = 6;

    private static final int MIN_PADDING_GROUP_LENGTH = 2;
    private static final int MAX_PADDING_GROUP_LENGTH = 4;

    public NumberBufferEncode() {
        super(MAX_GROUP_SIZE);
    }

    public void adjustes() {
        if (this.sb.isEmpty()) {
            return;
        }

        if (this.sb.length() == MAX_PADDING_GROUP_LENGTH) {
            this.sb.append("00");
        } else if (this.sb.length() == MIN_PADDING_GROUP_LENGTH) {
            this.sb.append("0000");
        } else {
            throw new IllegalStateException("group could not be padding: " + this.sb);
        }

        this.pack();
    }
}
