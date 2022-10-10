package br.torugo.livro.designerpatters.caelum;

/**
 * Created by linkcon on 31/03/17.
 */
public class RecuperarArquivoDisco extends RecuperarArquivoChain {

    public RecuperarArquivoDisco(RecuperarArquivoChain proximo) {
        super(proximo);
    }

    @Override
    public Arquivo recuperarArquivo(String nome) {
        return null;
    }
}
