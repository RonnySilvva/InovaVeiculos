package br.com.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class teste {

	public static void main(String[] args) {

		UsuarioBean us = new UsuarioBean();
		us.verificarLogin();
	}

}
