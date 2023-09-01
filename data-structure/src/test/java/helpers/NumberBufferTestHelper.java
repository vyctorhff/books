package helpers;

import br.study.mixing.base64.DecodeInput;
import br.study.mixing.base64.grouping.buffers.NumberBuffer;
import br.study.mixing.base64.grouping.buffers.NumberBufferDecode;
import br.study.mixing.base64.grouping.buffers.NumberBufferEncode;

public class NumberBufferTestHelper {

    public NumberBuffer createDecodeWithValues(DecodeInput input, char... arrayChar) {
        var numberBuffer = new NumberBufferDecode(input);

        for (char value : arrayChar) {
            numberBuffer.add(value);
        }

        return numberBuffer;
    }

    public NumberBuffer createDecodeWithValues(char... arrayChar) {
        var decodeInput = new DecodeInput("");
        var numberBuffer = new NumberBufferDecode(decodeInput);

        for (char value : arrayChar) {
            numberBuffer.add(value);
        }

        return numberBuffer;
    }

    public NumberBuffer createEncodeWithValues(char... arrayChar) {
        var numberBuffer = new NumberBufferEncode();

        for (char value : arrayChar) {
            numberBuffer.add(value);
        }

        return numberBuffer;
    }

    public NumberBuffer createEncodeWithSixValues() {
        return createEncodeWithValues('0', '1', '2', '3', '4', '5');
    }

    public NumberBuffer createEncodeWithFourValues() {
        return createEncodeWithValues('0', '1', '2', '3');
    }

    public NumberBuffer createDecodeWithEightValues() {
        return createEncodeWithValues(
            '0', '1', '2', '3', '4', '5', '6', '7'
        );
    }
}
