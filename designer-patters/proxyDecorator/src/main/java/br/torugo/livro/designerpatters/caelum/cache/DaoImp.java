package br.torugo.livro.designerpatters.caelum.cache;

import java.util.Arrays;
import java.util.List;

/**
 * Created by torugo on 07/04/17.
 */
public class DaoImp implements Dao {
	@Override
	public List<String> find() {
		return Arrays.asList("aaaa", "bbbb", "cccc");
	}
}
