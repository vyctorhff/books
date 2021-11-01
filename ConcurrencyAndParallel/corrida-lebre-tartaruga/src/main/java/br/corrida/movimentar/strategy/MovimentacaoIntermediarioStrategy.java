package br.corrida.movimentar.strategy;

import br.corrida.movimentar.Movimentar;
import br.corrida.posicao.Posicao;

public class MovimentacaoIntermediarioStrategy extends MovimentacaoStrategy {
	
	public MovimentacaoIntermediarioStrategy(Movimentar movimentar) {
		super(movimentar);
	}

	@Override
	public boolean isAplicavel() {
		return movimentar.getPosicoes().isMenorQueLimite(getPosicaoAtual(), movimentar.getAvanco());
	}

	@Override
	protected Posicao fazerMovimentacao() {
		Posicao atual = getPosicaoAtual();
		Posicao depois = movimentar.getPosicoes().getProximo(atual, movimentar.getAvanco());
		
		trocarPosicoes(atual, depois);
		return depois;
	}

}
