package br.study.mixing.base64.grouping.impl;

import br.study.mixing.base64.grouping.GrouppingBytes;

import java.util.List;

/**
 * Group 8 parts in 6 parts.
 * Ex:
 * input: 000000 000000 000000 000000
 * output: 00000000 00000000 00000000
 */
public class GroupSixPartsInBytes implements GrouppingBytes {
    @Override
    public List<String> process(String string) {
        // TODO: implement it
        return null;
    }
}
