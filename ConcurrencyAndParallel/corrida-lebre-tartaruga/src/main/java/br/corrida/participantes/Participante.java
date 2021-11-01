package br.corrida.participantes;

import br.corrida.ambiente.Pista;
import br.corrida.posicao.Posicao;
import br.corrida.util.Dado;
import br.corrida.util.Esperar;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public abstract class Participante implements Runnable {

	private final static int TEMPO_ESPERA_RODADA = 2000;
	
	protected String nome;
	
	protected Pista pista;
	private final int posicaoMinima;
	private final int posicaoMaxima;

	protected Posicao posicao;

	public Participante(String nome, Pista pista, int posicaoMinima, int posicaoMaxima) {
		this.nome = nome;
		this.pista = pista;

		this.posicaoMinima = posicaoMinima;
		this.posicaoMaxima = posicaoMaxima;
	}

	public int lancarDado() {
		return new Dado().lancar(posicaoMinima, posicaoMaxima);
	}

	public abstract String getSimbolo();

	@Override
	public void run() {
		System.out.println("Partil a/o " + nome + "!");
		
		while (!pista.hasVencedor()) {
			this.pista.avancar(this, lancarDado());
			this.esperarRodada();
		}
		
		pista.resultado(this);
	}
	
	protected void esperarRodada() {
		new Esperar().sleep(TEMPO_ESPERA_RODADA);
	}
	
	public String getNome() {
		return nome;
	}

	public static boolean equals(Participante p1, Participante p2) {
		return p1 != null && p1.equals(p2);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
			.append(nome)
			.append(getSimbolo())
			.build();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Participante) {
			Participante p = (Participante) obj;
			
			return new EqualsBuilder()
				.append(nome, p.nome)
				.append(getSimbolo(), p.getSimbolo())
				.build();
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
			.append(nome)
			.build();
	}
}