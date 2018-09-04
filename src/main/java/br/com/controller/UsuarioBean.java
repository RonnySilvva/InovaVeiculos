package br.com.controller;

import javax.faces.bean.ManagedBean;


import br.com.dao.LoginDAO;
import br.com.model.Usuario;

@ManagedBean(name = "usuarioMB")
public class UsuarioBean {

	Usuario usuario = new Usuario();
	LoginDAO<Usuario> dao = new LoginDAO<Usuario>();
	
	public void logar(){
		dao.verificarLogin(usuario);
	}
	

	public String VoltarInicio(){
		return "inicio";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LoginDAO<Usuario> getDao() {
		return dao;
	}

	public void setDao(LoginDAO<Usuario> dao) {
		this.dao = dao;
	}
	
}
