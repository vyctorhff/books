package br.corrida.movimentar.strategy;

import br.corrida.movimentar.Movimentar;
import br.corrida.posicao.Posicao;

public class MovimentoFinalStrategy extends MovimentacaoStrategy {

	public MovimentoFinalStrategy(Movimentar movimentar) {
		super(movimentar);
	}
	
	@Override
	public boolean isAplicavel() {
		return !movimentar.getPosicoes()
				.isMenorQueLimite(getPosicaoAtual(), movimentar.getAvanco());
	}

	@Override
	protected Posicao fazerMovimentacao() {
		Posicao posicaoAvanco = movimentar.getPosicoes().getUltima();
		
		trocarPosicoes(getPosicaoAtual(), posicaoAvanco);
		return posicaoAvanco;
	}

}
