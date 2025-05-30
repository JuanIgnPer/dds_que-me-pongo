package ar.edu.utn.frba.dds.bonus.qmp2;

import ar.edu.utn.frba.dds.prenda.Borrador;
import ar.edu.utn.frba.dds.prenda.Prenda;

public abstract class Sastre {

  protected Borrador borrador;

  public Uniforme fabricarUniforme() {
    return new Uniforme(
        this.fabricarParteSuperior(),
        this.fabricarParteInferior(),
        this.fabricarCalzado());
  }

  protected abstract Prenda fabricarParteSuperior();

  protected abstract Prenda fabricarParteInferior();

  protected abstract Prenda fabricarCalzado();
}
