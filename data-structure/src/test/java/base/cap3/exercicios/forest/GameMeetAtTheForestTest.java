/*
 * Created on 17/02/2011, 16:41:12
 * Locate at Natal, Rio Grande do Norte
 *
 * JogoEncontroNaFlorestaTest.java
 *
 * @autor torugo
 */
package base.cap3.exercicios.forest;


import base.cap3.exercicios.forest.domain.Forest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameMeetAtTheForestTest {

    public static final int DEFAULT_PLAYER_AMOUNT = 1_000;

    private ForestPrinter printer;
    private ForestPlayerFinder finder;
    private GameMeetAtTheForest game;

    @BeforeEach
    void setup() {
        var forest = new Forest(DEFAULT_PLAYER_AMOUNT);

        this.printer = new ForestPrinter();
        this.finder = new ForestPlayerFinder(forest);

        this.game = new GameMeetAtTheForest(finder, printer);
    }

    @Test
    void testStartValidGame() {
        game.play();
    }

    @Test
    void testStartInvalidNumberPlayers() {
        assertThrows(IllegalArgumentException.class, () -> {
            new GameMeetAtTheForest(new ForestPlayerFinder(new Forest(0)), printer);
        });
    }

    @Test
    void testMaximumPlayersNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            new GameMeetAtTheForest(new ForestPlayerFinder(new Forest(1001)), printer);
        });
    }
}
