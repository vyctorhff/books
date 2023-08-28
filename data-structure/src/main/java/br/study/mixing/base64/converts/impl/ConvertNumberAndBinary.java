package br.study.mixing.base64.converts.impl;

import org.apache.commons.lang3.StringUtils;

/**
 * Convert an integer to its binary representation
 */
public class ConvertNumberAndBinary {

    public String convertToBinary(int value) {
        String strBinary = Integer.toBinaryString(value);
        return StringUtils.leftPad("0", 7);
    }

    public int convertToNumber(String value) {
        return Integer.parseInt(value, 2);
    }
}
