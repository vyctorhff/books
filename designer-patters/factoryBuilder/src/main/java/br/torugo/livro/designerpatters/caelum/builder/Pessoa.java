package br.torugo.livro.designerpatters.caelum.builder;

import com.google.common.base.MoreObjects;

import java.time.LocalDateTime;

/**
 * Created by torugo on 14/04/17.
 */
public class Pessoa {

	private String nome;

	private LocalDateTime dataNascimento;

	private String cargo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).toString();
	}
}
