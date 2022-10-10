package br.estudo.livro;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.google.common.base.MoreObjects;

public class Carrinho {
	
	private String nomeUsuario;
	
	private Double valor;
	
	private int tamanho;
	
	public Carrinho() {
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Carrinho) {
			Carrinho t = (Carrinho) obj;
			
			return new EqualsBuilder()
					.append(nomeUsuario, t.getNomeUsuario())
					.append(valor, t.getValor())
					.build();
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(nomeUsuario)
				.append(valor)
				.build();
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(Carrinho.class)
				.add("nomeUsuario", nomeUsuario)
			.add("valor", valor)
			.add("tamanho", tamanho)
				.toString();
	}
}
