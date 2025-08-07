package POO.repositorios.implementaciones;

import POO.modelos.Documento;

import java.util.List;
import java.util.Optional;

public class FuenteArchivo extends FuenteDocumento{
    public final String FUENTE_ARCHIVO = "FuenteArchivo";

    @Override
    public List<Documento> obtenerDocumentos() {
        return super.obtenerDocumentos().stream()
            .filter(d -> d.getFuenteOrigen().equals(FUENTE_ARCHIVO))
            .toList();
    }

    @Override
    public Optional<Documento> obtenerDocumentoPorTitulo(String titulo) {
        return this.obtenerDocumentos().stream()
            .filter(fa -> fa.getTitulo().equalsIgnoreCase(titulo))
            .findFirst();
    }

    @Override
    public void agregarDocumento(Documento documento) {
        if(documento.getFuenteOrigen().equals(FUENTE_ARCHIVO)){
            super.agregarDocumento(documento);
            System.out.printf("Documento '%s' guardado con éxito", FUENTE_ARCHIVO);
            return;
        }
        System.out.printf("FuenteArchivo sólo puede guardar archivos con fuente origen '%s'", FUENTE_ARCHIVO);
    }

    @Override
    public boolean actualizarDocumento(String titulo, Documento documento) {
        if(documento.getFuenteOrigen().equals(FUENTE_ARCHIVO)){
            return super.actualizarDocumento(titulo, documento);
        }
        return false;
    }

    @Override
    public void eliminarDocumentoPorTitulo(String titulo) {
        super.eliminarDocumentoPorTitulo(titulo);
    }
}
