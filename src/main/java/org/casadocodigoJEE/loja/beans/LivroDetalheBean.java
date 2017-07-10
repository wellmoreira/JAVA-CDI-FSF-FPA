package org.casadocodigoJEE.loja.beans;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.casadocodigoJEE.loja.daos.LivroDao;
import org.casadocodigoJEE.loja.models.Livro;

@Model
public class LivroDetalheBean {

	@Inject
	private LivroDao dao;
	
	private Livro livro;
	
	private Integer id;
	
	public void carregaDetalhe() {
		this.livro = dao.buscarPorId(id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public LivroDao getDao() {
		return dao;
	}

	public void setDao(LivroDao dao) {
		this.dao = dao;
	}
	
}








