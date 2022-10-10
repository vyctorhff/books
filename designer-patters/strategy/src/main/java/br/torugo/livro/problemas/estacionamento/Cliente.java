package br.torugo.livro.problemas.estacionamento;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.google.common.base.MoreObjects;

public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String nome;
	
	private List<Veiculo> veiculos;

	public Cliente(String nome, List<Veiculo> veiculos) {
		this.nome = nome;
		this.veiculos = veiculos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Cliente) {
			Cliente t = (Cliente) obj;
			
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
		return MoreObjects.toStringHelper(Cliente.class)
				.add("nome", nome)
				.toString();
	}
}
