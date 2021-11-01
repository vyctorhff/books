package br.corrida.posicao;

import java.util.ArrayList;
import java.util.List;

import br.corrida.participantes.Participante;

public class Posicoes {
	
	private int total;
	
	private List<Posicao> posicoes;

	public Posicoes(int total) {
		this.total = total;
		this.posicoes = new ArrayList<>();
		
		for (int count = 0; count < total; count++) {
			this.posicoes.add(new Posicao(count));
		}
	}

	public boolean isMenorQueLimite(Posicao posicao, int avanco) {
		return posicao.getIndice() + avanco < total;
	}

	public Posicao getPrimeira() {
		return posicoes.get(0);
	}
	
	public Posicao getUltima() {
		return this.posicoes.get(total - 1);
	}

	public Posicao findPosicaoParticipante(Participante participante) {
		for (Posicao posicao : posicoes) {
			if (posicao.hasParticipante(participante)) {
				return posicao;
			}
		}
		return null;
	}

	public Posicao getProximo(Posicao posicao, int avanco) {
		if (total <= avanco) {
			throw new IllegalArgumentException("Limite de posicoes extrapolado!");
		}
		return this.posicoes.get(posicao.getIndice() + avanco);
	}

	public boolean hasParcipanteNaUltimaPosicao() {
		return getUltima().hasAlgumParticipante();
	}
}
