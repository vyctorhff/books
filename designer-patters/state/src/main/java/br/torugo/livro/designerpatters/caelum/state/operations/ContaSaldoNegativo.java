package br.torugo.livro.designerpatters.caelum.state.operations;

import br.torugo.livro.designerpatters.caelum.ContaStatus;
import br.torugo.livro.designerpatters.caelum.state.OperacaoConta;
import br.torugo.livro.designerpatters.caelum.state.State;
import org.slf4j.LoggerFactory;

/**
 * Created by torugo on 19/03/17.
 */
public class ContaSaldoNegativo implements OperacaoConta {

	private org.slf4j.Logger logger = LoggerFactory.getLogger(ContaSaldoNegativo.class);

	@Override
	public Double deposito(State state, Double valor) {
		logger.info("deposito negativo");

		state.getConta().depositar(valor);

		if (state.getConta().getValor() >= 0) {
			state.setOperacaoConta(new ContaSaldoPositivo());
			state.getConta().setContaStatus(ContaStatus.POSITIVA);
		}

		return state.getConta().getValor();
	}

	@Override
	public Double saque(State state, Double valor) {
		logger.info("saque negativo");

		state.getConta().sacar(valor);

		if (state.getConta().getValor() <= -100) {
			state.setOperacaoConta(new ContaSaldoBloqueado());
			state.getConta().setContaStatus(ContaStatus.BLOQUEADA);
		}

		return state.getConta().getValor();
	}
}
