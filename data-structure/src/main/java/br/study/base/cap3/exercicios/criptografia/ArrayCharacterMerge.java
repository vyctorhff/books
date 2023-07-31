/*
 * Created on 28/02/2022, 17:17:02
 * Locate at Parnamirm, Rio Grande do Norte
 *
 * CriptografiaDeCesar.java
 *
 * @autor torugo
 */
package br.study.base.cap3.exercicios.criptografia;

public class ArrayCharacterMerge {

    private char[] source;
    private char[] destiny;

    public ArrayCharacterMerge() {
    }

    public ArrayCharacterMerge(char[] source, char[] destiny) {
        this.source = source;
        this.destiny = destiny;
    }

    public char[] merge(char[] source, char[] destiny) {
        this.source = source;
        this.destiny = destiny;

        return merge();
    }

    public char[] merge() {
        if (isEmpty(this.source)) {
            return this.destiny;
        } else if (isEmpty(this.destiny)) {
            return this.source;
        }

        var size = this.source.length - getTotalFilledElements();
        char[] alteredAlphabet = new char[size];

        var indexNewArray = 0;
        var indexSource = 0;
        do {
            var letter = this.source[indexSource];
            indexSource++;

            if (this.existsLetter(letter, this.destiny)) continue;

            alteredAlphabet[indexNewArray] = letter;
            indexNewArray++;

        } while (indexNewArray < alteredAlphabet.length);

        return alteredAlphabet;
    }

    private int getTotalFilledElements() {
        var count = 0;

        for (char letter : this.destiny) {
            if (letter != Character.MIN_VALUE) {
                count++;
            }
        }

        return count;
    }

    private boolean existsLetter(char letterSearch, char[] array) {
        for (char letter : array) {
            if (letter == letterSearch) return true;
        }

        return false;
    }

    private boolean isEmpty(char[] array) {
        for (char letter : array) {
            if (letter != Character.MIN_VALUE) return false;
        }

        return true;
    }
}
