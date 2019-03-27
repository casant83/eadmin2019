package es.fpdual.primero.eadmin.modelo;

import static org.junit.Assert.*;

import org.junit.Test;


public class DocumentoTest {

	@Test
	public void deberiaDevolverTrueSiLosDocumentosSonIguales() {
		//inicializar
		final Documento documento1 = new Documento(10, null, null, null, null);
		final Documento documento2 = new Documento(10,null, null, null, null);
		
		//ejecutar
		final boolean resultado = documento1.equals(documento2);
		
		//comprobación de resultados
		assertTrue(resultado);
	}
	
	@Test
	public void deberiaDevolverFalseSiLosDocumentosSonIguales() {
		//inicializar
		final Documento documento3 = new Documento(10, null, null, null, null);
		final Documento documento4 = new Documento(33,null, null, null, null);
		
		//ejecutar
		final boolean resultado = documento3.equals(documento4);
		
		//comprobación de resultados
		assertFalse(resultado);
	}
	
	@Test
	public void deberiaCalcularHashCode() {
		final Documento documento = new Documento(2,null,null,null,null);
		
		final int resultado = documento.hashCode();
		
		assertEquals(2, resultado);
	}

}
