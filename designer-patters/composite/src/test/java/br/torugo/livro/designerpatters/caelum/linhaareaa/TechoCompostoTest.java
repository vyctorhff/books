package br.torugo.livro.designerpatters.caelum.linhaareaa;

import org.junit.Test;

public class TechoCompostoTest {

	@Test
	public void test() {
		TrechoSimples ts1 = new TrechoSimples("Sao Paulo", "Brasisila", 500.0);
		TrechoSimples ts2 = new TrechoSimples("Brasilia", "Recife", 300.0);
		TrechoSimples ts3 = new TrechoSimples("Recife", "Natal", 150.0);
		
		TechoComposto tc1 = new TechoComposto(ts2, ts3, 200.0);
		TechoComposto tc2 = new TechoComposto(ts1, tc1, 50.0);
		
		System.out.println(tc1.getPreco());
		System.out.println(tc2.getPreco());
	}

}
