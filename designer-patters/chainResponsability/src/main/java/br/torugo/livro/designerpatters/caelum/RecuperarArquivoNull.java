package br.torugo.livro.designerpatters.caelum;

/**
 * Created by linkcon on 31/03/17.
 */
public class RecuperarArquivoNull extends RecuperarArquivoChain {

    public RecuperarArquivoNull() {
        super(null);
    }

    public RecuperarArquivoNull(RecuperarArquivoChain proximo) {
        super(null);
    }

    @Override
    public Arquivo recuperarArquivo(String nome) {
        return null;
    }
}
