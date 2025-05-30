package ar.edu.utn.frba.dds.excepciones;

public class PrendaInvalidaException extends RuntimeException {
  public PrendaInvalidaException(String message) {
    super("Prenda invalida porque: " + message);
  }
}
