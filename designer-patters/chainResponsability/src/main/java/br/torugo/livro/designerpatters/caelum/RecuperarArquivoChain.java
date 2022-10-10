package br.torugo.livro.designerpatters.caelum;

import java.util.Objects;

/**
 * Created by torugo on 31/03/17.
 */
public abstract class RecuperarArquivoChain {

    private RecuperarArquivoChain proximo;

    public RecuperarArquivoChain(RecuperarArquivoChain proximo) {
        this.proximo = proximo;
    }

    public abstract Arquivo recuperarArquivo(String nome);

    public Arquivo recuperar(String nome) {
        Arquivo a = this.recuperarArquivo(nome);

        if (!Objects.isNull(a) || a.isValid()) {
            return a;
        } else {
            return next(nome);
        }
    }

    public Arquivo next(String nome) {
        if (Objects.isNull(proximo)) {
            throw new IllegalStateException("Nao ha proximo");
        }
        return proximo.recuperar(nome);
    }
}
