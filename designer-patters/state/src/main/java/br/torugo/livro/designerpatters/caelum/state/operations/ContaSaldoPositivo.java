package br.torugo.livro.designerpatters.caelum.state.operations;

import br.torugo.livro.designerpatters.caelum.ContaStatus;
import br.torugo.livro.designerpatters.caelum.state.OperacaoConta;
import br.torugo.livro.designerpatters.caelum.state.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContaSaldoPositivo implements OperacaoConta {

	private Logger logger = LoggerFactory.getLogger(ContaSaldoPositivo.class);

	@Override
	public Double deposito(State state, Double valor) {
		logger.info("deposito positivo");

		state.getConta().depositar(valor);
		return state.getConta().getValor();
	}

	@Override
	public Double saque(State state, Double valor) {
		logger.info("saque positivo");

		state.getConta().sacar(valor);

		if (state.getConta().getValor() < 0.0) {
			state.getConta().setContaStatus(ContaStatus.NEGATIVA);
			state.setOperacaoConta(new ContaSaldoNegativo());
		}

		return state.getConta().getValor();
	}
}
