package br.study.mixing.base64.grouping.impl;

import br.study.mixing.base64.grouping.GrouppingBytes;
import lombok.Data;

/**
 * Group 8 parts in 6 parts.
 * Ex:
 * input: 00000000 00000000 00000000
 * output: 000000 000000 000000 000000
 */
@Data
public class GroupByteInSixParts implements GrouppingBytes {
    @Override
    public String process(String string) {
        return null;
    }
}
