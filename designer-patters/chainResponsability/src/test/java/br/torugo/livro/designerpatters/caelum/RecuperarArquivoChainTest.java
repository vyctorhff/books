package br.torugo.livro.designerpatters.caelum;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by linkcon on 31/03/17.
 */
public class RecuperarArquivoChainTest {
    @Test
    public void recuperarArquivo() throws Exception {
        Arquivo a = new Arquivo();
        a.setConteudo(new byte[20]);
        a.setNome("arquivo");

        RecuperarArquivoNull recuperarArquivoNull = new RecuperarArquivoNull();
        RecuperarArquivoDisco recuperarDisco = new RecuperarArquivoDisco(recuperarArquivoNull);
        RecuperarArquivoCache recuperarCache = new RecuperarArquivoCache(recuperarDisco);

        Arquivo arquivoEncontrado = recuperarCache.recuperar(a.getNome());
        assertNotNull(arquivoEncontrado);
    }
}