package br.corrida.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DadoTest {

    @Test
    void test_lancamentos_dentro_dos_limites() {
        Dado dado = new Dado();
        int numero;

        for (int count = 0; count < 1000; count++) {
            numero = dado.lancar(1, 10);
            assertTrue(numero >= 1);
            assertTrue(numero <= 10);
        }
    }
}