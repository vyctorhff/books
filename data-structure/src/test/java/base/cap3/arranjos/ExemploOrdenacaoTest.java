/*
 * Created on 14/02/2011, 12:02:44
 * Locate at Natal, Rio Grande do Norte
 *
 * ExemploOrdenacaoTest.java
 *
 * @autor torugo
 */
package base.cap3.arranjos;

import br.study.base.cap3.arranjos.ExemploOrdenacao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExemploOrdenacaoTest {

    private ExemploOrdenacao exemploOrdenacao;

    @BeforeEach
    public void setup() {
        exemploOrdenacao = new ExemploOrdenacao(15);
    }

    @Test
    public void testInicializaArranjoDiferenteDeZero() {
        int[] arranjo = exemploOrdenacao.getArranjo();
        int contZero = 0;

        for (int elemento : arranjo) {
            if (elemento == 0)
                contZero++;
        }

        assertTrue(contZero < 3);
    }

    @Test
    public void testOrdenar() {
        int[] naoOrdenado = exemploOrdenacao.getArranjo().clone();
        exemploOrdenacao.ordenar();
        int[] ordenado = exemploOrdenacao.getArranjo();

        assertFalse(Arrays.equals(ordenado, naoOrdenado));

        for (int cont = 0; cont < ExemploOrdenacao.TAMANHO_ARRANJO; cont++) {

            //E o ultimo indice
            if (cont == (ExemploOrdenacao.TAMANHO_ARRANJO - 1)) {
                break;
            }

            boolean isMenorQueProximo = ordenado[cont] <= ordenado[cont + 1];
            assertTrue(isMenorQueProximo);
        }
    }
}
