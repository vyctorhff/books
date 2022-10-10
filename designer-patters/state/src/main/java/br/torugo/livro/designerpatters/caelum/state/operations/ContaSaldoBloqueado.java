package br.torugo.livro.designerpatters.caelum.state.operations;

import br.torugo.livro.designerpatters.caelum.ContaStatus;
import br.torugo.livro.designerpatters.caelum.state.OperacaoConta;
import br.torugo.livro.designerpatters.caelum.state.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by torugo on 19/03/17.
 */
public class ContaSaldoBloqueado implements OperacaoConta {

	private Logger logger = LoggerFactory.getLogger(ContaSaldoBloqueado.class);

	@Override
	public Double deposito(State state, Double valor) {
		logger.info("deposito bloqueado");

		state.getConta().depositar(valor);

		if (state.getConta().getValor() < -100) {
			state.getConta().setContaStatus(ContaStatus.NEGATIVA);
			state.setOperacaoConta(new ContaSaldoNegativo());
		}

		return state.getConta().getValor();
	}

	@Override
	public Double saque(State state, Double valor) {
		logger.info("saque bloqueado");

		return state.getConta().getValor();
	}
}
