package POO.modelos;

import java.util.Objects;

public class Documento {
    private String titulo;
    private String contenido;
    private String fuenteOrigen;

    public Documento() {
    }
    public Documento(String titulo, String contenido, String fuenteOrigen) {
        this();
        this.contenido = contenido;
        this.titulo = titulo;
        this.fuenteOrigen = fuenteOrigen;
    }

    public String getTitulo() {
        return this.titulo;
    }
        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

    public String getContenido() {
        return this.contenido;
    }
        public void setContenido(String contenido) {
            this.contenido = contenido;
        }

    public String getFuenteOrigen() {
        return this.fuenteOrigen;
    }
        public void setFuenteOrigen(String fuenteOrigen) {
            this.fuenteOrigen = fuenteOrigen;
        }

    @Override
    public String toString() {
        return String.format("%s: tiene su origen en %s.\nResumen: %s", this.titulo, this.fuenteOrigen, this.contenido);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Documento documento = (Documento) o;
        return Objects.equals(this.titulo, documento.titulo) && Objects.equals(this.fuenteOrigen, documento.fuenteOrigen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, fuenteOrigen);
    }
}
