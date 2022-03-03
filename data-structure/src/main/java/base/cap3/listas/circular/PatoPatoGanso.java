/*
 * Created on 16/02/2011, 15:50:41
 * Locate at Natal, Rio Grande do Norte
 *
 * PatoPatoGanso.java
 *
 * @autor torugo
 */
package base.cap3.listas.circular;

import java.util.Random;

/**
 * Um grupo de crianças senta em círculo. Uma delas e eleita para ser o
 * 'pegador' e caminhar por faora do circulo. O pegador bate na cabeca de cada
 * crianca dizendo 'pato' ate que identifica uma delas como sendo 'ganso'. Neste
 * ponto, gera-se ma confusao com o ganso e o pegador correndo ao redor do
 * circulo. Quem retornar ao lugar do ganso primeiro, permance no circulo. O
 * perdedor da corrida sera o pegador na proxima rodada.
 * <p>
 * Sera adotado o pegador removendo a primeira crianca apos o cursor.
 */
public class PatoPatoGanso {

    private final int NUMERO_RODADAS = 10;

    private final ListaCircular circulo;

    public PatoPatoGanso() {
        circulo = new ListaCircular();
    }

    public void addChild(String name) {
        circulo.inserir(new CircularNode(name));
    }

    public void play() {
        System.out.print("Playing Duck, Duck, Goose: ");
        printChildren();

        CircularNode catcher = raffletCatcher();
        System.out.println("Catcher is: " + catcher.getName());

        var count = 0;
        separator();

        do {
            printChildrenInTheCircle();
            CircularNode ganso = findAndRemoveGoose();

            if (sorteioAleatorio()) {
                catcher = catcherWins(catcher, ganso);
            } else {
                catcherLoses(catcher, ganso);
            }

            separator();
            count++;
        } while (count <= NUMERO_RODADAS);
    }

    private void catcherLoses(CircularNode catcher, CircularNode ganso) {
        circulo.inserir(ganso);
        System.out.println("Catcher still is " + catcher.getName());
    }

    private CircularNode catcherWins(CircularNode catcher, CircularNode ganso) {
        circulo.inserir(catcher);

        System.out.println("Catcher is now " + ganso.getName());
        return ganso;
    }

    private CircularNode raffletCatcher() {
        var numberIterations = new Random().nextInt(20);

        for (var count = 0; count < numberIterations; count++) {
            this.circulo.next();
        }

        return circulo.remover();
    }

    public void printChildren() {
        String nomeCrianca = circulo.getElement();
        String nome = circulo.getElement();

        do {
            System.out.print(nome + ", ");
            circulo.next();

            nome = circulo.getElement();

        } while (!nomeCrianca.equals(nome));

        System.out.println("\n");
    }

    private void printChildrenInTheCircle() {
        System.out.print("In the circle: ");
        printChildren();
    }

    private void printChildIs(String animal) {
        System.out.printf("%s is a %s\n", circulo.getElement(), animal);
    }

    private CircularNode findAndRemoveGoose() {
        CircularNode goose = null;

        // controlling the game to be not so quick and not so long
        // to choose the goose
        var mininumIteration = 3;
        var maxIteration = 6;
        var count = 0;

        while (true) {
            boolean minReached = count > mininumIteration;
            boolean maxReached = count > maxIteration;

            if ((minReached && isGanso()) || maxReached) {
                printChildIs("Goose");
                goose = circulo.remover();

                break;
            }

            printChildIs("Duck");
            count++;

            circulo.next();
        }

        return goose;
    }

    /**
     * Retorna uma boolean aleatorio com true para ganso e false para pato.
     *
     * @return
     */
    public boolean isGanso() {
        return sorteioAleatorio();
    }

    public boolean sorteioAleatorio() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        int valorAleatorio = random.nextInt(10);
        return valorAleatorio < 3;
    }

    private void separator() {
        System.out.println("-".repeat(50));
    }
}
