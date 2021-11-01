package br.corrida.participantes;

import br.corrida.util.Dado;

public class SorteCoelho {

    public static final int PERCENTUAL_CONVERSOU = 3;
    public static final int PERCENTUAL_DISTRAIU = 3;
    public static final int PERCENTUAL_DORMIU = 4;

    private final Dado dado;

    public SorteCoelho(Dado dado) {
        this.dado = dado;
    }

    public boolean isDormiu() {
        return lancarParaPercentual() <= PERCENTUAL_DORMIU;
    }

    public boolean isDistraiu() {
        return lancarParaPercentual() <= PERCENTUAL_DISTRAIU;
    }

    public boolean isConversou() {
        return lancarParaPercentual() <= PERCENTUAL_CONVERSOU;
    }

    private int lancarParaPercentual() {
        return dado.lancar(1, 10);
    }
}
