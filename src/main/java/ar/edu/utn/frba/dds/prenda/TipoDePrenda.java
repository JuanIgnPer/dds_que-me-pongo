package ar.edu.utn.frba.dds.prenda;


public enum TipoDePrenda {
  REMERA(Categoria.PARTE_SUPERIOR),
  CHOMBA(Categoria.PARTE_SUPERIOR),
  CAMISA_MANGA_CORTA(Categoria.PARTE_SUPERIOR),
  CAMISA_MANGA_LARGA(Categoria.PARTE_SUPERIOR),
  PANTALON(Categoria.PARTE_INFERIOR),
  ZAPATOS(Categoria.CALZADO),
  ZAPATILLAS(Categoria.CALZADO);

  public final Categoria categoria;

  TipoDePrenda(Categoria categoria) {
    this.categoria = categoria;
  }

  public boolean esSuperior() {
    return this.categoria == Categoria.PARTE_SUPERIOR;
  }

  public boolean esInferior() {
    return this.categoria == Categoria.PARTE_INFERIOR;
  }

  public boolean esCalzado() {
    return this.categoria == Categoria.CALZADO;
  }
}