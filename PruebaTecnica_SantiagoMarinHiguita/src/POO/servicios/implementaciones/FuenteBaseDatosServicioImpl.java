package POO.servicios.implementaciones;

import POO.modelos.Documento;
import POO.repositorios.implementaciones.FuenteBaseDatos;
import POO.servicios.abstracciones.DocumentoServicio;

import java.util.List;
import java.util.Optional;

public class FuenteBaseDatosServicioImpl implements DocumentoServicio {
    private FuenteBaseDatos repoFuenteBaseDatos;

    public FuenteBaseDatosServicioImpl(FuenteBaseDatos repoFuenteBaseDatos) {
        this.repoFuenteBaseDatos = repoFuenteBaseDatos;
    }

    @Override
    public List<Documento> obtenerDocumentos() {
        return this.repoFuenteBaseDatos.obtenerDocumentos();
    }

    @Override
    public Optional<Documento> obtenerDocumentoPorTitulo(String titulo) {
        return this.repoFuenteBaseDatos.obtenerDocumentoPorTitulo(titulo);
    }

    @Override
    public void agregarDocumento(Documento documento) {
        this.repoFuenteBaseDatos.agregarDocumento(documento);
    }

    @Override
    public void actualizarDocumento(String titulo, Documento documento) {
        if(this.repoFuenteBaseDatos.actualizarDocumento(titulo, documento)){
            System.out.printf("Documento %s '%s' actualizado con éxito", this.repoFuenteBaseDatos.FUENTE_BASE_DATOS, titulo);
        };
        System.out.printf("Documento %s '%s' no encontrado en el archivo", this.repoFuenteBaseDatos.FUENTE_BASE_DATOS, titulo);
    }

    @Override
    public void eliminarDocumentoPorTitulo(String titulo) {
        this.obtenerDocumentoPorTitulo(titulo)
                .ifPresent(fbd -> this.repoFuenteBaseDatos.eliminarDocumentoPorTitulo(titulo));
    }
}
