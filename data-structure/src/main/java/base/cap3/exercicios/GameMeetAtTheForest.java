/*
 * Created on 17/02/2011, 16:08:03
 * Locate at Natal, Rio Grande do Norte
 *
 * JogoEncontroNaFloresta.java
 *
 * @autor torugo
 */
package base.cap3.exercicios;

import lombok.Getter;

import java.util.OptionalInt;
import java.util.Random;

/**
 * Suponha que voce esta projetando um jogo para varios jogadores que tem N >= 1000 jogadores.
 *
 * O vencedor deste jogo e o primeiro jogador que puder encontrar todos os demais pelo menos
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

    // Os jogadores seram as linhas e os encontros com os outros seram as colunas.
    private final boolean[][] meets;

    private final int totalPlayerNumber;

    private final Random random = new Random();

    // TODO: trying to refact the player to a class or record

    public GameMeetAtTheForest() {
        this(MININUM_PLAYER_AMOUNT);
        random.setSeed(System.currentTimeMillis());
    }

    public GameMeetAtTheForest(int totalPlayerNumber) {
        validar(totalPlayerNumber);
        this.totalPlayerNumber = totalPlayerNumber;

        meets = new boolean[totalPlayerNumber][totalPlayerNumber];
        random.setSeed(System.currentTimeMillis());
    }

    private void validar(int totalPlayerNumber) {
        if (totalPlayerNumber <= 0) {
            throw new IllegalArgumentException("Número de jogadores invalido");
        }

        if (totalPlayerNumber < MININUM_PLAYER_AMOUNT) {
            throw new IllegalArgumentException("Número de jogadores mínino é " + MININUM_PLAYER_AMOUNT);
        }
    }

    public void init() {
        OptionalInt winner;

        do {
            int player1 = getRandomIndexPlayer();
            int player2 = getRandomIndexByAnotherPlayer(player1);

            this.meet(player1, player2);

            winner = checkWinner(player1, player2);
        } while (winner.isEmpty());

        mostraVencedor(winner.getAsInt());
    }

    private int getRandomIndexByAnotherPlayer(int indexPlayer) {
        var index = getRandomIndexPlayer();
        var meetsPlayer = meets[indexPlayer];

        if (!meetsPlayer[index]) {
            return index;
        }

        return findNextAvailableMeetIndex(meetsPlayer);
    }

    private int findNextAvailableMeetIndex(boolean[] meetsPlayer) {
        for (var count = 0; count < meetsPlayer.length; count++) {
            var nextAvailableMeet = (count + 1) % meetsPlayer.length;

            if (!meetsPlayer[nextAvailableMeet]) {
                return nextAvailableMeet;
            }
        }
        return 0;
    }

    private OptionalInt checkWinner(int player1, int player2) {
        if (isPlayerWins(player1)) {
            return OptionalInt.of(player1);
        }

        if (isPlayerWins(player2)) {
            return OptionalInt.of(player2);
        }

        return OptionalInt.empty();
    }

    private void mostraVencedor(int indiceJogador) {
        System.out.println("------------------------------------------------");
        System.out.println("Jogo Encontra na Floresta!");
        System.out.println("Inidice do jogador que ganhou: " + indiceJogador);
        System.out.println("------------------------------------------------");
    }

    public void meet(int i, int j) {

        boolean linhaInvalida = (i < 0 || i >= totalPlayerNumber);
        boolean colunaInvalida = (j < 0 || j >= totalPlayerNumber);

        if (linhaInvalida || colunaInvalida) {
            throw new IllegalArgumentException("Valores de linha e coluna invalidos");
        }

        //Encontro do jogador com ele mesmo.
        if (i == j) {
            return;
        }

        meets[i][j] = true;
        meets[j][i] = true;
    }

    public int getRandomIndexPlayer() {
        return random.nextInt(totalPlayerNumber);
    }

    public boolean isPlayerWins(int indiceJogador) {
        boolean ganhou = true;

        for (int cont = 0; cont < totalPlayerNumber; cont++) {

            //Ignora o encontro do jogado com ele mesmo.
            if (cont == indiceJogador) continue;

            if (meets[indiceJogador][cont]) continue;

            ganhou = false;
        }

        return ganhou;
    }
}
