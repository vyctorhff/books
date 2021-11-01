package br.corrida.movimentar;

import br.corrida.movimentar.strategy.MovimentacaoIntermediarioStrategy;
import br.corrida.movimentar.strategy.MovimentacaoStrategy;
import br.corrida.movimentar.strategy.MovimentoFinalStrategy;
import br.corrida.movimentar.strategy.MovimentoInicialStrategy;
import br.corrida.participantes.Participante;
import br.corrida.posicao.Posicao;
import br.corrida.posicao.Posicoes;

import java.util.Arrays;
import java.util.List;

public class Movimentar {

	private int avanco;
	
	private Participante participante;

	private Posicoes posicoes;

	public Movimentar(Posicoes posicoes, Participante participante) {
		this.participante = participante;
		this.posicoes = posicoes;
	}

	public Posicao movimentar(int avanco) {
		this.avanco = avanco;
		
		List<MovimentacaoStrategy> movimentos = Arrays.asList(
			new MovimentoInicialStrategy(this),
			new MovimentacaoIntermediarioStrategy(this),
			new MovimentoFinalStrategy(this)
		);
		
		for (MovimentacaoStrategy movimentacao : movimentos) {
			Posicao posicaoAvanco = movimentacao.movimentar();
			
			if (posicaoAvanco != null) {
				return posicaoAvanco;
			}
		}

		return null;
	}

	public int getAvanco() {
		return avanco;
	}
	
	public void setAvanco(int avanco) {
		this.avanco = avanco;
	}

	public Participante getParticipante() {
		return participante;
	}

	public Posicoes getPosicoes() {
		return posicoes;
	}

}