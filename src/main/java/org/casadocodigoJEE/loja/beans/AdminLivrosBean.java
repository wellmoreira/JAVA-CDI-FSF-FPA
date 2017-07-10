package org.casadocodigoJEE.loja.beans;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import javax.transaction.Transactional;

import org.casadocodigoJEE.loja.daos.AutorDao;
import org.casadocodigoJEE.loja.daos.LivroDao;
import org.casadocodigoJEE.loja.infra.FileSaver;
import org.casadocodigoJEE.loja.models.Autor;
import org.casadocodigoJEE.loja.models.Livro;

// as anototaions da nossas classses sao do cdi nao do JSF

//CDI
@Named(value="adminLivrosBean")// liga com a pagina xhtml
@RequestScoped
public class AdminLivrosBean {
	
	private Livro livro= new Livro();
	
	@Inject
	private LivroDao dao;
	@Inject
	private AutorDao autorDao;
	@Inject
	private FacesContext context; // foi feito injeção de dependencia na unha 
	private Part capaLivro;
	
	
	@Transactional
	public String salvar() throws IOException { // Mudamos o tipo de retorno
	    dao.salvar(livro);
	    FileSaver fileSaver = new FileSaver();	    
	    livro.setCapaPath(fileSaver.write(capaLivro, "livro"));
        context.getExternalContext().getFlash().setKeepMessages(true); // Aqui estamos ativando o FlashScope
	    context.addMessage(null, new FacesMessage("Livro cadastrado com sucesso!"));
	    System.out.println("Livro Cadastrado: " + livro);

	    return "/livro/lista?faces-redirect=true"; // E retornamos a página que o usuário irá sem o .xhtml
	}

	
	
	public List<Autor> getAutores(){// pega os autores e coloca em uma lista
        return autorDao.listar();

	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Part getCapaLivro() {
		return capaLivro;
	}

	public void setCapaLivro(Part capaLivro) {
		this.capaLivro = capaLivro;
	}

	
}
