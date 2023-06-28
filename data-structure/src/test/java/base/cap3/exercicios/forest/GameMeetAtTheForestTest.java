/*
 * Created on 17/02/2011, 16:41:12
 * Locate at Natal, Rio Grande do Norte
 *
 * JogoEncontroNaFlorestaTest.java
 *
 * @autor torugo
 */
package base.cap3.exercicios.forest;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameMeetAtTheForestTest {

    public static final int DEFAULT_PLAYER_AMOUNT =  1_000;

    private GameMeetAtTheForest game;

    @BeforeEach
    void setup() {
        this.game = new GameMeetAtTheForest(DEFAULT_PLAYER_AMOUNT);
    }
    
    @Test
    void testStartValidGame() {
        game.play();
    }

    @Test
    void testStartInvalidNumberPlayers() {
        assertThrows(IllegalArgumentException.class, () -> {
            new GameMeetAtTheForest(0);
        });
    }

    @Test
    void testMaximumPlayersNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            new GameMeetAtTheForest(1001);
        });
    }
}
