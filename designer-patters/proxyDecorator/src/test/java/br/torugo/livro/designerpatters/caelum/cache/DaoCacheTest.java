package br.torugo.livro.designerpatters.caelum.cache;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by torugo on 07/04/17.
 */
public class DaoCacheTest {

	@Test
	public void testDao() throws Exception {
		Dao dao = new DaoCache(new DaoImp());

		dao.find();
		dao.find();
	}
}