package com.caps.hibernate;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.caps.beans.Movie;
import com.caps.model.JPAUtil;

public class App 
{
	public static void main( String[] args )
	{
		save();
	}
	
	public static void save() {
		System.out.println("Enter Movie Details");
		System.out.println("-------------------");
		Movie movie = new Movie();
		Scanner in = new Scanner(System.in);

		System.out.println("Enter movie id: ");
		movie.setMovieId(Integer.parseInt(in.nextLine()));

		System.out.println("Enter movie name: ");
		movie.setMovieName(in.nextLine());

		System.out.println("Enter movie ratings: ");
		movie.setRatings(Double.parseDouble(in.nextLine()));

		System.out.println("Enter movie summary: ");
		movie.setSummmary(in.nextLine());
		System.out.println("Movie Saved");
		EntityManagerFactory emf = JPAUtil.getEMF();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(movie);
		tx.commit();
	}
	public static void search() {
		System.out.println("-------------------");
		Scanner in = new Scanner(System.in);

		System.out.println("Enter movie id: ");
		int id=(Integer.parseInt(in.nextLine()));
		EntityManagerFactory emf = JPAUtil.getEMF();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Movie movie=em.getReference(Movie.class, id);		//Moive movie=em.find(Movie.class, id);
		System.out.println(movie);
		tx.commit();

		
	}
	public static void remove() {
		Scanner in= new Scanner(System.in);
		System.out.println("Enter movie id: ");
		int id=(Integer.parseInt(in.nextLine()));
		EntityManager em=JPAUtil.getEMF().createEntityManager();
		Movie movie=em.find(Movie.class, id);
		em.getTransaction().begin();
		em.remove(movie);
		em.getTransaction().commit();
		em.close();
		in.close();
	}
	public static void update() {
		
		Scanner in=new Scanner(System.in);
		System.out.println("enter the movie id:");
		int id=(Integer.parseInt(in.nextLine()));
		System.out.println("enter the movie ratings:");
		double ratings=(Double.parseDouble(in.nextLine()));
		EntityManager em=JPAUtil.getEMF().createEntityManager();
		em.getTransaction().begin();
		Movie movie=em.find(Movie.class, id);
		movie.setRatings(ratings);
		em.getTransaction().commit();
		em.close();
		in.close();
		
		
	}
	
}