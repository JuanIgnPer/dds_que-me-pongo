package ar.edu.utn.frba.dds.prenda;

import ar.edu.utn.frba.dds.excepciones.PrendaInvalidaException;

public class Prenda {
  TipoDePrenda tipoDePrenda;
  Material material;
  Color colorPrimario;
  Color colorSecundario;

  public Prenda(TipoDePrenda tipoDePrenda, Material material, Color colorPrimario) {
    if (tipoDePrenda == null) {
      throw new PrendaInvalidaException("Tipo de prenda no valido");
    }
    if (material == null) {
      throw new PrendaInvalidaException("Material no valido");
    }
    if (colorPrimario == null) {
      throw new PrendaInvalidaException("Color no valido");
    }
    this.tipoDePrenda = tipoDePrenda;
    this.material = material;
    this.colorPrimario = colorPrimario;
    this.colorSecundario = null;
  }

  public Prenda(TipoDePrenda tipoDePrenda, Material material,
                Color colorPrimario, Color colorSecundario) {
    this(tipoDePrenda, material, colorPrimario);
    if (colorSecundario == null) {
      throw new PrendaInvalidaException("Color secundario no valido");
    }
    this.colorSecundario = colorSecundario;
  }

  public Material getMaterial() {
    return material;
  }

  public Categoria getCategoria() {
    return tipoDePrenda.categoria();
  }

  public TipoDePrenda getTipoDePrenda() {
    return tipoDePrenda;
  }

  public Color getColorPrimario() {
    return colorPrimario;
  }

  public Color getColorSecundario() {
    return colorSecundario;
  }
}
