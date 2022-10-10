package br.torugo.livro.designerpatters.caelum;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by linkcon on 31/03/17.
 */
public class RecuperarArquivoCache extends RecuperarArquivoChain {

    private Map<String, Arquivo> cache = new HashMap<>();

    public RecuperarArquivoCache(RecuperarArquivoChain proximo) {
        super(proximo);
    }

    @Override
    public Arquivo recuperarArquivo(String nome) {
        if (cache.containsKey(nome)) {
            return cache.get(nome);
        } else {
            return null;
        }
    }

    @Override
    public Arquivo next(String nome) {
        Arquivo a = next(nome);

        if (Objects.isNull(a)) {
            cache.put(nome, a);
        }

        return a;
    }
}
