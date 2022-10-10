package br.torugo.livro.designerpatters.caelum.sistema2;

/**
 * Created by torugo on 07/04/17.
 */
public interface EnviadorSMS {
	void enviar(String origem, String destino, String texto);
}
