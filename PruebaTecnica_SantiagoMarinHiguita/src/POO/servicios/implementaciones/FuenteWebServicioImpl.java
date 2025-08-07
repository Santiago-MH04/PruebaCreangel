package POO.servicios.implementaciones;

import POO.modelos.Documento;
import POO.repositorios.implementaciones.FuenteWeb;
import POO.servicios.abstracciones.DocumentoServicio;

import java.util.List;
import java.util.Optional;

public class FuenteWebServicioImpl implements DocumentoServicio {
    private FuenteWeb repoFuenteWeb;

    public FuenteWebServicioImpl(FuenteWeb repoFuenteWeb) {
        this.repoFuenteWeb = repoFuenteWeb;
    }

    @Override
    public List<Documento> obtenerDocumentos() {
        return this.repoFuenteWeb.obtenerDocumentos();
    }

    @Override
    public Optional<Documento> obtenerDocumentoPorTitulo(String titulo) {
        return this.repoFuenteWeb.obtenerDocumentoPorTitulo(titulo);
    }

    @Override
    public void agregarDocumento(Documento documento) {
        this.repoFuenteWeb.agregarDocumento(documento);
    }

    @Override
    public void actualizarDocumento(String titulo, Documento documento) {
        if(this.repoFuenteWeb.actualizarDocumento(titulo, documento)){
            System.out.printf("Documento %s '%s' actualizado con éxito", this.repoFuenteWeb.FUENTE_WEB, titulo);
        };
        System.out.printf("Documento %s '%s' no encontrado en el archivo", this.repoFuenteWeb.FUENTE_WEB, titulo);
    }

    @Override
    public void eliminarDocumentoPorTitulo(String titulo) {
        this.obtenerDocumentoPorTitulo(titulo)
            .ifPresent(fw -> this.repoFuenteWeb.eliminarDocumentoPorTitulo(titulo));
    }
}
