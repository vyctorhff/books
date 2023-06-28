/*
 * Created on 17/02/2011, 16:41:12
 * Locate at Natal, Rio Grande do Norte
 *
 * JogoEncontroNaFlorestaTest.java
 *
 * @autor torugo
 */
package base.cap3.exercicios;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameMeetAtTheForestTest {

    public static final int DEFAULT_PLAYER_AMOUNT = 2_000;

    private GameMeetAtTheForest game;

    @BeforeEach
    public void setup() {
        this.game = new GameMeetAtTheForest(DEFAULT_PLAYER_AMOUNT);
    }
    
    @Test
    public void testStartValidGame() {
        game.init();
    }

    @Test
    void testStartInvalidNumberPlayers() {
        assertThrows(IllegalArgumentException.class, () -> {
            new GameMeetAtTheForest(0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new GameMeetAtTheForest(GameMeetAtTheForest.MININUM_PLAYER_AMOUNT - 1);
        });
    }

    @Test
    public void testEncontro() {
        boolean[][] meets = game.getMeets();

        game.meet(10, 20);
        assertTrue(meets[10][20]);
        assertTrue(meets[20][10]);
    }

    @Test
    public void testGetInidiceAleatorio() {
        int[] estatisticaIndice = new int[DEFAULT_PLAYER_AMOUNT];

        for (int cont = 0; cont < DEFAULT_PLAYER_AMOUNT; cont++) {

            int indice = game.getRandomIndexPlayer();

            assertTrue(indice >= 0);
            assertTrue(indice < 20000);

            estatisticaIndice[cont]++;
        }
    }

    @Test
    public void testIsPlayerWins() {
        game = new GameMeetAtTheForest();

        int playerIndex = game.getRandomIndexPlayer();
        assertFalse(game.isPlayerWins(playerIndex));

        for (int cont = 0; cont < GameMeetAtTheForest.MININUM_PLAYER_AMOUNT; cont++) {
            game.meet(playerIndex, cont);
        }

        assertTrue(game.isPlayerWins(playerIndex));
    }
}
