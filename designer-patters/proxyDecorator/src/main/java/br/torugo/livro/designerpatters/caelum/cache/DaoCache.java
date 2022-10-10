package br.torugo.livro.designerpatters.caelum.cache;

import java.util.List;
import java.util.Objects;

/**
 * Created by torugo on 07/04/17.
 */
public class DaoCache implements Dao {

	private Dao dao;

	private List<String> lista;

	public DaoCache(Dao dao) {
		this.dao = dao;
	}

	@Override
	public List<String> find() {
		if (!Objects.isNull(lista) && !lista.isEmpty()) {
			return lista;
		}
		lista = dao.find();
		return lista;
	}
}
