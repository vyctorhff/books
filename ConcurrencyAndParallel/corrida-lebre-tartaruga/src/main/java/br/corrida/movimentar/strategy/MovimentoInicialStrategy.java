package br.corrida.movimentar.strategy;

import br.corrida.movimentar.Movimentar;
import br.corrida.posicao.Posicao;

public class MovimentoInicialStrategy extends MovimentacaoStrategy {

	public MovimentoInicialStrategy(Movimentar movimentar) {
		super(movimentar);
	}

	@Override
	public boolean isAplicavel() {
		return getPosicaoAtual() == null;
	}
	
	@Override
	protected Posicao fazerMovimentacao() {
		Posicao posicaoAvanco = movimentar.getPosicoes().getPrimeira();
		posicaoAvanco.adicionar(movimentar.getParticipante());
		
		return posicaoAvanco;
	}

}
