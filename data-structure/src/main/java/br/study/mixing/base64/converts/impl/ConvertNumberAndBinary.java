package br.study.mixing.base64.converts.impl;

import org.apache.commons.lang3.StringUtils;

/**
 * Convert an integer to its binary representation
 */
public class ConvertNumberAndBinary {

    public static final int BYTE_SIZE = 8;
    public static final int BASE_NUMBER_BINARY = 2;
    public static final String DEFAULT_BIT = "0";

    public String convertToBinary(int value) {
        String strBinary = Integer.toBinaryString(value);
        return StringUtils.leftPad(strBinary, BYTE_SIZE, DEFAULT_BIT);
    }

    public int convertToNumber(String value) {
        if (StringUtils.isBlank(value) || (value.length() != BYTE_SIZE)) {
            throw new IllegalArgumentException("Invalid to convert: " + value);
        }

        return Integer.parseInt(value, BASE_NUMBER_BINARY);
    }
}
