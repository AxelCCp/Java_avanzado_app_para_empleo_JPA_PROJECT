package com.devpredator.model.dao;

import java.util.List;

import com.devpredator.model.entity.Disquera;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;



public class DisqueraDaoImpl implements DisqueraDao{

	@Override
	public void guardar(Disquera disquera) {
		// TODO Auto-generated method stub
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.persist(disquera);
			et.commit();
		} catch(Exception e) {
			if(et != null) {																	//SI LA TRANSACCION SE HIZO MAL O INCOMPLETA, DALE ROLLBACK
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
		
	}

	@Override
	public void actualizar(Disquera disquera) {
		// TODO Auto-generated method stub
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.merge(disquera);
			et.commit();
		} catch(Exception e) {
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
		Disquera disquera = em.find(Disquera.class, id);
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.remove(disquera);
			et.commit();
		} catch(Exception e) {
			if(et != null) {														
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
		
	}

	@Override
	public List<Disquera> consultar() {
		// TODO Auto-generated method stub
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		TypedQuery<Disquera> queryDisquera =  (TypedQuery<Disquera>) em.createQuery("from Disquera order by descripcion");
		return queryDisquera.getResultList();
	}

	@Override
	public Disquera consultarPorId(Long id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		Disquera disqueraConsultado = em.find(Disquera.class, id);
		if(disqueraConsultado == null) {
			throw new EntityNotFoundException("La disquera con id " + id + " no se encontró");
		}
		return disqueraConsultado;
	}

	
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("persistenceDevPredator");
}
