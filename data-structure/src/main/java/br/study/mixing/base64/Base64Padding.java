package br.study.mixing.base64;

public enum Base64Padding {

    NONE(0), SINGLE(1), DOUBLE(2);

    private final int number;

    Base64Padding(int number) {
        this.number = number;
    }

    public static Base64Padding valueOf(int numberLeftZeros) {
        var padding = switch (numberLeftZeros) {
            case 0 -> Base64Padding.NONE;
            case 2 -> Base64Padding.SINGLE;
            case 4 -> Base64Padding.DOUBLE;
            default -> throw new IllegalArgumentException("Invalid value:" + numberLeftZeros);
        };

        return padding;
    }

    public int getNumber() {
        return number;
    }
}
