package es.fpdual.primero.eadmin.modelo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class DocumentoContableTest {
	
	@Test
	public void deberiaDevolverTrueSiLosDocumentosContablesSonIguales() {
		
		// inicializar
		final DocumentoContable documentoContable1 = new DocumentoContable(10, null, null, null, null);
		final DocumentoContable documentoContable2 = new DocumentoContable(10, null, null, null, null);

		// ejecutar
		final boolean resultado = documentoContable1.equals(documentoContable2);

		// comprobación de resultados
		assertTrue(resultado);
	}
}
