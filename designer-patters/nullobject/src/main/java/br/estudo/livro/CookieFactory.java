package br.estudo.livro;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ArrayUtils;

public class CookieFactory {
	
	public static Carrinho getCarrinhoInRequestErrrado(HttpServletRequest request) {
		return getCarrinhoInCookie(request);
	}
	
	public static Carrinho getCarrinhoInRequest(HttpServletRequest request) {
		Carrinho carrinho = getCarrinhoInCookie(request);
		return (carrinho == null) ? new CarrinhoNulo() : carrinho;
	}
	
	private static Carrinho getCarrinhoInCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		
		if (ArrayUtils.isNotEmpty(cookies)) {
			for (Cookie cookie: cookies) {
				if ("userCarrinho".equals(cookie.getName())) {
					// find carrinho por usuario
					return new Carrinho();
				}
			}
		}
		
		return null;
	}
	
}
