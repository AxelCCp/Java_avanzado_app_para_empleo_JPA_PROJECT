package com.devpredator.model.dao;

import java.util.List;

import com.devpredator.model.entity.Disquera;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;



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
		
	}

	@Override
	public void eliminar(Disquera disquera) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Disquera> consultar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Disquera consultarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("persistenceDevPredator");
}
