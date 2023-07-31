/*
 * Created on 12/06/2011, 17:22:33
 * Locate at Natal, Rio Grande do Norte
 *
 * Aplicacao.java
 *
 * @autor torugo
 */
package br.study.base.cap5.filas.roundrobin;

/**
 * Aplicacao do usuario que se deseja executar no CPU e devera ser
 * gerenciado pelo escalonador.
 */
public interface Aplicacao {

    /**
     * @return No simbolico da aplicacao
     */
    String getAppName();


    /**
     * Regra de negocio da aplicacao.
     */
    void execute() throws Exception;

    boolean isFinished();
}
