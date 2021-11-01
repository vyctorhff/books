package br.corrida.participantes;

import br.corrida.util.Dado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
class CoelhoTest {

    private SorteCoelho sorte;

    @Mock
    private Dado dado;

    @BeforeEach
    void setup() {
        this.sorte = new SorteCoelho(dado);
    }

    @Test
    void test_is_dormiu() {
        preparaMock(SorteCoelho.PERCENTUAL_DORMIU);
        Assertions.assertTrue(sorte.isDormiu());

        preparaMock(0);
        Assertions.assertTrue(sorte.isDormiu());

        preparaMock(SorteCoelho.PERCENTUAL_DORMIU + 1);
        Assertions.assertFalse(sorte.isDormiu());
    }

    @Test
    void test_is_distraido() {
        preparaMock(SorteCoelho.PERCENTUAL_DISTRAIU);
        Assertions.assertTrue(sorte.isDistraiu());

        preparaMock(0);
        Assertions.assertTrue(sorte.isDistraiu());

        preparaMock(SorteCoelho.PERCENTUAL_DISTRAIU + 1);
        Assertions.assertFalse(sorte.isDistraiu());
    }

    @Test
    void test_is_conversou() {
        preparaMock(SorteCoelho.PERCENTUAL_CONVERSOU);
        Assertions.assertTrue(sorte.isConversou());

        preparaMock(0);
        Assertions.assertTrue(sorte.isConversou());

        preparaMock(SorteCoelho.PERCENTUAL_CONVERSOU + 1);
        Assertions.assertFalse(sorte.isConversou());
    }

    void preparaMock(int valor) {
        when(dado.lancar(any(), any())).thenReturn(valor);
    }
}