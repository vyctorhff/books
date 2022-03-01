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

    private final int NUMERO_RODADAS = 4;
    private ListaCircular circulo;


    public PatoPatoGanso() {
        circulo = new ListaCircular();
        popularCriancas();
    }


    /**
     * Adiciona as criancas na lista circular.
     */
    private void popularCriancas() {
        circulo.inserir(new NodoCircular("Vic"));
        circulo.inserir(new NodoCircular("Alb"));

        circulo.inserir(new NodoCircular("Joana"));
        circulo.inserir(new NodoCircular("Junior"));

        circulo.inserir(new NodoCircular("Enoch"));
        circulo.inserir(new NodoCircular("Olivia"));
    }


    public void participantes() {
        String nomeCrianca = circulo.getElementoCursor();
        String nome = circulo.getElementoCursor();

        do {

            System.out.print(nome + ", ");
            circulo.avancar();

            nome = circulo.getElementoCursor();

        } while (!nomeCrianca.equals(nome));
    }


    public void iniciarBricadeira() {

        System.out.print("Jogando Pato, Pato, Ganso: ");
        participantes();
        System.out.println();


        NodoCircular pegador = circulo.remover();
        System.out.println("Pegador e " + pegador.getNome());


        for (int cont = 0; cont <= NUMERO_RODADAS; cont++) {

            System.out.println("-----------------------------------------------------------------");
            System.out.print("No circulo: ");
            participantes();
            System.out.println("\n-----------------------------------------------------------------");

            NodoCircular ganso = percorrerCirculoAtrasDoGanso();

            if (sorteioAleatorio()) {
                circulo.inserir(pegador); // Pagador ganhou a corrida.
                pegador = ganso;

                System.out.println("Pegador agora e " + pegador.getNome());

            } else {
                circulo.inserir(ganso); // Ganso ganhou.

                System.out.println("Pegador ainda e " + pegador.getNome());
            }
        }
    }


    /**
     * @return
     */
    private NodoCircular percorrerCirculoAtrasDoGanso() {

        NodoCircular ganso = null;

        while (true) {

            System.out.print(circulo.getElementoCursor() + " e ");

            if (isGanso()) {
                System.out.println("Ganso");
                ganso = circulo.remover();

                break;
            } else
                System.out.println("Pato");

            circulo.avancar();
        }

        return ganso;
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

        /*
         * Sorteio tendencioso para o falso, um vez que a probalidade e de 80% false, e 20% true.
         */
        return (valorAleatorio >= 2) ? false : true;
    }

}
