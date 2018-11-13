package com.caps.association1to1;

import javax.persistence.EntityManager;

import com.caps.model.JPAUtil;

public class HibernateMainClass {
	
	public static void main(String[] args) {
		Mobile_OnetoOneUnidirectional m=new Mobile_OnetoOneUnidirectional();
		m.setBrand("motorola");
		m.setId(2);
		Battery_OnetoOneUnidirectional b=new Battery_OnetoOneUnidirectional();
		b.setBrand("china_model");
		b.setPower(3000);
		m.setBattery(b);
		EntityManager em=JPAUtil.getEMF().createEntityManager();
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
		em.close();
		
	}

}
