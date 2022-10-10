package br.torugo.livro.designerpatters.caelum;

import br.torugo.livro.designerpatters.caelum.sistema1.SMS;
import br.torugo.livro.designerpatters.caelum.sistema1.SMSSender;
import br.torugo.livro.designerpatters.caelum.sistema2.EnviadorSMS;

/**
 * Created by torugo on 07/04/17.
 */
public class AdaptorEnviador implements EnviadorSMS {

	private SMSSender sender;

	public AdaptorEnviador(SMSSender sender) {
		this.sender = sender;
	}

	@Override
	public void enviar(String origem, String destino, String texto) {
		SMS sms = new SMS();

		sms.setDestino(destino);
		sms.setOrigem(origem);
		sms.setTexto(texto);

		sender.send(sms);
	}
}
