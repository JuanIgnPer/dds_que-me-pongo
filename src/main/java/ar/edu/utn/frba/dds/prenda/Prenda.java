package ar.edu.utn.frba.dds.prenda;

public class Prenda {
  TipoDePrenda tipoDePrenda;
  Material material;
  Color colorPrimario;
  Color colorSecundario;
  Trama trama;
  Formalidad formalidad;

  public Prenda(TipoDePrenda tipoDePrenda, Material material, Trama trama,
                Color colorPrimario, Color colorSecundario, Formalidad formalidad) {
    this.tipoDePrenda = tipoDePrenda;
    this.material = material;
    this.trama = trama;
    this.colorPrimario = colorPrimario;
    this.colorSecundario = colorSecundario;
    this.formalidad = formalidad;
  }

  public Material getMaterial() {
    return material;
  }

  public Categoria getCategoria() {
    return tipoDePrenda.categoria;
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

  public Formalidad getFormalidad() {
    return formalidad;
  }

  public boolean esSuperior() {
    return tipoDePrenda.esSuperior();
  }

  public boolean esInferior() {
    return tipoDePrenda.esInferior();
  }

  public boolean esCalzado() {
    return tipoDePrenda.esCalzado();
  }

  public boolean esInformal() {
    return this.formalidad == Formalidad.INFORMAL;
  }
}
