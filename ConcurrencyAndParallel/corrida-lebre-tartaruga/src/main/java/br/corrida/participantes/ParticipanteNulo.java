package br.corrida.participantes;

import br.corrida.ambiente.Pista;

public class ParticipanteNulo extends Participante {

	// TODO: altera para o padrão nullobjet
	public ParticipanteNulo(String nome, Pista pista, int posicaoMinima, int posicaoMaxima) {
		super(nome, pista, posicaoMinima, posicaoMaxima);
	}

	@Override
	public int lancarDado() {
		return 0;
	}

	@Override
	public String getSimbolo() {
		return "nullo";
	}

}
