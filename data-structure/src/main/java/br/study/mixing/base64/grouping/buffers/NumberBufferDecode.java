package br.study.mixing.base64.grouping.buffers;

import br.study.mixing.base64.Base64Padding;
import br.study.mixing.base64.DecodeInput;

public class NumberBufferDecode extends NumberBuffer {

    private static final int MAX_GROUP_SIZE = 8;

    private final DecodeInput input;

    public NumberBufferDecode(DecodeInput input) {
        super(MAX_GROUP_SIZE);
        this.input = input;
    }

    public void adjustes() {
        if (this.sb.isEmpty()) {
            return;
        }

        this.checkOnlyZeros();
        this.checkNumberOfPaddingAndNumberOfZeros();
    }

    private void checkNumberOfPaddingAndNumberOfZeros() {
        var padding = Base64Padding.valueOf(this.getNumberLeftZeros());

        if (!padding.equals(this.input.getPadding())) {
            throw new IllegalArgumentException("number of padding is differente");
        }
    }

    private void checkOnlyZeros() {
        if (!this.sb.toString().matches("00|0000")) {
            throw new IllegalArgumentException("Left values was not only zeros");
        }
    }

    private int getNumberLeftZeros() {
        var count = 0;

        for (char character : this.sb.toString().toCharArray()) {
            if ('0' == character) {
                count++;
            }
        }

        return count;
    }
}
