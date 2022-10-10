package br.torugo.livro.designerpatters.caelum;

import br.torugo.livro.designerpatters.caelum.sistema1.SMSSender;
import org.junit.jupiter.api.Test;

/**
 * Created by torugo on 07/04/17.
 */
public class AdaptorEnviadorTest {

	@Test
	public void test() throws Exception {
		SMSSender sender = null;

		AdaptorEnviador adaptor = new AdaptorEnviador(sender);
		adaptor.enviar("aasfa", "destino", "texto");
	}
}