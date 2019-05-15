package es.fpdual.primero.eadmin.modelo;

import java.time.LocalDate;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class DocumentoContable extends Documento {

	private final String numeroOperacionContable;
	private final Logger logger = LogManager.getLogger(DocumentoContable.class);

	public DocumentoContable(int id, String nombre, Usuario usuario, LocalDate fechaCreacion,
			String numeroOperacionContable) {
		super(id, nombre, usuario, fechaCreacion, TipoDocumento.DOCUMENTO_CONTABLE);
		this.numeroOperacionContable = numeroOperacionContable;
		logger.warn("Creado documento contable");
		System.out.println("hola!!");
	}

	// public String getNumeroOperacionContable() {
	// return numeroOperacionContable;
	// }

}
