/*
 * Created on 15/02/2011, 11:56:02
 * Locate at Natal, Rio Grande do Norte
 *
 * CriptografiaDeCesarTest.java
 *
 * @autor torugo
 */
package br.study.base.cap3.exercicios.criptografia;

import br.study.base.cap3.exercicios.criptografia.Cryptography;
import br.study.base.cap3.exercicios.criptografia.CryptographyArray;
import br.study.base.cap3.exercicios.criptografia.CryptographyCesar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

public class CriptografiaDeCesarTest {

    final String TEXTO_LIMPO_1 = "the eagle is in play";
    final String TEXTO_CIFRADO_1 = "wkh hdjoh lv lq sodb";

    final String TEXTO_LIMPO_2 = "meet at joes";
    final String TEXTO_CIFRADO_2 = "phhw dw mrhv";

    private Cryptography crypt;

    private CryptographyArray cesar;

    @BeforeEach
    public void setup() {
        this.crypt = new Cryptography();
        this.cesar = new CryptographyCesar();
    }

    @Test
    void testCriptografar() {
        checkEncriptar(TEXTO_LIMPO_1, TEXTO_CIFRADO_1);
        checkEncriptar(TEXTO_LIMPO_2, TEXTO_CIFRADO_2);
    }

    @Test
    void testDescriptografar() {
        checkDescripografar(TEXTO_LIMPO_1, TEXTO_CIFRADO_1);
        checkDescripografar(TEXTO_LIMPO_2, TEXTO_CIFRADO_2);
    }

    private void checkEncriptar(String raw, String encrypt) {
        var textoCifrado = crypt.encrypt(cesar, raw);

        assertNotSame(raw, textoCifrado);
        assertEquals(encrypt, textoCifrado);
    }

    private void checkDescripografar(String raw, String encrypt) {
        var textoLimpo = crypt.decript(cesar, encrypt);

        assertNotSame(encrypt, textoLimpo);
        assertEquals(raw, textoLimpo);
    }
}
