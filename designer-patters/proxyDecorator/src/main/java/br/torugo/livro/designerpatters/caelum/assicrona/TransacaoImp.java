package br.torugo.livro.designerpatters.caelum.assicrona;

/**
 * Created by torugo on 07/04/17.
 */
public class TransacaoImp implements Transacao {
	@Override
	public void executar() {
		System.out.println("Executando transacao");
	}
}
