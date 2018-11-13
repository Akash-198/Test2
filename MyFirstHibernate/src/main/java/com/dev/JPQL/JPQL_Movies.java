package com.dev.JPQL;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.caps.beans.Movie;
import com.caps.model.JPAUtil;

public class JPQL_Movies 
{
	public static void main(String[] args) {
		EntityManager em=JPAUtil.getEMF().createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Movie> query=em.createNamedQuery("getAllMovies", Movie.class);
		//TypedQuery<Movie> query=em.createQuery("from Movie s where s.id=?1", Movie.class);
		//query.setParameter(1, 3);//dynamic values.........................................
		//TypedQuery<Movie> query=em.createQuery("from Movie s order by s.id", Movie.class);
		List<Movie> students=query.getResultList();
		for (Movie s : students) {
			System.out.println(s.getMovieName());
		}
		em.getTransaction().commit();
		em.close();
	}
}
