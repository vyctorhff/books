/*
 * Created on 12/06/2011, 17:23:50
 * Locate at Natal, Rio Grande do Norte
 *
 * Escalonador.java
 *
 * @autor torugo
 */
package br.study.base.cap5.filas.roundrobin;

import br.study.base.cap5.filas.Fila;
import br.study.base.cap5.filas.FilaImp;

/**
 * Escalonador usa um fila para alocar um recurso de maneira igual
 * entre varias aplicacoes.
 */
public class EscalonadorRoundRobin {

    //Tempo em segundo que o processo tera para executar antes de ser interrompido
    private final long TEMPO_EXECUCAO_PROCESSO = 5_000;

    private final Fila<Processo> fila;

    public EscalonadorRoundRobin() {
        this.fila = new FilaImp<Processo>();
    }

    /**
     * Iniciaza o escalonador para gerencia os processos.
     *
     * @throws InterruptedException
     */
    public void initEscalonador() throws InterruptedException {
        Processo processo = this.getProximoProcesso();

        while (!this.fila.isEmpty()) {
            processo.continueProcess();

            // Esperando o tempo de troca de processo.
            Thread.sleep(TEMPO_EXECUCAO_PROCESSO);

            System.err.println("Alternando entre processos");
            processo.interrupt();

            this.reInfileirarProcesso();
            processo = this.getProximoProcesso();

            if (!processo.isAlive()) {
                fila.dequeue();
                continue;
            }
        }

        System.err.println("Todos os processos foram executados");
    }

    /**
     * Se for a primeira execucao, retorna o primeiro da fila.
     * Senao, coloca o primeiro como ultimo e retorna o atual primeiro
     * da fila.
     *
     * @return processo para a execacao.
     */
    private Processo getProximoProcesso() throws IllegalStateException {
        return fila.front();
    }

    /**
     * Remove o processo da primeira posicao e o insere na ultima posicao
     * da fila.
     */
    private void reInfileirarProcesso() {
        // Remove e adiciona o processo ao final do fila.
        fila.enqueue(fila.dequeue());
    }


    /**
     * Adiciona um processo a fila. Se ela estiver vazia, o processo sera inserido
     * do inicio; senao, no final.
     *
     * @param processo
     */
    public void addProcesso(Processo processo) {
        fila.enqueue(processo);
    }

}
