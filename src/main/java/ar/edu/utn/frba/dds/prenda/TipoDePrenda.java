package ar.edu.utn.frba.dds.prenda;


public class TipoDePrenda {

  public static final TipoDePrenda ZAPATO = new TipoDePrenda(Categoria.CALZADO);
  public static final TipoDePrenda REMERA = new TipoDePrenda(Categoria.PARTE_SUPERIOR);
  public static final TipoDePrenda PANTALON = new TipoDePrenda(Categoria.PARTE_INFERIOR);
  Categoria categoria;

  public TipoDePrenda(Categoria categoria) {
    this.categoria = categoria;
  }

  public Categoria categoria() {
    return this.categoria;
  }
}