package br.torugo.livro.designerpatters.caelum.state;

import br.torugo.livro.designerpatters.caelum.Conta;

/**
 * Created by torugo on 19/03/17.
 */
public class State {

	// ATENÇÃO: essa classe poderia não existir, se operacaoConta estivesse na classe conta
	// porém, seperar essa responsabilidade da classe Conta, criei essa classe.
	private Conta conta;

	private OperacaoConta operacaoConta;

	public State(Conta conta, OperacaoConta operacaoConta) {
		this.conta = conta;
		this.operacaoConta = operacaoConta;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public OperacaoConta getOperacaoConta() {
		return operacaoConta;
	}

	public void setOperacaoConta(OperacaoConta operacaoConta) {
		this.operacaoConta = operacaoConta;
	}
}
