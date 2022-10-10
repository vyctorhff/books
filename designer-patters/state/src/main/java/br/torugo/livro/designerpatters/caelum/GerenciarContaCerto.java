package br.torugo.livro.designerpatters.caelum;

import br.torugo.livro.designerpatters.caelum.state.State;
import br.torugo.livro.designerpatters.caelum.state.operations.ContaSaldoPositivo;

/**
 * Created by torugo on 19/03/17.
 */
public class GerenciarContaCerto {

	private final State state;

	public GerenciarContaCerto(Conta conta) {
		this.state = new State(conta, new ContaSaldoPositivo());
	}

	public Double deposito(Double valor) {
		return this.state.getOperacaoConta().deposito(this.state, valor);
	}

	public Double saque(Double valor) {
		return this.state.getOperacaoConta().saque(this.state, valor);
	}
}
