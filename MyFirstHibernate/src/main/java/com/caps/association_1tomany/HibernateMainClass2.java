package com.caps.association_1tomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.caps.model.JPAUtil;

public class HibernateMainClass2 
{
	public static void main(String[] args) {
		Bucket_Bidirectional bb=new Bucket_Bidirectional();
		bb.setBucket_id(2);
		bb.setName("Abhishek Gowda");
		List<IceCube> ic=new ArrayList<IceCube>();
		IceCube i=new IceCube();
		i.setIceCubeId(1);
		i.setSize("5");
		i.setBucket(bb);
		ic.add(i);
		i=new IceCube();
		i.setIceCubeId(2);
		i.setSize("10");
		i.setBucket(bb);
		ic.add(i);
		i=new IceCube();
		i.setIceCubeId(3);
		i.setSize("5");
		i.setBucket(bb);
		ic.add(i);
		bb.setIceCube(ic);
		EntityManager em=JPAUtil.getEMF().createEntityManager();
		em.getTransaction().begin();
		em.persist(bb);
		em.getTransaction().commit();
		em.close();
		
		
		
	}
	
}
