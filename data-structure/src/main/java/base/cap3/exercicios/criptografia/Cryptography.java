package base.cap3.exercicios.criptografia;

public class Cryptography {

    private static final char EMPTY_CHARACTER = ' ';

    public String encrypt(CryptographyArray source, String msg) {
        return parse(source.getOriginal(), source.getShuflled(), msg, source.isIgnoreWhiteSpace());
    }

    public String decript(CryptographyArray source, String msg) {
        return parse(source.getShuflled(), source.getOriginal(), msg, source.isIgnoreWhiteSpace());
    }

    private String parse(char[] source, char[] destiny, String msg, boolean ignoreWhiteSpace) {
        var output = new StringBuilder();

        for (char letter : msg.toCharArray()) {

            if (letter == EMPTY_CHARACTER && ignoreWhiteSpace) {
                output.append(EMPTY_CHARACTER);
                continue;
            }

            var index = this.findIndexByLetter(letter, source);
            output.append(destiny[index]);
        }

        return output.toString();
    }

    private int findIndexByLetter(char letter, char[] array) {

        for (var index = 0; index < array.length; index++) {
            if (isEqual(array[index], letter)) {
                return index;
            }
        }

        throw new IllegalArgumentException("Letter not found: " + letter);
    }

    private boolean isEqual(char c1, char c2) {
        return Character.toLowerCase(c1) == Character.toLowerCase(c2);
    }
}
