package br.corrida.participantes;

import br.corrida.ambiente.Pista;

public class ParticipanteNulo extends Participante {

	// TODO: altera para o padrão nullobjet
	public ParticipanteNulo(String nome, Pista pista) {
		super(nome, pista);
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
