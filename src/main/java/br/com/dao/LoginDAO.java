package br.com.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.model.Usuario;

@ManagedBean(name="logindao")
public class LoginDAO <obj>{
	
	@SuppressWarnings("unchecked")
	public String verificarLogin(Usuario user){
		try{
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
	
		List<Usuario> listPessoas = new ArrayList<Usuario>();	
		
		listPessoas = session.createQuery("from Usuario where usuario = '"+user.getUsuario()+"' and senha = '" + user.getSenha() +"'").list();
		
		int tamanho = listPessoas.size();
		
		for(Usuario i : listPessoas){
			System.out.println(i.getUsuario());
		}
		
		if(tamanho == 0){
			System.out.println("Usuario Invalido");
			msgIncorreta();
		}else{
			System.out.println("Usuario Logado");
			PagePesquisarButton();
		}
		
		session.close();
		factory.close();
		}catch(IOException e){
			System.out.println(e);
		}
return null;
	}

	public void PagePesquisarButton() throws IOException{
		FacesContext.getCurrentInstance().getExternalContext().redirect("inicio.xhtml");
	}
	
public void msgIncorreta(){
	FacesContext context = FacesContext.getCurrentInstance();
	context.addMessage(null, new FacesMessage("Erro","Usuario ou Senha Incorreta"));
}

}