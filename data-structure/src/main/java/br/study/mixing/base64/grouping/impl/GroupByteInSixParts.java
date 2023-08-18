package br.study.mixing.base64.grouping.impl;

import br.study.mixing.base64.grouping.GrouppingBytes;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
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
    public String process(String content) {
        if (StringUtils.isBlank(content)) {
            throw new IllegalArgumentException("Could not group, invalid content");
        }

        var listStringOfBytes = Arrays.stream(content.split(StringUtils.SPACE));
        var listResult = new ArrayList<String>();

        listStringOfBytes.forEach(groupByte -> {
            transform(groupByte, listResult);
        });

        return StringUtils.join(listStringOfBytes, StringUtils.SPACE);
    }

    private void transform(String groupByte, List<String> listResult) {
        // check how much left for the last item in the array
        // if none then add 6 numbers and 2 in the next index of the list
        // else add 2 numbers and 6 in the next index of the list
    }

    private boolean lastIndexIsFull(List<String> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List of groups invalide");
        }

        var last = list.get(list.size() - 1);
        return !last.isBlank() || last.length() == 6;
    }

    private void addSixNumber(String partOfEightBits, List<String> list) {
        list.add(partOfEightBits.substring(0, 6));
        list.add(partOfEightBits.substring(6, 8));
    }

    private void addTwoNumber(String partOfEightBits, List<String> list) {
    }
}
