package br.corrida.posicao;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.corrida.participantes.Participante;

public class Posicao {

	private int indice;
	
	private Participante p1;

	private Participante p2;

	public Posicao(int posicao) {
		this.indice = posicao;
	}

	public void adicionar(Participante participante) {
		if (p1 == null) {
			this.p1 = participante;
		} else {
			this.p2 = participante;
		}
	}
	
	public void remover(Participante participante) {
		if (participante.equals(p1)) {
			this.p1 = null;
		} else {
			this.p2 = null;
		}
	}

	public boolean hasDoisParticipantes() {
		return this.p1 != null && this.p2 != null;
	}
	
	public boolean hasAlgumParticipante() {
		return this.p1 != null || this.p2 != null;
	}

	public boolean hasParticipante(Participante participante) {
		if (this.hasDoisParticipantes()
			|| Participante.equals(p1, participante)
			|| Participante.equals(p2, participante)) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getIndice() {
		return indice;
	}

	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
			.append(indice)
			.append(p1)
			.append(p2)
			.build();
	}
}
