package com.devpredator.model.dao;

import java.util.List;

import com.devpredator.model.entity.SubGenero;

public interface SubGeneroDao {
	
	void guardar(SubGenero subGenero);
	
	void actualizar(SubGenero subGenero);
	
	void eliminar(Long id);
	
	List<SubGenero> consultar();
	
	SubGenero consultarById(Long id);

}
