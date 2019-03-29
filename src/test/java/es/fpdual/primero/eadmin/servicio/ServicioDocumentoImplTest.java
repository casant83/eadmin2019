package es.fpdual.primero.eadmin.servicio;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.primero.eadmin.modelo.Documento;
import es.fpdual.primero.eadmin.repositorio.RepositorioDocumento;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

public class ServicioDocumentoImplTest {

	RepositorioDocumento repositorioDocumento;
	ServicioDocumentoImpl servicioDocumento;
	Documento documento = mock(Documento.class);

	@Before
	public void inicializarAntesDeCadaTest() {
		this.repositorioDocumento = mock(RepositorioDocumento.class);
		this.servicioDocumento = new ServicioDocumentoImpl(repositorioDocumento);
	}

	@Test
	public void deberiaObtenerTodosLosDocumentos() {
		List<Documento> listaDevueltaPorElRepositorio = new ArrayList<>();
		when(repositorioDocumento.obtenerTodosDocumentos()).thenReturn(listaDevueltaPorElRepositorio);

		final List<Documento> resultado = servicioDocumento.obtenerTodosDocumentos();

		assertEquals(listaDevueltaPorElRepositorio, resultado);
	}

	@Test
	public void deberiaModificarUnDocumento() {
		servicioDocumento.modificarDocumento(documento);
		verify(this.repositorioDocumento).modificarDocumento(documento);;
	}

	@Test
	public void deberiaEliminarUnDocumento() {
		this.servicioDocumento.eliminarDocumento(20);
		verify(this.repositorioDocumento).eliminarDocumento(20);
	}

	@Test
	public void deberiaAlmacenarUnDocumento(){
		when(this.repositorioDocumento.getSiguienteId()).thenReturn(22);
		//está incompleto, porque harán falta los spy(y vete tú a saber qué es eso) 
		final Documento resultado = this.servicioDocumento.altaDocumento(documento);
		
	}
}
