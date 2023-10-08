package com.devpredator.model.dao;

import java.util.List;

import com.devpredator.model.entity.Disquera;

public interface DisqueraDao {
	
	void guardar(Disquera disquera);
	
	void actualizar(Disquera disquera);
	
	void eliminar(Disquera disquera);
	
	List<Disquera> consultar(); 

	Disquera consultarPorId(Long id);
	
}
