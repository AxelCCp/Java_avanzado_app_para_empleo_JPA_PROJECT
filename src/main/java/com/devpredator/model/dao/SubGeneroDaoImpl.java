package com.devpredator.model.dao;

import java.util.List;

import com.devpredator.model.entity.SubGenero;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class SubGeneroDaoImpl implements SubGeneroDao{

	@Override
	public void guardar(SubGenero subGenero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(SubGenero subGenero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
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
		return null;
	}
	
	
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("persistenceDevPredator");

}
