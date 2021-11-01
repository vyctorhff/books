package br.corrida.movimentar.strategy;

import br.corrida.movimentar.Movimentar;
import br.corrida.participantes.Participante;
import br.corrida.posicao.Posicao;

public abstract class MovimentacaoStrategy {

	protected Movimentar movimentar;

	public MovimentacaoStrategy(Movimentar movimentar) {
		this.movimentar = movimentar;
	}
	
	public abstract boolean isAplicavel();
	
	protected abstract Posicao fazerMovimentacao();
	
	public Posicao movimentar() {
		if (isAplicavel()) {
			return fazerMovimentacao();
		} else {
			return null;
		}
	}

	protected Posicao getPosicaoAtual() {
		return movimentar.getPosicoes()
			.findPosicaoParticipante(movimentar.getParticipante());
	}
	
	protected void trocarPosicoes(Posicao antes, Posicao depois) {
		Participante participante = movimentar.getParticipante();
		
		antes.remover(participante);
		depois.adicionar(participante);
	}
}
