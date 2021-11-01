package br.corrida.participantes;

import br.corrida.ambiente.Pista;

public class Coelho extends Participante {

	public static final String NOME = "Coelho";
	public static final String SIMBOLO = "C";
	public static final int NUMERO_MINIMO_AVANCO = 0;
	public static final int NUMERO_MAIOR_AVANCO = 4;

	public Coelho(Pista pista) {
		super(NOME, pista, NUMERO_MINIMO_AVANCO, NUMERO_MAIOR_AVANCO);
	}
	
	@Override
	public String getSimbolo() {
		return SIMBOLO;
	}

	public static Thread toThread(Pista pista) {
		return new Thread(new Coelho(pista), NOME);
	}
}
