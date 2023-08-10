package br.study.mixing.base64;

/**
 * Implement base64 transformation
 *
 * How to encode:
 * 1 - Take a character sequence
 * 2 - Convert each chracter to ASCII(unicode) decimal
 * 3 - Convert each decimal to binary
 * 4 - Convert the 8 bits in 6 bits representation
 *  4.1 - Padding
 *  4.2 - if the when group bits in 6 bits and someone not complete 6 bits
 *  4.3 - it should add to the right with zeros
 *  4.4 - if it needs 2 zeros, add a '=' at the final of the result
 *  4.5 - if it needs 4 zeros, add a '==' at the final of the result
 * 5 - Convert each 6 bits sequence to a number
 * 6 - Convert each number to a character based on base 64 table
 * 7 - Concat the role sequence to a string
 *
 * How to decode:
 * 1 - Take a base64 character sequence
 * 2 -
 */
public class Base64Impl {

    public String encode(String input) throws Base64Exception {
        return null;
    }

    public String decode(String input) throws Base64Exception {
        return null;
    }
}
