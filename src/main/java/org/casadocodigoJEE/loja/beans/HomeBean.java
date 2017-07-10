package org.casadocodigoJEE.loja.beans;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.casadocodigoJEE.loja.daos.LivroDao;
import org.casadocodigoJEE.loja.models.Livro;

@Model
public class HomeBean {
	
	@Inject
    private LivroDao dao;

    public List<Livro> ultimosLancamentos() {
        return dao.ultimosLancamentos();
    }
    public List<Livro> demaisLivros() {
        return dao.demaisLivros();
    }


}
