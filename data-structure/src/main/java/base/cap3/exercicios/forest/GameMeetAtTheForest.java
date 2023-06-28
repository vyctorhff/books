/*
 * Created on 17/02/2011, 16:08:03
 * Locate at Natal, Rio Grande do Norte
 *
 * JogoEncontroNaFloresta.java
 *
 * @autor torugo
 */
package base.cap3.exercicios.forest;

import base.cap3.exercicios.forest.domain.Forest;
import lombok.Getter;

import java.util.OptionalInt;

/**
 * Suponha um jogo para até 1000 jogadores jogadores.
 *
 * O vencedor deste jogo é o primeiro jogador que puder encontrar todos os demais pelo menos
 * uma vez(cordas sao permitidas).
 *
 * Assumindo que existe um metodo encontro(i, j) que e chamado cada vez que o jogador i encontra
 * o jogador j (com i != j). Quando i encontra com j é o mesmo que j encontrar o i.
 *
 * Descreva uma maneira de manter os pares de jogadores que se encontram e quem e o vencedor.
 */
@Getter
public class GameMeetAtTheForest {

    public static final int MININUM_PLAYER_AMOUNT = 1_000;

    private Forest forest;
    private final ForestPrinter printer;

    public GameMeetAtTheForest() {
        this(MININUM_PLAYER_AMOUNT);
    }

    public GameMeetAtTheForest(int totalPlayerNumber) {
        validar(totalPlayerNumber);

        this.forest = new Forest(totalPlayerNumber);
        this.printer = new ForestPrinter();
    }

    private void validar(int totalPlayerNumber) {
        if (totalPlayerNumber <= 0) {
            throw new IllegalArgumentException("Número de jogadores invalido");
        }

        if (totalPlayerNumber > MININUM_PLAYER_AMOUNT) {
            throw new IllegalArgumentException("Número de jogadores mínino é " + MININUM_PLAYER_AMOUNT);
        }
    }

    public void play() {
        OptionalInt winner = OptionalInt.empty();

        do {
            var finder = new ForestPlayerFinder(this.forest);
            var meeting = finder.find();

            this.forest.meet(meeting);

            if (this.forest.isPlayerWon(meeting.index1())) {
                winner = OptionalInt.of(meeting.index1());
            }

            if (this.forest.isPlayerWon(meeting.index2())) {
                winner = OptionalInt.of(meeting.index2());
            }
        } while (winner.isEmpty());

        this.printer.mostraVencedor(winner.getAsInt());
    }
}

