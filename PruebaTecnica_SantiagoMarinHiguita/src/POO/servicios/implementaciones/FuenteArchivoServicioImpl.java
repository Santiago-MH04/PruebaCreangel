package POO.servicios.implementaciones;

import POO.modelos.Documento;
import POO.repositorios.implementaciones.FuenteArchivo;
import POO.servicios.abstracciones.DocumentoServicio;

import java.util.List;
import java.util.Optional;

public class FuenteArchivoServicioImpl implements DocumentoServicio {
    private FuenteArchivo repoFuenteArchivo;

    public FuenteArchivoServicioImpl(FuenteArchivo repoFuenteArchivo) {
        this.repoFuenteArchivo = repoFuenteArchivo;
    }

    @Override
    public List<Documento> obtenerDocumentos() {
        return this.repoFuenteArchivo.obtenerDocumentos();
    }

    @Override
    public Optional<Documento> obtenerDocumentoPorTitulo(String titulo) {
        return this.repoFuenteArchivo.obtenerDocumentoPorTitulo(titulo);
    }

    @Override
    public void agregarDocumento(Documento documento) {
        this.repoFuenteArchivo.agregarDocumento(documento);
    }

    @Override
    public void actualizarDocumento(String titulo, Documento documento) {
        if(this.repoFuenteArchivo.actualizarDocumento(titulo, documento)){
            System.out.printf("Documento %s '%s' actualizado con éxito", this.repoFuenteArchivo.FUENTE_ARCHIVO, titulo);
        };
            System.out.printf("Documento %s '%s' no encontrado en el archivo", this.repoFuenteArchivo.FUENTE_ARCHIVO, titulo);
    }

    @Override
    public void eliminarDocumentoPorTitulo(String titulo) {
        this.obtenerDocumentoPorTitulo(titulo)
            .ifPresent(fa -> this.repoFuenteArchivo.eliminarDocumentoPorTitulo(titulo));
    }
}
