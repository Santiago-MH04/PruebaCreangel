package POO;

import POO.modelos.Documento;
import POO.repositorios.implementaciones.FuenteArchivo;
import POO.repositorios.implementaciones.FuenteBaseDatos;
import POO.repositorios.implementaciones.FuenteWeb;
import POO.servicios.abstracciones.DocumentoServicio;
import POO.servicios.implementaciones.FuenteArchivoServicioImpl;
import POO.servicios.implementaciones.FuenteBaseDatosServicioImpl;
import POO.servicios.implementaciones.FuenteWebServicioImpl;

import java.util.List;
import java.util.Optional;

public class CrawlingIndex {
    public static void main(String[] args) {
        //Iniciar las instancias fuente de cada tipo de archivos
        FuenteArchivo fuenteArchivo = new FuenteArchivo();
        FuenteBaseDatos fuenteBaseDatos = new FuenteBaseDatos();
        FuenteWeb fuenteWeb = new FuenteWeb();

        //Iniciar los servicios
        DocumentoServicio fuenteArchivoServicio = new FuenteArchivoServicioImpl(fuenteArchivo);
        DocumentoServicio fuenteBaseDatosServicio = new FuenteBaseDatosServicioImpl(fuenteBaseDatos);
        DocumentoServicio fuenteWebServicio = new FuenteWebServicioImpl(fuenteWeb);


        //Listar los distintos documentos
        List<Documento> documentosFuenteArchivo = fuenteArchivoServicio.obtenerDocumentos();
        List<Documento> documentosFuenteBaseDatos = fuenteBaseDatosServicio.obtenerDocumentos();
        List<Documento> documentosFuenteWeb = fuenteWebServicio.obtenerDocumentos();

        System.out.println("Imprimiendo los distintos documentos");
        System.out.println("Fuente archivo");
        documentosFuenteArchivo.forEach(System.out::println);
        System.out.println("\nFuente base de datos");
        documentosFuenteBaseDatos.forEach(System.out::println);
        System.out.println("\nFuente web");
        documentosFuenteWeb.forEach(System.out::println);

        System.out.println("\nBuscando un elemento de cada servicio");
        Documento documentoFuenteArchivo = fuenteArchivoServicio.obtenerDocumentoPorTitulo("documento2").get();
        Documento documentoFuenteWeb = fuenteWebServicio.obtenerDocumentoPorTitulo("documento4").get();
        Documento documentoFuenteBaseDatos = fuenteBaseDatosServicio.obtenerDocumentoPorTitulo("documento9").get();

        System.out.println(documentoFuenteArchivo);
        System.out.println(documentoFuenteBaseDatos);
        System.out.println(documentoFuenteWeb);

        System.out.println("\nAgregando un elemento a cada servicio");
        Documento nuevoFuenteArchivo = new Documento("Nuevo doc", "Nuevo documento de prueba", "FuenteArchivo");
        Documento nuevoFuenteBaseDatos = new Documento("Nueva B.D.", "Otra base de datos sin información relevante", "FuenteBaseDatos");
        Documento nuevoFuenteWeb = new Documento("Otra landing page", "Una landing page de otro emprendimiento", "FuenteWeb");

        fuenteArchivoServicio.agregarDocumento(nuevoFuenteArchivo);
        fuenteBaseDatosServicio.agregarDocumento(nuevoFuenteBaseDatos);
        fuenteWebServicio.agregarDocumento(nuevoFuenteWeb);

        System.out.println("Imprimiendo los distintos documentos");
        System.out.println("Fuente archivo");
        fuenteArchivoServicio.obtenerDocumentos().forEach(System.out::println);
        System.out.println("\nFuente base de datos");
        fuenteBaseDatosServicio.obtenerDocumentos().forEach(System.out::println);
        System.out.println("\nFuente web");
        fuenteWebServicio.obtenerDocumentos().forEach(System.out::println);

        System.out.println("\nModificando un elemento en cada servicio");
        nuevoFuenteArchivo.setContenido("Modificando ando este registro");
        nuevoFuenteBaseDatos.setTitulo("Nueva vieja B.D.");
        nuevoFuenteWeb.setContenido("Una nueva versión de la misma landing page");

        fuenteArchivoServicio.actualizarDocumento("Nuevo doc", nuevoFuenteArchivo);
        fuenteBaseDatosServicio.actualizarDocumento("Nueva B.D.", nuevoFuenteBaseDatos);
        fuenteWebServicio.actualizarDocumento("Otra landing page", nuevoFuenteWeb);

        System.out.println("Imprimiendo los distintos documentos");
        System.out.println("Fuente archivo");
        fuenteArchivoServicio.obtenerDocumentos().forEach(System.out::println);
        System.out.println("\nFuente base de datos");
        fuenteBaseDatosServicio.obtenerDocumentos().forEach(System.out::println);
        System.out.println("\nFuente web");
        fuenteWebServicio.obtenerDocumentos().forEach(System.out::println);

        System.out.println("\nEliminando un elemento de cada servicio");
        fuenteArchivoServicio.eliminarDocumentoPorTitulo(nuevoFuenteArchivo.getTitulo());
        fuenteBaseDatosServicio.eliminarDocumentoPorTitulo(nuevoFuenteBaseDatos.getTitulo());
        fuenteWebServicio.eliminarDocumentoPorTitulo(nuevoFuenteWeb.getTitulo());

        System.out.println("Imprimiendo los distintos documentos");
        System.out.println("Fuente archivo");
        fuenteArchivoServicio.obtenerDocumentos().forEach(System.out::println);
        System.out.println("\nFuente base de datos");
        fuenteBaseDatosServicio.obtenerDocumentos().forEach(System.out::println);
        System.out.println("\nFuente web");
        fuenteWebServicio.obtenerDocumentos().forEach(System.out::println);

    }
}