/*
 * Created on 12/06/2011, 17:23:04
 * Locate at Natal, Rio Grande do Norte
 *
 * Processo.java
 *
 * @autor torugo
 */
package br.study.base.cap5.filas.roundrobin;

/**
 * Thread controlado pelo escalonador.
 */
public class Processo extends Thread {

    private final Aplicacao aplicacao;

    // O escalonador ja chamou o metodo start desta Thread.
    private boolean jaIniciado;

    public Processo(Aplicacao aplicacao) {
        this.aplicacao = aplicacao;
        jaIniciado = false;
    }

    @Override
    public void run() {
        super.run();

        jaIniciado = true;

        try {
            aplicacao.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.err.println("Processo " + aplicacao.getAppName() + " terminou!");
    }

    @Override
    public void interrupt() {
        System.err.println();
        System.err.println("Processo (" + aplicacao.getAppName() + ") interrompido");

        super.interrupt();
    }

    public boolean isJaIniciado() {
        return jaIniciado;
    }

    public synchronized void continueProcess() {
        if (this.isJaIniciado()) {
            this.notify();
        } else {
            this.start();
        }
    }
}
