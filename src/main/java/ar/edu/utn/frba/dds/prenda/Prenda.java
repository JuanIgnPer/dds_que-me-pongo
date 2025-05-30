package ar.edu.utn.frba.dds.prenda;

public class Prenda {
  TipoDePrenda tipoDePrenda;
  Material material;
  Color colorPrimario;
  Color colorSecundario;
  Trama trama;

  public Prenda(TipoDePrenda tipoDePrenda, Material material, Trama trama,
                Color colorPrimario, Color colorSecundario) {
    this.tipoDePrenda = tipoDePrenda;
    this.material = material;
    this.trama = trama;
    this.colorPrimario = colorPrimario;
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

  public Color getColorPrincipal() {
    return colorPrimario;
  }

  public Color getColorSecundario() {
    return colorSecundario;
  }

  public Trama getTrama() {
    return trama;
  }
}
