package com.devpredator.model.dao;

import java.util.List;

import com.devpredator.model.entity.SubGenero;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class SubGeneroDaoImpl implements SubGeneroDao{

	@Override
	public void guardar(SubGenero subGenero) {
		// TODO Auto-generated method stub
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			em.persist(subGenero);
			et.commit();
		}catch(Exception e) {
			if(et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public void actualizar(SubGenero subGenero) {
		// TODO Auto-generated method stub
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.merge(subGenero);
			et.commit();
		}catch(Exception e) {
			if(et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		SubGenero subGenero = em.find(SubGenero.class, id);
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.remove(subGenero);
			et.commit();
		}catch(Exception e) {
			if(et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
		
	}

	@Override
	public List<SubGenero> consultar() {
		// TODO Auto-generated method stub
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		TypedQuery<SubGenero>query = (TypedQuery<SubGenero>) em.createQuery("from SubGenero order by descripcion");
		return query.getResultList();
	}

	@Override
	public SubGenero consultarById(Long id) {
		// TODO Auto-generated method stub
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		return em.find(SubGenero.class, id);
	}
	
	
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("persistenceDevPredator");

}
