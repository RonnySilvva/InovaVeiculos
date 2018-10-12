package br.com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.dao.CarroDAO;
import br.com.model.Carro;

@ManagedBean(name="CarroMB")
public class CarroBean {
	
	private Carro carro =  new Carro();
	private CarroDAO<Carro> carroDao = new CarroDAO<Carro>();
	private List<Carro> carrolista = new ArrayList<Carro>();
	
	public List<Carro> pesquisar(){
		return carroDao.pesquisarTabela(carro);
	}
	
	public void apagar(Carro car){
		carroDao.apagarCarro(car);
	}
	
	public void editar(Carro car){
		carroDao.editarCarro(car);
	}
	
	public void adicionar() {
		carroDao.adicionarCarro(carro);
	}
	
	public List<Carro>gerarTabela() {
		return carroDao.gerarTabela();
	}
	
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public CarroDAO<Carro> getCarroDao() {
		return carroDao;
	}

	public void setCarroDao(CarroDAO<Carro> carroDao) {
		this.carroDao = carroDao;
	}

	public List<Carro> getCarrolista() {
		return carrolista;
	}

	public void setCarrolista(List<Carro> carrolista) {
		this.carrolista = carrolista;
	}

	

}
