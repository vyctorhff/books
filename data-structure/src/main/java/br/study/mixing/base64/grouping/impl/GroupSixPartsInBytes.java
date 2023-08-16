package br.study.mixing.base64.grouping.impl;

import br.study.mixing.base64.grouping.GrouppingBytes;

/**
 * Group 8 parts in 6 parts.
 * Ex:
 * input: 000000 000000 000000 000000
 * output: 00000000 00000000 00000000
 */
public class GroupSixPartsInBytes implements GrouppingBytes {
    @Override
    public String process(String string) {
        return null;
    }
}
