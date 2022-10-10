package br.torugo.livro.problemas.estacionamento;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.google.common.base.MoreObjects;

public class Veiculo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String nome;
	
	private CategoriaVeiculo categoriaVeiculo;
	
	public Veiculo(String nome, CategoriaVeiculo categoriaVeiculo) {
		this.nome = nome;
		this.categoriaVeiculo = categoriaVeiculo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public CategoriaVeiculo getCategoriaVeiculo() {
		return categoriaVeiculo;
	}

	public void setCategoriaVeiculo(CategoriaVeiculo categoriaVeiculo) {
		this.categoriaVeiculo = categoriaVeiculo;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Veiculo) {
			Veiculo t = (Veiculo) obj;
			
			return new EqualsBuilder()
					.append(nome, t.getNome())
					.build();
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(nome)
				.build();
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(Veiculo.class)
				.add("nome", nome)
				.toString();
	}
	
}
