package cl.alexalvarez.pruebaTecnicaSupermercado.exception;

public class NotFoundException extends RuntimeException {
  public NotFoundException(String msg) {
    super(msg);
  }
}
