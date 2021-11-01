package br.corrida.participantes;

import br.corrida.ambiente.Pista;
import br.corrida.util.Dado;

public class Coelho extends Participante {

	private static final int NAO_AVANCA = 0;
	public static final int NUMERO_MINIMO_AVANCO = 0;
	public static final int NUMERO_MAIOR_AVANCO = 4;

	public static final String NOME = "Coelho";
	public static final String SIMBOLO = "C";

	private final Dado dado;
	private final SorteCoelho sorteCoelho;

	public Coelho(Pista pista) {
		super(NOME, pista);

		this.dado = new Dado();
		this.sorteCoelho = new SorteCoelho(dado);
	}

	@Override
	public String getSimbolo() {
		return SIMBOLO;
	}

	@Override
	public int lancarDado() {
		if (isParou()) {
			return NAO_AVANCA;
		}

		return dado.lancar(NUMERO_MINIMO_AVANCO, NUMERO_MAIOR_AVANCO);
	}

	public boolean isParou() {
		return this.sorteCoelho.isDormiu() ||
				this.sorteCoelho.isDistraiu() ||
				this.sorteCoelho.isConversou();
	}

	public static Thread toThread(Pista pista) {
		return new Thread(new Coelho(pista), NOME);
	}
}
