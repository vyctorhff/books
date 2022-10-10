package br.torugo.livro.problemas.estacionamento;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.google.common.base.MoreObjects;

public class Taxa {
	
	private double valor;
	
	private CategoriaVeiculo categoriaVeiculo;

	public Taxa(double valor, CategoriaVeiculo categoria) {
		this.valor = valor;
		this.categoriaVeiculo = categoria;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public CategoriaVeiculo getCategoriaVeiculo() {
		return categoriaVeiculo;
	}

	public void setCategoriaVeiculo(CategoriaVeiculo categoriaVeiculo) {
		this.categoriaVeiculo = categoriaVeiculo;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Taxa) {
			Taxa t = (Taxa) obj;
			
			return new EqualsBuilder()
					.append(valor, t.getValor())
					.append(categoriaVeiculo, t.getCategoriaVeiculo())
					.build();
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(valor)
				.append(categoriaVeiculo)
				.build();
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(Taxa.class)
				.add("valor", valor)
				.add("categoria", categoriaVeiculo)
				.toString();
	}
}
