/*
 * Created on 14/02/2011, 17:17:02
 * Locate at Natal, Rio Grande do Norte
 *
 * CriptografiaDeCesar.java
 *
 * @autor torugo
 */
package base.cap3.exercicios.criptografia;

/**
 * A Cifra de Cesar(criptografia de Cesar) implica em substituir cada letra de
 * uma mensagem pela letra que esta a tres letras de distancia no alfabeto da
 * lingua.
 * <p>
 * Assim, substitui-se o A por D, B por E etc.
 */
public class CryptographyCesar implements CryptographyArray {

    private final int DISTANCIA_NO_ALFABETO = 3;

    private final char[] ALPHABET = {
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
        'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };

    private final char[] shurflled;

    public CryptographyCesar() {
        this.shurflled = new char[ALPHABET.length];
    }

    @Override
    public char[] getOriginal() {
        return ALPHABET;
    }

    @Override
    public char[] getShuflled() {
        if (!isShuflledEmpty()) {
            return this.shurflled;
        }

        for (var index = 0; index < ALPHABET.length; index++) {
            var indexAhead = (index + DISTANCIA_NO_ALFABETO) % ALPHABET.length;
            this.shurflled[index] = ALPHABET[indexAhead];
        }

        return this.shurflled;
    }

    @Override
    public boolean isIgnoreWhiteSpace() {
        return true;
    }

    private boolean isShuflledEmpty() {
        return this.shurflled.length >= 0 && this.shurflled[0] == '\u0000';
    }
}
