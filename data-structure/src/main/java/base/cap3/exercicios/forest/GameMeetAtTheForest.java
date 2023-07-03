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
import base.cap3.exercicios.forest.domain.Meeting;
import lombok.Getter;

import java.util.OptionalInt;

/**
 * Suponha um jogo para até 1000 jogadores jogadores.
 * <p>
 * O vencedor deste jogo é o primeiro jogador que puder encontrar todos os demais pelo menos
 * uma vez(cordas sao permitidas).
 * <p>
 * Assumindo que existe um metodo encontro(i, j) que e chamado cada vez que o jogador i encontra
 * o jogador j (com i != j). Quando i encontra com j é o mesmo que j encontrar o i.
 * <p>
 * Descreva uma maneira de manter os pares de jogadores que se encontram e quem e o vencedor.
 */
@Getter
public class GameMeetAtTheForest {

    public static final int MININUM_PLAYER_AMOUNT = 1_000;

    private Forest forest;
    private ForestPrinter printer;
    private ForestPlayerFinder finder;

    public GameMeetAtTheForest(ForestPlayerFinder finder, ForestPrinter printer) {
        this.finder = finder;
        this.printer = printer;

        this.forest = this.finder.forest();

        validar(this.forest.getNumberPlayers());
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

            winner = checkSameoneWon(winner, meeting);
        } while (winner.isEmpty());

        this.printer.mostraVencedor(winner.getAsInt());
    }

    private OptionalInt checkSameoneWon(OptionalInt winner, Meeting meeting) {
        if (this.forest.isPlayerWon(meeting.index1())) {
            return OptionalInt.of(meeting.index1());
        }

        if (this.forest.isPlayerWon(meeting.index2())) {
            return OptionalInt.of(meeting.index2());
        }

        return OptionalInt.empty();
    }
}

