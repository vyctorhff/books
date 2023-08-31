package br.study.mixing.base64.grouping.buffers;

import br.study.mixing.base64.DecodeInput;

public class NumberBufferDecode extends NumberBuffer {

    private static final int MAX_GROUP_SIZE = 8;

    public NumberBufferDecode(DecodeInput input) {
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
