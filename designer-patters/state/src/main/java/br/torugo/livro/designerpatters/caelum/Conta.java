package br.torugo.livro.designerpatters.caelum;

import java.io.Serializable;

import com.google.common.base.MoreObjects;

/**
 * Created by torugo on 19/03/17.
 */
public class Conta implements Serializable {

	private static final long serialVersionUID = 2886720417473108444L;

	private Double valor;

    private ContaStatus contaStatus;

    public Conta(Double valor, ContaStatus contaStatus) {
        this.valor = valor;
        this.contaStatus = contaStatus;
    }

    public Double getValor() {
        return valor;
    }

    public ContaStatus getContaStatus() {
        return contaStatus;
    }

    public void setContaStatus(ContaStatus contaStatus) {
        this.contaStatus = contaStatus;
    }

    public void depositar(Double valor) {
        this.valor += valor;
    }

    public void sacar(Double valor) {
        this.valor -= valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Conta conta = (Conta) o;

        if (!valor.equals(conta.valor)) return false;
        return contaStatus == conta.contaStatus;
    }

    @Override
    public int hashCode() {
        int result = valor.hashCode();
        result = 31 * result + contaStatus.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(Conta.class)
                .add("valor", valor)
                .add("status", contaStatus)
                .toString();
    }
}
