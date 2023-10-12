/**
 * 
 */
package com.devpredator.model.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.devpredator.model.dao.DisqueraDao;
import com.devpredator.model.dao.DisqueraDaoImpl;
import com.devpredator.model.entity.Disquera;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Persistence;

/**
 * 
 */
class DisqueraDaoImplTest {

	/**
	 * Test method for {@link com.devpredator.model.dao.DisqueraDaoImpl#guardar(com.devpredator.model.entity.Disquera)}.
	 */
	@Test
	void testGuardar() {
		
		Disquera disquera = new Disquera();
		disquera.setDescripcion("Zzz' zz");
		disquera.setFechaCreacion(LocalDateTime.now());
		disquera.setEstatus(true);
		this.disqueraDao.guardar(disquera);
	}

	/**
	 * Test method for {@link com.devpredator.model.dao.DisqueraDaoImpl#actualizar(com.devpredator.model.entity.Disquera)}.
	 */
	@Test
	void testActualizar() {
		Disquera disqueraConsultada = this.disqueraDao.consultarPorId(9L);
		disqueraConsultada.setDescripcion("Disquera IronMaiden");
		this.disqueraDao.actualizar(disqueraConsultada);
	}

	/**
	 * Test method for {@link com.devpredator.model.dao.DisqueraDaoImpl#eliminar(com.devpredator.model.entity.Disquera)}.
	 */
	@Test
	void testEliminar() {
		Long id = 9L;
		this.disqueraDao.eliminar(id);
	}

	/**
	 * Test method for {@link com.devpredator.model.dao.DisqueraDaoImpl#consultar()}.
	 */
	@Test
	void testConsultar() {
		List<Disquera>disqueras = this.disqueraDao.consultar();
		assertTrue(disqueras.size() > 0);
		disqueras.forEach(d -> {
			System.out.println(d.getDescripcion());
		});
	}

	/**
	 * Test method for {@link com.devpredator.model.dao.DisqueraDaoImpl#consultarPorId(java.lang.Long)}.
	 */
	@Test
	void testConsultarPorId() {
		
		Disquera disquera =  disqueraDao.consultarPorId(10L);
		
		assertNotNull(disquera);
		
		System.out.println("Disquera: " + disquera.getDescripcion());
	}
	
	
	@Test
	void testConsultarByDescripcionJPQL() {
		
		Disquera disqueraConsultada = this.disqueraDao.consultarByDescripcionJPQL("Zzz' zz");
		
		assertNotNull(disqueraConsultada);
		
		System.out.println("disquera: " + disqueraConsultada);
	}
	
	
	@Test
	void testConsultarByDescripcionNative() {
		
		Disquera disqueraConsultada = this.disqueraDao.consultarByDescripcionNative("MegaForce");
		
		assertNotNull(disqueraConsultada);
		
		System.out.println("disquera: " + disqueraConsultada);
	}

	
	DisqueraDao disqueraDao = new DisqueraDaoImpl();
	
	
	
}
