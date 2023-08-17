package br.study.mixing.base64.grouping.impl;

import br.study.mixing.base64.grouping.GrouppingBytes;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;

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

        var listBytes = Arrays.stream(content.split(StringUtils.SPACE));
        var listResult = new ArrayList<String>();

        listBytes.forEach(groupByte -> {
            transform(groupByte, listResult);
        });

        return StringUtils.join(listBytes, StringUtils.SPACE);
    }

    private void transform(String groupByte, ArrayList<String> listResult) {
        // check how much left for the last item in the array
        // if none then add 6 numbers and 2 in the next index of the list
        // else add 2 numbers and 6 in the next index of the list
    }
}
