package base.cap3.exercicios.forest;

import base.cap3.exercicios.forest.domain.Forest;
import base.cap3.exercicios.forest.domain.Meeting;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record ForestPlayerFinder(Forest forest) {

    public Meeting find() {
        final var index1 = this.findRandomIndex();
        final var index2 = this.findIndexOtherPlayer(index1);

        return new Meeting(index1, index2);
    }

    public int findRandomIndex() {
        return this.getRandom().nextInt(forest.getNumberPlayers());
    }

    public int findIndexOtherPlayer(int index) {
        // first try
//        var otherIndex = this.getRandom().nextInt(forest.getNumberPlayers());
//        if (otherIndex != index) {
//            return otherIndex;
//        }

        // secundo try
//        otherIndex = (int) ((index / 2) % 2);
//        if (otherIndex != index) {
//            return otherIndex;
//        }

        return this.getIndexWithLessMeetings();
    }

    private int getIndexWithLessMeetings() {
        var mapTotalMettingByPlayer = new HashMap<Integer, Integer>();

        for (var indexPlayer = 0; indexPlayer < this.forest.getMeets().length; indexPlayer++) {

            for (var indexMeeting = 0; indexMeeting < this.forest.getMeets()[indexPlayer].length; indexMeeting++) {

                mapTotalMettingByPlayer.computeIfAbsent(indexPlayer, key -> 1);
                mapTotalMettingByPlayer.computeIfPresent(indexPlayer, (key, value) -> value + 1);
            }
        }

        return Collections.max(mapTotalMettingByPlayer.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private Random getRandom() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        return random;
    }
}
