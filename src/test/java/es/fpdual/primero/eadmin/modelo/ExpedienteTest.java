package es.fpdual.primero.eadmin.modelo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

public class ExpedienteTest {

	@Test
	public void deberiaDevolverTrueSiLosExpedientesSonIguales() {
		// inicializar
		final Expediente expediente1 = new Expediente(10, null, null, null, null, null);
		final Expediente expediente2 = new Expediente(10, null, null, null, null, null);

		// ejecutar
		final boolean resultado = expediente1.equals(expediente2);

		// comprobación de resultados
		assertTrue(resultado);
	}

	@Test
	public void deberiaDevolverFalseSiLosExpedientesSonIguales() {
		// inicializar
		final Expediente expediente3 = new Expediente(10, null, null, null, null, null);
		final Expediente expediente4 = new Expediente(33, null, null, null, null, null);

		// ejecutar
		final boolean resultado = expediente3.equals(expediente4);

		// comprobación de resultados
		assertFalse(resultado);
	}

	@Test
	public void deberiaCalcularHashCode() {
		final Expediente expediente = new Expediente(2, null, null, null, null, null);

		final int resultado = expediente.hashCode();

		assertEquals(2, resultado);
	}

	@Test
	public void deberiaConstruirUnExpedienteConDocumentos() {
		final Usuario usuario = new Usuario(1, "Juan", "Alcalde");

		final DocumentoContable documentoContable = new DocumentoContable(10, "operacion contable", usuario, new Date(),
				"iub7676");

		final Documento documento = new DocumentoContable(15, "operacion", usuario, new Date(), "bhvj88998");
		
		final Documento documentoPadron = new DocumentoPadron(20, "nuevo documento", usuario, new Date(), "calle Baja");

		final List<Documento> documentos = new ArrayList<>();
		documentos.add(documentoContable);
		documentos.add(documentoPadron);
		documentos.add(documento);
		

		for (Documento documentoActual : documentos) {
			if (esDocumentoContable(documentoActual)) {
				System.out.println(documentoActual);
			}
		}
		
		documentos.stream().filter(documentoActual -> esDocumentoContable(documentoPadron)).forEach(documentoActual -> System.out.println(documentoActual));
		
		documentos.stream().filter(this::esDocumentoContable).forEach(System.out::println);
		
		documentos.stream().filter(this::esDocumentoContable).count();
		
		final List<Documento> documentosContables = documentos.stream().filter(this::esDocumentoContable).collect(Collectors.toList());
		
		documentos.stream().map(documentoActual -> documentoActual.getNombre()).forEach(documentoActual -> System.out.println(documentoActual));
		
		documentos.stream().map(documentoActual -> documentoActual.getNombre()).map(nombre -> nombre.length()).forEach(longitud -> System.out.println(longitud));
		documentos.stream().map(Documento::getNombre).map(String::length).forEach(System.out::println);
		
		for (Documento documentoActual : documentos) {
			System.out.println(documentoActual.getNombre().length());
		}
		
		// ejecución
		final Expediente expediente = new Expediente(1, "expediente 1", usuario, new Date(),
				TipoExpediente.EXPEDIENTE_OBRAS, documentos);

		// comprobación de resultados
		assertEquals(documentos, expediente.getDocumento());
		assertTrue(expediente.getDocumento().contains(documentoContable));
		assertEquals(3, expediente.getDocumento().size());

	}
	public boolean esDocumentoContable(Documento documento) {
		return documento.getTipoDocumento().equals(TipoDocumento.DOCUMENTO_CONTABLE);
	}
	@Test
	public void deberiaSerIgualAObtenerLongitudNombresDocumentos() {
		
		final Usuario usuario = new Usuario(2, "Juana", "Alcaldesa");
		final Date fechaCreacion = new Date();
		final Documento documento1 = new DocumentoContable(12, "uno", usuario, new Date(), "jyhvy7");
		final Documento documento2 = new DocumentoContable(14, "cuatro", usuario, new Date(), "g7ygba");
		final List<Documento> documentos = new ArrayList<>();
		documentos.add(documento1);
		documentos.add(documento2);
		final Expediente expediente = new Expediente(2, "nombre", usuario, fechaCreacion, TipoExpediente.EXPEDIENTE_GESTION, documentos);
		
		final List<Integer> resultado = expediente.obtenerLongitudNombresDocumentos();
		assertEquals(2, resultado.size());
		assertEquals(3, resultado.get(0).intValue());
		assertEquals(new Integer(6), resultado.get(1));
		
	}
	
	@Test
	public void deveriaDevolverDocumentosAgrupadosPorTipo() {
		final Usuario usuario = new Usuario(2, "Juana", "Alcaldesa");
		final Date fechaCreacion = new Date();
		final Documento doc1 = new DocumentoContable(12, "uno", usuario, new Date(), "jyhvy7");
		final Documento doc2 = new DocumentoContable(14, "cuatro", usuario, new Date(), "g7ygba");
		final Documento doc3 = new DocumentoPadron(15, "otro", usuario, new Date(), "gjy56");
		
	//	 Map<TipoDocumento, List<Documento>> obtenerDocumentosPorTipo()= new Map<>;
	}	
	
}
