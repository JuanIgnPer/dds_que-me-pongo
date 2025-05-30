package ar.edu.utn.frba.dds.prenda;

import ar.edu.utn.frba.dds.excepciones.PrendaInvalidaException;
import java.util.Objects;

public class Borrador {

  private TipoDePrenda tipoDePrenda;
  private Material material;
  private Trama trama = Trama.LISA; // Por defecto, la trama es lisa, aun cuando no se especifique
  private Color colorPrincipal;
  private Color colorSecundario;

  public Borrador(TipoDePrenda tipoDePrenda) {
    // Valido el tipo de prenda al crear el borrador
    especificarTipoDePrenda(tipoDePrenda);
  }

  public Borrador especificarTipoDePrenda(TipoDePrenda tipoDePrenda) {
    if (tipoDePrenda == null) {
      throw new PrendaInvalidaException("Tipo de prenda no valido");
    }
    this.tipoDePrenda = tipoDePrenda;
    return this;
  }

  public Borrador especificarMaterial(Material material) {
    if (material == null) {
      throw new PrendaInvalidaException("Material no valido");
    }
    // No especifica como validar la consistencia del material con el tipo de prenda
    this.material = material;
    return this;
  }

  public Borrador especificarTrama(Trama trama) {
    this.trama = Objects.requireNonNullElse(trama, Trama.LISA);
    return this;
  }

  public Borrador especificarColorPrincipal(Color color) {
    if (color == null) {
      throw new PrendaInvalidaException("Color no valido");
    }
    this.colorPrincipal = color;
    return this;
  }

  public Borrador especificarColorSecundario(Color color) {
    this.colorSecundario = color;
    return this;
  }

  public void validarPrenda() {
    // tipoDePrenda --> Se valida en el constructor
    if (material == null) {
      throw new PrendaInvalidaException("Material no valido");
    }
    if (trama == null) {
      throw new PrendaInvalidaException("Trama no valido");
    }
    if (colorPrincipal == null) {
      throw new PrendaInvalidaException("Color no valido");
    }
  }

  public Prenda crearPrenda() {
    validarPrenda();
    return new Prenda(this.tipoDePrenda, this.material, this.trama,
        this.colorPrincipal, this.colorSecundario);
  }
}
