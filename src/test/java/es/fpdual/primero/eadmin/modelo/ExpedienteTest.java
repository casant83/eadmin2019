package es.fpdual.primero.eadmin.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
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

		final DocumentoContable documentoContable = new DocumentoContable(10, "operacion contable", usuario,
				LocalDate.now(), "iub7676");

		final Documento documento = new DocumentoContable(15, "operacion", usuario, LocalDate.now(), "bhvj88998");

		final Documento documentoPadron = new DocumentoPadron(20, "nuevo documento", usuario, LocalDate.now(),
				"calle Baja");

		final List<Documento> documentos = new ArrayList<>();
		documentos.add(documentoContable);
		documentos.add(documentoPadron);
		documentos.add(documento);

		for (Documento documentoActual : documentos) {
			if (esDocumentoContable(documentoActual)) {
				System.out.println(documentoActual);
			}
		}

		documentos.stream().filter(documentoActual -> esDocumentoContable(documentoPadron))
				.forEach(documentoActual -> System.out.println(documentoActual));

		documentos.stream().filter(this::esDocumentoContable).forEach(System.out::println);

		documentos.stream().filter(this::esDocumentoContable).count();

		final List<Documento> documentosContables = documentos.stream().filter(this::esDocumentoContable)
				.collect(Collectors.toList());

		documentos.stream().map(documentoActual -> documentoActual.getNombre())
				.forEach(documentoActual -> System.out.println(documentoActual));

		documentos.stream().map(documentoActual -> documentoActual.getNombre()).map(nombre -> nombre.length())
				.forEach(longitud -> System.out.println(longitud));
		documentos.stream().map(Documento::getNombre).map(String::length).forEach(System.out::println);

		for (Documento documentoActual : documentos) {
			System.out.println(documentoActual.getNombre().length());
		}

		// ejecución
		final Expediente expediente = new Expediente(1, "expediente 1", usuario, LocalDate.now(),
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
		final LocalDate fechaCreacion = LocalDate.now();
		final Documento documento1 = new DocumentoContable(12, "uno", usuario, LocalDate.now(), "jyhvy7");
		final Documento documento2 = new DocumentoContable(14, "cuatro", usuario, LocalDate.now(), "g7ygba");
		final List<Documento> documentos = new ArrayList<>();
		documentos.add(documento1);
		documentos.add(documento2);
		final Expediente expediente = new Expediente(2, "nombre", usuario, fechaCreacion,
				TipoExpediente.EXPEDIENTE_GESTION, documentos);

		final List<Integer> resultado = expediente.obtenerLongitudNombresDocumentos();
		assertEquals(2, resultado.size());
		assertEquals(3, resultado.get(0).intValue());
		assertEquals(new Integer(6), resultado.get(1));

	}

	@Test
	public void deveriaDevolverDocumentosAgrupadosPorTipo() {
		final Usuario usuario2 = new Usuario(2, "Juana", "Alcaldesa");
		final LocalDate fechaCreacion2 = LocalDate.now();
		final Documento doc1 = new DocumentoContable(12, "uno", usuario2, LocalDate.now(), "jyhvy7");
		final Documento doc2 = new DocumentoContable(14, "cuatro", usuario2, LocalDate.now(), "g7ygba");
		final Documento doc3 = new DocumentoPadron(15, "otro", usuario2, LocalDate.now(), "gjy56");

		final List<Documento> documentos2 = new ArrayList<>();
		documentos2.add(doc1);
		documentos2.add(doc2);
		documentos2.add(doc3);

		final Expediente expediente2 = new Expediente(3, "nombres", usuario2, fechaCreacion2,
				TipoExpediente.EXPEDIENTE_GESTION, documentos2);

		Map<TipoDocumento, List<Documento>> resultado2 = expediente2.obtenerDocumentosPorTipo();
		assertEquals(2, resultado2.size());
	}

}
