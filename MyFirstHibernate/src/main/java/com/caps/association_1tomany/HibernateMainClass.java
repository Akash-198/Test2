package com.caps.association_1tomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.caps.model.JPAUtil;

public class HibernateMainClass {
	public static void main(String[] args) {

		PencilBox_UniDirectional pbox = new PencilBox_UniDirectional();
		pbox.setId(101);
		pbox.setSize("10");
		
		List<Pencil> pencils = new ArrayList<Pencil>();
		
		Pencil p1 = new Pencil();
		p1.setName("Natraj");
		p1.setPencilId(1);
		pencils.add(p1);
		
		
		Pencil p2 = new Pencil();
		p2.setName("Apsara");
		p2.setPencilId(2);
		pencils.add(p2);
		
		Pencil p3 = new Pencil();
		p3.setName("Camlin");
		p3.setPencilId(3);
		pencils.add(p3);
		
		pbox.setPencils(pencils);
		
		EntityManagerFactory emf = JPAUtil.getEMF();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(pbox);
		em.getTransaction().commit();
		em.close();
	}
}
