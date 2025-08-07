package POO.servicios.abstracciones;

import POO.modelos.Documento;

import java.util.List;
import java.util.Optional;

public interface DocumentoServicio {
    List<Documento> obtenerDocumentos();
    Optional<Documento> obtenerDocumentoPorTitulo(String titulo);
    void agregarDocumento(Documento documento);
    void actualizarDocumento(String titulo, Documento documento);
    void eliminarDocumentoPorTitulo(String titulo);
}
