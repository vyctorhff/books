package br.corrida.participantes;

import br.corrida.ambiente.Pista;
import br.corrida.util.Dado;

public class Tartaruga extends Participante {

	public static final String NOME = "tartaruga";
	public static final String SIMBOLO = "T";
	public static final int NUMERO_MINIMO_AVANCO = 1;
	public static final int NUMERO_MAIOR_AVANCO = 2;

	public Tartaruga(Pista pista) {
		super(NOME, pista, NUMERO_MINIMO_AVANCO, NUMERO_MAIOR_AVANCO);
	}

	@Override
	public String getSimbolo() {
		return SIMBOLO;
	}

	public static Thread toThread(Pista pista) {
		return new Thread(new Tartaruga(pista), NOME);
	}
}
