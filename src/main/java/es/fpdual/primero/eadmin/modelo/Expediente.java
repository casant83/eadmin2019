package es.fpdual.primero.eadmin.modelo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Expediente extends AdministracionElectronicaBase{
	private final TipoExpediente tipoExpediente;
	private final List<Documento> documento;
	
	public Expediente(int id, String nombre, Usuario usuario, LocalDate fechaCreacion, TipoExpediente tipoExpediente, List<Documento> documento) {
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
		this.fechaCreacion = fechaCreacion;
		this.tipoExpediente = tipoExpediente;
		this.documento = documento;
	}

	public TipoExpediente getTipoExpediente() {
		return tipoExpediente;
	}
	
	public List<Documento> getDocumento() {
		return this.documento;
	}

	@Override
	public boolean equals (Object object) {
		if (object instanceof Expediente) {
			final Expediente expediente = (Expediente) object;
			return this.id == expediente.getId();

		}
		return false;
	}
	public List<Integer> obtenerLongitudNombresDocumentos(){
		if(documento.size()==0) {
			throw new AdministracionElectronicaException("Lista de documentos vacía");
		}
		return documento.stream().filter(this::esDocumentoContable).map(Documento::getNombre).map(String::length).collect(Collectors.toList());
	}
	
	public Map<TipoDocumento, List<Documento>> obtenerDocumentosPorTipo(){
		return documento.stream().collect(Collectors.groupingBy(Documento::getTipoDocumento));
	}
	
	
	private boolean esDocumentoContable(Documento documento) {
		return documento.getTipoDocumento().equals(TipoDocumento.DOCUMENTO_CONTABLE);
	}
}
