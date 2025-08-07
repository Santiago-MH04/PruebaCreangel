package POO.repositorios.implementaciones;

import POO.modelos.Documento;

import java.util.List;
import java.util.Optional;

public class FuenteBaseDatos extends FuenteDocumento{
    public final String FUENTE_BASE_DATOS = "FuenteBaseDatos";


    @Override
    public List<Documento> obtenerDocumentos() {
        return super.obtenerDocumentos().stream()
            .filter(d -> d.getFuenteOrigen().equals(FUENTE_BASE_DATOS))
            .toList();
    }

    @Override
    public Optional<Documento> obtenerDocumentoPorTitulo(String titulo) {
        return this.obtenerDocumentos().stream()
            .filter(fbd -> fbd.getTitulo().equalsIgnoreCase(titulo))
            .findFirst();
    }

    @Override
    public void agregarDocumento(Documento documento) {
        if(documento.getFuenteOrigen().equals(FUENTE_BASE_DATOS)){
            super.agregarDocumento(documento);
            System.out.printf("Documento '%s' guardado con éxito", FUENTE_BASE_DATOS);
            return;
        }
        System.out.printf("FuenteBaseDatos sólo puede guardar archivos con fuente origen '%s'", FUENTE_BASE_DATOS);
    }

    @Override
    public boolean actualizarDocumento(String titulo, Documento documento) {
        if(documento.getFuenteOrigen().equals(FUENTE_BASE_DATOS)){
            return super.actualizarDocumento(titulo, documento);
        }
        return false;
    }

    @Override
    public void eliminarDocumentoPorTitulo(String titulo) {
        super.eliminarDocumentoPorTitulo(titulo);
    }

}
