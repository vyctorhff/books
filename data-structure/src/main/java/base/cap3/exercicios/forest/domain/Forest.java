/*
 * Created on 06/2023
 * Locate at Majestic, Parnamirm, Rio Grande do Norte
 *
 * @autor torugo
 */
package base.cap3.exercicios.forest.domain;

import lombok.Getter;

public class Forest {

    // Players will be the rows and meets will be the columns
    @Getter
    private final boolean[][] meets;

    public Forest(int numberPlayers) {
        this.meets = new boolean[numberPlayers][numberPlayers];
    }

    public int getNumberPlayers() {
        return this.meets.length;
    }

    public void meet(Meeting meeting) {
        this.validateMeeting(meeting);

        if (meeting.isTheSamePlayer()) {
            return;
        }

        this.meets[meeting.index1()][meeting.index2()] = true;
        this.meets[meeting.index2()][meeting.index1()] = true;
    }

    private void validateMeeting(Meeting meeting) {
        var i = meeting.index1();
        var j = meeting.index2();

        boolean linhaInvalida = (i < 0 || i >= this.getNumberPlayers());
        boolean colunaInvalida = (j < 0 || j >= this.getNumberPlayers());

        if (linhaInvalida || colunaInvalida) {
            throw new IllegalArgumentException("Valores de linha e coluna invalidos");
        }
    }

    public boolean isPlayerWon(int index) {
        for (int count = 0; count < this.getNumberPlayers(); count++) {
            // ignoring a meet with itself
            if (index == count) {
                continue;
            }

            if (!this.meets[index][count]) {
                return false;
            }
        }

        return true;
    }
}
