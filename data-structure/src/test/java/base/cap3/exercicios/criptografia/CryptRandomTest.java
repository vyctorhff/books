/*
 * Created on 11/03/2011, 21:39:15
 * Locate at Natal, Rio Grande do Norte
 *
 * CriptografiaAleatorioTest.java
 *
 * @autor torugo
 */
package base.cap3.exercicios.criptografia;

import br.study.base.cap3.exercicios.criptografia.ArrayCharacterMerge;
import br.study.base.cap3.exercicios.criptografia.Cryptography;
import br.study.base.cap3.exercicios.criptografia.CryptographyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CryptRandomTest {

    private static final String MSG_1 = "Hello world";

    private Cryptography crypt;

    @BeforeEach
    public void setup() {
        this.crypt = new Cryptography();
    }

    @Test
    public void testEncriptar() {
        var random = new CryptographyRandom(new ArrayCharacterMerge());
        var encrypt = this.crypt.encrypt(random, MSG_1);

        assertNotNull(encrypt);
        assertNotEquals(MSG_1, encrypt);
    }

    @Test
    public void testDecriptar() {
        var random = new CryptographyRandom(new ArrayCharacterMerge());
        var encrypt = this.crypt.encrypt(random, MSG_1);

        var decrypt = this.crypt.decript(random, encrypt);

        assertNotNull(decrypt);
        assertEquals(MSG_1.toLowerCase(), decrypt);
    }

}
