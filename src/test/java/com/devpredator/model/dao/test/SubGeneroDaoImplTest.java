package com.devpredator.model.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.devpredator.model.dao.SubGeneroDao;
import com.devpredator.model.dao.SubGeneroDaoImpl;
import com.devpredator.model.entity.SubGenero;

class SubGeneroDaoImplTest {

	@Test
	void testGuardar() {
		fail("Not yet implemented");
	}

	@Test
	void testActualizar() {
		fail("Not yet implemented");
	}

	@Test
	void testEliminar() {
		fail("Not yet implemented");
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
