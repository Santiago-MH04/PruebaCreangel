package POO.repositorios.abstracciones;

import POO.modelos.Documento;

import java.util.List;
import java.util.Optional;

public interface FuenteDatos {
    List<Documento> obtenerDocumentos();
    Optional<Documento> obtenerDocumentoPorTitulo(String titulo);
    void agregarDocumento(Documento documento);
    boolean actualizarDocumento(String titulo, Documento documento);
    void eliminarDocumentoPorTitulo(String titulo);
}
