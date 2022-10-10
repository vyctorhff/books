package br.torugo.livro.designerpatters.caelum;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by linkcon on 31/03/17.
 */
public class Arquivo implements Serializable {

    private byte[] conteudo;

    private String nome;

    public byte[] getConteudo() {
        return conteudo;
    }

    public void setConteudo(byte[] conteudo) {
        this.conteudo = conteudo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isValid() {
        return !Objects.isNull(conteudo);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(Arquivo.class)
                .add("nome", nome)
                .toString();
    }

}
