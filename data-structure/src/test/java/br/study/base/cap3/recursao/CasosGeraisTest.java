/*
 * Created on 17/02/2011, 15:40:12
 * Locate at Natal, Rio Grande do Norte
 *
 * CasosGeraisTest.java
 *
 * @autor torugo
 */
package br.study.base.cap3.recursao;

import br.study.base.cap3.recursao.CasosGerais;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CasosGeraisTest {

    private CasosGerais recursao;

    @BeforeEach
    public void setup() {
        recursao = new CasosGerais();
    }

    @Test
    public void testSomaArranjo() {
        int[] arranjo = {2, 3, 4, 3, 2, 4, 6};
        int somaArranjo = 0;

        for (int numero : arranjo) {
            somaArranjo += numero;
        }

        int soma = recursao.somaArranjo(arranjo);
        assertEquals(somaArranjo, soma);
    }

    @Test
    public void testInverteArranjo() {
        int[] arranjo = {2, 3, 4, 3, 2, 4, 6};
        final int TAMANHO_ARRANJO = arranjo.length;

        int[] arranjoInvertido = new int[TAMANHO_ARRANJO];

        for (int cont = TAMANHO_ARRANJO - 1; cont >= 0; cont--) {
            arranjoInvertido[cont] = arranjo[(TAMANHO_ARRANJO - 1) - cont];
        }

        int[] invertido = recursao.inverteArranjo(arranjo);
        assertTrue(Arrays.equals(arranjoInvertido, invertido));
    }
}
