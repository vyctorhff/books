package br.estudo.livro;

import javax.servlet.http.HttpServletRequest;

public class ApresentacaoCarrinhoErrado {

	public void colocarInformacoesCarrinhos(HttpServletRequest request) {
		Carrinho c = CookieFactory.getCarrinhoInRequest(request);

		if (c != null) {
			request.setAttribute("valor", c.getValor());
			request.setAttribute("qtd", c.getTamanho());
		} else {
			request.setAttribute("valor", 0.0);
			request.setAttribute("qtd", 0);
		}

		if (request.getAttribute("username") == null) {
			if (c != null) {
				request.setAttribute("userCarrinho", c.getNomeUsuario());
			} else {
				request.setAttribute("userCarrinho", "<a href=login.jsp>Login</a>");
			}
		} else {
			request.setAttribute("userCarrinho", request.getAttribute("username"));
		}
	}
}
