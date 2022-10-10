package br.estudo.livro;

import javax.servlet.http.HttpServletRequest;

public class ApresentacaoCarrinhoCerto {

	public void colocarInformacoesCarrinhos(HttpServletRequest request) {
		Carrinho carrinho = CookieFactory.getCarrinhoInRequest(request);

		request.setAttribute("valor", carrinho.getValor());
		request.setAttribute("qtd", carrinho.getTamanho());

		if (request.getAttribute("username") == null) {
			request.setAttribute("userCarrinho", carrinho.getNomeUsuario());
		} else {
			request.setAttribute("userCarrinho", request.getAttribute("username"));
		}
	}
}
