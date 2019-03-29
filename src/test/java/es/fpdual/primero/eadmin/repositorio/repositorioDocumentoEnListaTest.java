package es.fpdual.primero.eadmin.repositorio;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import es.fpdual.primero.eadmin.modelo.AdministracionElectronicaException;
import es.fpdual.primero.eadmin.modelo.Documento;

public class repositorioDocumentoEnListaTest {
	
	private RepositorioDocumentoEnLista repositorioDocumentoEnLista;
	
	private Documento documento;

	
	@Before
	public void inicializarEnCadaTest() {
		this.repositorioDocumentoEnLista = new RepositorioDocumentoEnLista();
		this.documento = mock(Documento.class);
	}
	
	@Test
	public void deberiaAlmacenarUnDocumento() {
		
		when(documento.getNombre()).thenReturn("documento1");
		when(documento.getId()).thenReturn(5);
				
		this.repositorioDocumentoEnLista.altaDocumento(documento);
		
		
		assertTrue(this.repositorioDocumentoEnLista.obtenerTodosDocumentos().contains(documento));	
	}
	
	
	@Test (expected = AdministracionElectronicaException.class)
	public void deberiaLanzarExepcionAlmacenarUnDocumentoYaExistente() {
						
		this.repositorioDocumentoEnLista.altaDocumento(documento);
		this.repositorioDocumentoEnLista.altaDocumento(documento);
	}
	
	@Test
	public void deberiaModificarUnDocumento() {

		Documento documentoAlmacenado = new Documento(20,"documento1", null, null, null);
		Documento documentoModificado = new Documento(20,"documento2", null, null, null);
				
		this.repositorioDocumentoEnLista.altaDocumento(documentoAlmacenado);
		this.repositorioDocumentoEnLista.modificarDocumento(documentoModificado);
		
		assertEquals("documento2", this.repositorioDocumentoEnLista.obtenerTodosDocumentos().get(0).getNombre());
		
	}
	
	@Test (expected = AdministracionElectronicaException.class)
	public void deberiaLanzarExepcionAlModificarUnDocumentoQueNoExistente() {
		Documento documentoAlmacenado = new Documento(20,"documento1", null, null, null);
		
		this.repositorioDocumentoEnLista.modificarDocumento(documentoAlmacenado);
	}
	
	@Test
	public void deberiaEliminarUnDocumento() {
		when(documento.getId()).thenReturn(20);
		
		this.repositorioDocumentoEnLista.altaDocumento(documento);
		
		this.repositorioDocumentoEnLista.eliminarDocumento(20);
		
		assertTrue(this.repositorioDocumentoEnLista.obtenerTodosDocumentos().isEmpty());	
	}
	
	@Test
	public void deberiaNoHacerNadaSiElDocumentoAEliminarNoExiste() {
		
		this.repositorioDocumentoEnLista.eliminarDocumento(20);
		
	}
	
	@Test
	public void deberiaDevolverId1SiLaListaEstaVacia() {
		
		final int resultado = this.repositorioDocumentoEnLista.getSiguienteId();
		
		assertEquals(1, resultado);
			
	}
	
	@Test
	public void deberiaDevolver2SiHayUnDocumento() { 
	
		this.repositorioDocumentoEnLista.altaDocumento(documento);
		when(documento.getId()).thenReturn(10);
		
		final int resultado = this.repositorioDocumentoEnLista.getSiguienteId();
		assertEquals(11, resultado);
	
	}
}
