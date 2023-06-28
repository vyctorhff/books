package base.cap3.exercicios.forest.domain;

public record Meeting(int index1, int index2) {
    public boolean isTheSamePlayer() {
        return index1 == index2;
    }
}
