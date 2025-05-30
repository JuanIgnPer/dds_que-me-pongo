package ar.edu.utn.frba.dds.excepciones;

public class PrendaInexistenteException extends RuntimeException {
  public PrendaInexistenteException(String message) {
    super("No se encontró una prenda que satisfaga el criterio de busqueda: " + message);
  }
}
