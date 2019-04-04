package es.fpdual.primero.eadmin.servicio;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fpdual.primero.eadmin.EadminApplication;
import es.fpdual.primero.eadmin.modelo.Documento;
import es.fpdual.primero.eadmin.repositorio.RepositorioDocumento;



@Service
public class ServicioDocumentoImpl implements ServicioDocumento {
	private final RepositorioDocumento repositorioDocumento;
	

	@Autowired
	public ServicioDocumentoImpl(RepositorioDocumento repositorioDocumento) {
		this.repositorioDocumento = repositorioDocumento;
	}

	
	@Override
	public Documento altaDocumento(Documento documento) {
		final int siguienteId = repositorioDocumento.getSiguienteId();
		final Date fechaActual = new Date();
		Documento documentoModificado = new Documento(siguienteId, documento.getNombre(), documento.getUsuario(),
				fechaActual, documento.getTipoDocumento());
		repositorioDocumento.altaDocumento(documentoModificado);
		return documentoModificado;
	}

	@Override
	public void modificarDocumento(Documento documento) {
		repositorioDocumento.modificarDocumento(documento);
	}

	@Override
	public void eliminarDocumento(int codigoDocumento) {
		repositorioDocumento.eliminarDocumento(codigoDocumento);

	}

	@Override
	public List<Documento> obtenerTodosDocumentos() {
		return repositorioDocumento.obtenerTodosDocumentos();
	}

	@Override
	public Documento obtenerDocumentoPorId(int codigoDocumento) {
		return this.repositorioDocumento.obtenerDocumentoPorId(codigoDocumento);
	}
}
