package com.devpredator.model.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.devpredator.model.dao.SubGeneroDao;
import com.devpredator.model.dao.SubGeneroDaoImpl;
import com.devpredator.model.entity.Genero;
import com.devpredator.model.entity.SubGenero;

class SubGeneroDaoImplTest {

	@Test
	void testGuardar() {
		SubGenero subGenero = new SubGenero();
		subGenero.setDescripcion("Hardcore");
		subGenero.setFechaCreacion(LocalDateTime.now());
		subGenero.setEstatus(true);
		Genero genero = new Genero();
		genero.setDescripcion("Metal");
		genero.setFechaCreacion(LocalDateTime.now());
		genero.setEstatus(true);
		subGenero.setGenero(genero);
		this.subGeneroDao.guardar(subGenero);
	}

	@Test
	void testActualizar() {
		SubGenero subGenero = this.subGeneroDao.consultarById(7L);
		subGenero.setDescripcion("Trash Metal");
		subGenero.getGenero().setDescripcion("Metal Trach");
		this.subGeneroDao.actualizar(subGenero);
	}

	@Test
	void testEliminar() {
		this.subGeneroDao.eliminar(7L);
	}

	@Test
	void testConsultar() {
		List<SubGenero> subGeneroList = this.subGeneroDao.consultar();
		assertTrue(subGeneroList.size() > 0);
		for(SubGenero subGenero : subGeneroList) {
			System.out.println("Subgenero: " + subGenero.getDescripcion());
			System.out.println("Genero: " + subGenero.getGenero().getDescripcion());
		}
	}

	@Test
	void testConsultarById() {
		fail("Not yet implemented");
	}
	
	
	private SubGeneroDao subGeneroDao = new SubGeneroDaoImpl();

}
