package br.torugo.livro.designerpatters.caelum.kit;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class KitProdutoTest {

	@Test
	public void test() {
		Produto p1 = new Produto(20.0);
		Produto p2 = new Produto(20.0);
		
		List<Preco> lista = Arrays.asList(p1, p2);
		KitProduto kit = new KitProduto(lista);
		
		System.out.println(kit.getPreco());
	}

}
