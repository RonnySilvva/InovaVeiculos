package br.com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.controller.CarroBean;
import br.com.model.Carro;

@ManagedBean(name="CarroDaoMB")
public class CarroDAO <obj>{
	
	CarroBean car;
	
    public void saveMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Successful",  "Foi gravado com sucesso ") );
    }
    
	@SuppressWarnings("unchecked")
	public List<Carro> gerarTabela(){
		
		//conexão com o banco
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		//fim da conexão
		
		List<Carro> listcarros = new ArrayList <Carro>(); //cria a lsta com os atributos carros
		listcarros = session.createQuery("from Carro").list(); //faz a query e lista
		
//		int tamanho = listcarros.size();	
//		for(Carro carros : listcarros){
//			System.out.println(carros.getId());
//		}
		session.close();
		factory.close();
		
		return listcarros; //retorna a listcarros com a query
	}
	

	public List<Carro> pesquisarTabela(Carro car){

		//conexão com o banco
				SessionFactory factory = new Configuration().configure().buildSessionFactory();
				Session session = factory.openSession();
				session.beginTransaction();
				//fim da conexão

		List<Carro> listcarros = new ArrayList<Carro>();
		listcarros = session.createQuery("from Carro where marca like'" +car.getMarca()+"' or modelo like '"+car.getMarca()+"'").list();
		
		session.close();
		factory.close();
		
		return listcarros;
	}
	
	public void adicionarCarro(Carro car){

		car.setMarca(car.getMarca());
		car.setModelo(car.getModelo());
		car.setCor(car.getCor());
		car.setAno(car.getAno());
		car.setValor(car.getValor());
		car.setDescricao(car.getDescricao());
		
		//conexão com o banco
				SessionFactory factory = new Configuration().configure().buildSessionFactory();
				Session session = factory.openSession();
				session.beginTransaction();
				//fim da conexão
		
		session.save(car);
		saveMessage();
		session.getTransaction().commit();

		session.close();
		factory.close();

	}
	
}
