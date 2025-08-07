package POO.repositorios.implementaciones;

import POO.modelos.Documento;
import POO.repositorios.abstracciones.FuenteDatos;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

public abstract class FuenteDocumento implements FuenteDatos {
    @Override
    public List<Documento> obtenerDocumentos() {
        return List.of(
            new Documento("Documento1", "Historia de un día que ocurrió jamás", "FuenteArchivo"),
            new Documento("Documento2", "Registro de divorcios de parejas que nunca se casaron", "FuenteArchivo"),
            new Documento("Documento3", "Conteo de goles al arcoíris Mundial 1990&Nunca", "FuenteArchivo"),

            new Documento("Documento4", "Página web de un banco que no roba", "FuenteWeb"),
            new Documento("Documento5", "Recorrido web por la ciudad invisible", "FuenteWeb"),
            new Documento("Documento6", "Cirugía virtual para volver más feos a los feo", "FuenteWeb"),

            new Documento("Documento7", "Base de datos de gente que ha visto volar a los cerdos", "FuenteBaseDatos"),
            new Documento("Documento8", "Base de datos de benefactores de Rico McPato", "FuenteBaseDatos"),
            new Documento("Documento9", "Base de datos de personas que convierten el agua en vino", "FuenteBaseDatos")
        );
    }

    @Override
    public Optional<Documento> obtenerDocumentoPorTitulo(String titulo) {
        return this.obtenerDocumentos().stream()
            .filter(d -> d.getTitulo().equalsIgnoreCase(titulo))
            .findAny();
    }

    @Override
    public void agregarDocumento(Documento documento) {
        this.obtenerDocumentos().add(documento);
    }

    @Override
    public boolean actualizarDocumento(String titulo, Documento documento) {
        AtomicBoolean actualizado = new AtomicBoolean(false);

        IntStream.range(0, this.obtenerDocumentos().size())
            .filter(i -> this.obtenerDocumentos().get(i).getTitulo().equalsIgnoreCase(titulo))
            .findFirst()
            .ifPresent(i -> {
                this.obtenerDocumentos().set(i, documento);
                actualizado.set(true);
            });

        return actualizado.get();
    }

    @Override
    public void eliminarDocumentoPorTitulo(String titulo) {
        Optional<Documento> archivoAEliminar = this.obtenerDocumentoPorTitulo(titulo);
        archivoAEliminar.ifPresent(a -> {
            this.obtenerDocumentos().remove(a);
            System.out.printf("Documento %s eliminado con éxito", a.getTitulo());
        });
        System.out.printf("El documento %s no se encuentra indexado", titulo);
    }
}
