package ar.edu.utn.frba.dds.prenda;

import static java.util.Objects.requireNonNull;

public class Prenda {
  TipoDePrenda tipoDePrenda;
  Material material;
  Color color;

  public Prenda(TipoDePrenda tipoDePrenda, Material material, Color color) {
    this.tipoDePrenda = requireNonNull(tipoDePrenda, "tipo de prenda es obligatorio");
    this.material = requireNonNull(material, "material es obligatorio");
    this.color = requireNonNull(color, "color es obligatorio");
  }

  public Categoria categoria() {
    return tipoDePrenda.categoria();
  }
}
