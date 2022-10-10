package br.torugo.livro.designerpatters.caelum.assicrona;

/**
 * Created by torugo on 07/04/17.
 */
public class TransacaoAssincronaProxy implements Transacao {
	private Transacao transacao;

	public TransacaoAssincronaProxy(Transacao transacao) {
		this.transacao = transacao;
	}

	@Override
	public void executar() {
		new Thread(() -> transacao.executar()).start();
	}
}
