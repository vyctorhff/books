package br.study.mixing.base64.grouping.impl;

import br.study.mixing.base64.grouping.GrouppingBytes;
import br.study.mixing.base64.grouping.buffers.NumberBuffer;
import br.study.mixing.base64.grouping.buffers.NumberBufferEncode;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Group 8 parts in 6 parts.
 * Ex:
 * input: 00000000 00000000 00000000
 * output: 000000 000000 000000 000000
 */
@Data
public class GroupByteInSixParts implements GrouppingBytes {

    @Override
    public List<String> process(String content) {
        if (StringUtils.isBlank(content)) {
            throw new IllegalArgumentException("Could not group, invalid content");
        }

        NumberBuffer numberBuffer = new NumberBufferEncode();

        for (char value : content.toCharArray()) {
            numberBuffer.add(value);
        }

        // if still remains something
        numberBuffer.adjustes();
//        return String.join(" ", numberBuffer.getList());
        return numberBuffer.getList();
    }
}
