package com.caps.association1to1;

import javax.persistence.EntityManager;

import com.caps.model.JPAUtil;

public class HibernateMainClass2 
{
	public static void main(String[] args) {
		Person_OnetoOneBidirectional p=new Person_OnetoOneBidirectional();
		p.setId(3);
		p.setName("ROHIT SHARMA");
		Aadhar_OnetoOneBidirectional a=new Aadhar_OnetoOneBidirectional();
		a.setNumber(44558846);
		p.setAadhar(a);
		a.setPerson(p);
		EntityManager em=JPAUtil.getEMF().createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
		
		
				
	}
}
