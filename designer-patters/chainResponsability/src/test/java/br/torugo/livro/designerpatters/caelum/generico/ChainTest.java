package br.torugo.livro.designerpatters.caelum.generico;

import org.junit.Test;

import java.util.Random;

/**
 * Created by torugo on 07/04/17.
 */
public class ChainTest {

	@Test
	public void testChain() throws Exception {
		Chain chain = new Responsability1(new Responsability2(new ResponsabilityNull()));

		int ramdon = new Random().nextInt(50);
		System.out.println(ramdon);
		System.out.println(chain.templateMethod(ramdon));
	}
}