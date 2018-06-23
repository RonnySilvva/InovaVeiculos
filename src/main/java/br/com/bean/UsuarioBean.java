package br.com.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

@Entity
@Table(name = "login")
@ManagedBean(name = "usuarioMB")
public class UsuarioBean {

	@Id
	@GeneratedValue
	private Integer id;
	private String usuario;
	private String senha;
	
	@Transient
	HttpServletRequest request;
	@Transient
	HttpServletResponse response;
	
	public String verificarLogin(){

			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();
			session.beginTransaction();
			
			
				List<UsuarioBean> listPessoas = new ArrayList<UsuarioBean>();	
				
				listPessoas = session.createQuery("from UsuarioBean where usuario = '"+usuario+"' and senha = '" + senha +"'").list();
				
				int tamanho = listPessoas.size();
				
				for(UsuarioBean i : listPessoas){
					System.out.println(i.getUsuario());
				}
				
				if(tamanho == 0){
					System.out.println("Usuario Invalido");
				}else{
					System.out.println("Usuario Logado");
					return "sucess";
				}
				
				session.close();
				factory.close();
		return null;
			}
	
	//***********GETTERS AND SETTERS***********
	//
	
	public UsuarioBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
