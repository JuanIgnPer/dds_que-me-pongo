package ar.edu.utn.frba.dds.sugerencias;

import static ar.edu.utn.frba.dds.prenda.Categoria.CALZADO;
import static ar.edu.utn.frba.dds.prenda.Categoria.PARTE_INFERIOR;
import static ar.edu.utn.frba.dds.prenda.Categoria.PARTE_SUPERIOR;

import ar.edu.utn.frba.dds.excepciones.PrendaInexistenteException;
import ar.edu.utn.frba.dds.prenda.Prenda;
import java.util.ArrayList;
import java.util.List;

public class Guardarropa {
  private final List<Prenda> prendas;

  public Guardarropa(List<Prenda> prendas) {
    this.prendas = new ArrayList<>(prendas);
  }

  public Atuendo generarAtuendo() {
    return new Atuendo(generarParteSuperior(), generarParteInferior(), generarCalzado());
  }

  public void agregarPrenda(Prenda prenda) {
    this.prendas.add(prenda);
  }


  public Prenda generarParteSuperior() {
    return this.prendas.stream()
        .filter(p -> p.getCategoria().equals(PARTE_SUPERIOR))
        .findFirst()
        .orElseThrow(() -> new PrendaInexistenteException("Prendas de categoria 'Parte Superior'"));
  }

  public Prenda generarParteInferior() {
    return this.prendas.stream()
        .filter(p -> p.getCategoria().equals(PARTE_INFERIOR))
        .findAny()
        .orElseThrow(() -> new PrendaInexistenteException("Prendas de categoria 'Parte Inferior'"));
  }

  public Prenda generarCalzado() {
    return this.prendas.stream()
        .filter(p -> p.getCategoria().equals(CALZADO))
        .findAny()
        .orElseThrow(() -> new PrendaInexistenteException("Prendas de categoria 'Calzado'"));
  }
}
