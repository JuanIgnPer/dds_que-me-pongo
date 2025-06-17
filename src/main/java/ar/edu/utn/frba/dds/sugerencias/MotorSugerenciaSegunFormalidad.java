package ar.edu.utn.frba.dds.sugerencias;

import ar.edu.utn.frba.dds.prenda.Prenda;
import ar.edu.utn.frba.dds.usuarios.Usuario;
import java.util.List;


public class MotorSugerenciaSegunFormalidad extends MotorSugerencia {
  @Override
  public List<Prenda> validarPrendasDe(Usuario usuario) {
    List<Prenda> prendas = usuario.getPrendas();
    return usuario.esEdadAvanzada()
        ? prendas.stream().filter(Prenda::esFormal).toList()
        : prendas;
  }
}
