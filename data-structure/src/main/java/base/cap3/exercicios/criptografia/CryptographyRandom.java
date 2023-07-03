/*
 * Created on 23/02/2011, 16:40:43
 * Locate at Natal, Rio Grande do Norte
 *
 * CriptografiaAleatorio.java
 *
 * @autor torugo
 */
package base.cap3.exercicios.criptografia;

import java.util.Random;

/**
 * Descricacao do problema
 * <p>
 * Solucao:
 * <p>
 * criptografar: para cada letra da mensagem limpa.
 * 1) Localize o indice no alfabeto
 * 2) Localize a letra na chave com o indice do passo 1.
 * 3) Inserir na mensagem a letra do passo 2.
 * <p>
 * descriptografar: para cada letra da mensagem cifrada.
 * 1) Localize o indce na chave.
 * 2) Localize a letra no alfabeto com o indice do passo 1.
 * 3) Inserir na mensagem a letra do passo 2.
 * <p>
 * Nao implementei por ter que estudar para a pratica de projeto e para
 * o emprego.
 */
public class CryptographyRandom implements CryptographyArray {

    private final char[] ALPHABET = {
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
        'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        '!', '?', ' '
    };

    private char[] shuflled;
    private final ArrayCharacterMerge mergeArray;

    public CryptographyRandom(ArrayCharacterMerge mergeArray) {
        this.mergeArray = mergeArray;
    }

    @Override
    public char[] getOriginal() {
        return ALPHABET;
    }

    @Override
    public char[] getShuflled() {
        if (shuflled != null) {
            return this.shuflled;
        }

        int size = ALPHABET.length;
        this.shuflled = new char[size];

        for (var index = 0; index < size; index++) {
            var letter = getRandomLetter();
            this.shuflled[index] = letter;
        }

        return this.shuflled;
    }

    private char getRandomLetter() {
        char[] alteredAlphabet = this.mergeArray.merge(this.ALPHABET, this.shuflled);

        var randomIndex = new Random().nextInt(alteredAlphabet.length);
        return alteredAlphabet[randomIndex];
    }

    @Override
    public boolean isIgnoreWhiteSpace() {
        return false;
    }
}
