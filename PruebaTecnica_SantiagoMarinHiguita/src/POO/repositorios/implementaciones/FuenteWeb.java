package POO.repositorios.implementaciones;

import POO.modelos.Documento;

import java.util.List;
import java.util.Optional;

public class FuenteWeb extends FuenteDocumento{
    public final String FUENTE_WEB = "FuenteWeb";



    @Override
    public List<Documento> obtenerDocumentos() {
        return super.obtenerDocumentos().stream()
            .filter(d -> d.getFuenteOrigen().equals(FUENTE_WEB))
            .toList();
    }

    @Override
    public Optional<Documento> obtenerDocumentoPorTitulo(String titulo) {
        return this.obtenerDocumentos().stream()
            .filter(fw -> fw.getTitulo().equalsIgnoreCase(titulo))
            .findFirst();
    }

    @Override
    public void agregarDocumento(Documento documento) {
        if(documento.getFuenteOrigen().equals(FUENTE_WEB)){
            super.agregarDocumento(documento);
            System.out.printf("Documento '%s' guardado con éxito", FUENTE_WEB);
            return;
        }
        System.out.printf("FuenteWeb sólo puede guardar archivos con fuente origen '%s'", FUENTE_WEB);
    }

    @Override
    public boolean actualizarDocumento(String titulo, Documento documento) {
        if(documento.getFuenteOrigen().equals(FUENTE_WEB)){
            return super.actualizarDocumento(titulo, documento);
        }
        return false;
    }

    @Override
    public void eliminarDocumentoPorTitulo(String titulo) {
        super.eliminarDocumentoPorTitulo(titulo);
    }
}
