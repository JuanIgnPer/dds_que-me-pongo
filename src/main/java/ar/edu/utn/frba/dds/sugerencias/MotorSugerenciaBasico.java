package ar.edu.utn.frba.dds.sugerencias;

import ar.edu.utn.frba.dds.prenda.Prenda;
import ar.edu.utn.frba.dds.usuarios.Usuario;
import java.util.List;

public class MotorSugerenciaBasico extends MotorSugerencia {
  @Override
  public List<Prenda> validarPrendasDe(Usuario usuario) {
    return usuario.getPrendas();
  }
}
