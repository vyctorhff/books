package base.cap3.exercicios.forest;

import base.cap3.exercicios.forest.domain.Forest;
import base.cap3.exercicios.forest.domain.Meeting;

import java.util.Random;

public record ForestPlayerFinder(Forest forest) {

    public Meeting find() {
        final var index1 = this.findRandow();
        final var index2 = this.findOtherPlayerWithout(index1);

        return new Meeting(index1, index2);
    }

    private int findRandow() {
        return this.getRandom().nextInt(forest.getNumberPlayers());
    }

    private int findOtherPlayerWithout(int index) {
        // first try
        var otherIndex = this.getRandom().nextInt(forest.getNumberPlayers());
        if (otherIndex != index) {
            return otherIndex;
        }

        // secundo try
        otherIndex = (int) ((index / 2) % 2);
        if (otherIndex != index) {
            return otherIndex;
        }

        // last try
        // TODO: find the player with less meets
        return 0;
    }

    private Random getRandom() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        return random;
    }
}
