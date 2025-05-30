package ar.edu.utn.frba.dds.prenda;


public enum TipoDePrenda {

  REMERA {
    @Override
    public Categoria categoria() {
      return Categoria.PARTE_SUPERIOR;
    }
  },
  CHOMBA {
    @Override
    public Categoria categoria() {
      return Categoria.PARTE_SUPERIOR;
    }
  },
  CAMISA_MANGA_CORTA {
    @Override
    public Categoria categoria() {
      return Categoria.PARTE_SUPERIOR;
    }
  },
  CAMISA_MANGA_LARGA {
    @Override
    public Categoria categoria() {
      return Categoria.PARTE_SUPERIOR;
    }
  },
  PANTALON {
    @Override
    public Categoria categoria() {
      return Categoria.PARTE_INFERIOR;
    }
  },
  ZAPATOS {
    @Override
    public Categoria categoria() {
      return Categoria.CALZADO;
    }
  },
  ZAPATILLAS {
    @Override
    public Categoria categoria() {
      return Categoria.CALZADO;
    }
  };

  public abstract Categoria categoria();
}