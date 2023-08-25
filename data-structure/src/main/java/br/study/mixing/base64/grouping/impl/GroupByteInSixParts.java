package br.study.mixing.base64.grouping.impl;

import br.study.mixing.base64.grouping.GrouppingBytes;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * Group 8 parts in 6 parts.
 * Ex:
 * input: 00000000 00000000 00000000
 * output: 000000 000000 000000 000000
 */
@Data
public class GroupByteInSixParts implements GrouppingBytes {
    @Override
    public String process(String content) {
        if (StringUtils.isBlank(content)) {
            throw new IllegalArgumentException("Could not group, invalid content");
        }

        var numberBuffer = new NumberBuffer();

        for (char value : content.toCharArray()) {
            numberBuffer.add(value);
        }

        // if still remains something
        numberBuffer.packWithZeros();
        return String.join(" ", numberBuffer.getList());
    }
}
