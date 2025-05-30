package ar.edu.utn.frba.dds.bonus.qmp2;

import static ar.edu.utn.frba.dds.prenda.Material.ALGODON;
import static ar.edu.utn.frba.dds.prenda.Material.CUERO;
import static ar.edu.utn.frba.dds.prenda.Material.PIQUE;
import static ar.edu.utn.frba.dds.prenda.TipoDePrenda.CAMISA_MANGA_CORTA;
import static ar.edu.utn.frba.dds.prenda.TipoDePrenda.PANTALON;
import static ar.edu.utn.frba.dds.prenda.TipoDePrenda.ZAPATOS;

import ar.edu.utn.frba.dds.prenda.Borrador;
import ar.edu.utn.frba.dds.prenda.Color;
import ar.edu.utn.frba.dds.prenda.Prenda;

public class SastreJohnston extends Sastre {

  public Prenda fabricarParteSuperior() {
    borrador = new Borrador(CAMISA_MANGA_CORTA);
    borrador.especificarColorPrincipal(new Color(255, 255, 255));
    borrador.especificarMaterial(PIQUE);
    return borrador.crearPrenda();
  }

  public Prenda fabricarParteInferior() {
    borrador = new Borrador(PANTALON);
    borrador.especificarColorPrincipal(new Color(0, 0, 0));
    borrador.especificarMaterial(ALGODON);
    return borrador.crearPrenda();
  }

  public Prenda fabricarCalzado() {
    borrador = new Borrador(ZAPATOS);
    borrador.especificarColorPrincipal(new Color(0, 0, 0));
    borrador.especificarMaterial(CUERO);
    return borrador.crearPrenda();
  }
}
