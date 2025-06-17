package ar.edu.utn.frba.dds.usuarios;

import ar.edu.utn.frba.dds.prenda.Prenda;
import ar.edu.utn.frba.dds.sugerencias.Atuendo;
import ar.edu.utn.frba.dds.sugerencias.MotorSugerencia;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
  private List<Prenda> prendas;
  private int edad;
  private MotorSugerencia motorSugerencia;

  public Usuario(int edad, List<Prenda> prendas, MotorSugerencia motorSugerencia) {
    this.prendas = List.copyOf(prendas);
    this.edad = edad;
    this.motorSugerencia = motorSugerencia;
  }

  public List<Atuendo> generarSugerencias() {
    return motorSugerencia.generarCombinacionesDeAtuendos(this);
  }

  public Atuendo generarSugerencia() {
    return motorSugerencia.sugerirAtuendo(this);
  }

  public int getEdad() {
    return edad;
  }

  public List<Prenda> getPrendas() {
    return List.copyOf(prendas);
  }

  public boolean esEdadAvanzada() {
    return this.edad > 55;
  }

  public MotorSugerencia getMotorSugerencia() {
    return motorSugerencia;
  }

  public void setMotorSugerencia(MotorSugerencia motorSugerencia) {
    this.motorSugerencia = motorSugerencia;
  }
}
