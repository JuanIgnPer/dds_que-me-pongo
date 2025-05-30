package ar.edu.utn.frba.dds.bonus.qmp2;

import static ar.edu.utn.frba.dds.prenda.Material.ACETATO;
import static ar.edu.utn.frba.dds.prenda.Material.ALGODON;
import static ar.edu.utn.frba.dds.prenda.Material.PIQUE;
import static ar.edu.utn.frba.dds.prenda.TipoDePrenda.CHOMBA;
import static ar.edu.utn.frba.dds.prenda.TipoDePrenda.PANTALON;
import static ar.edu.utn.frba.dds.prenda.TipoDePrenda.ZAPATILLAS;

import ar.edu.utn.frba.dds.prenda.Borrador;
import ar.edu.utn.frba.dds.prenda.Color;
import ar.edu.utn.frba.dds.prenda.Prenda;

public class SastreSanJuan extends Sastre {

  public Prenda fabricarParteSuperior() {
    borrador = new Borrador(CHOMBA);
    borrador.especificarColorPrincipal(new Color(0, 255, 0));
    borrador.especificarMaterial(PIQUE);
    return borrador.crearPrenda();
  }

  public Prenda fabricarParteInferior() {
    borrador = new Borrador(PANTALON);
    borrador.especificarColorPrincipal(new Color(128, 128, 128));
    borrador.especificarMaterial(ACETATO);
    return borrador.crearPrenda();
  }

  public Prenda fabricarCalzado() {
    borrador = new Borrador(ZAPATILLAS);
    borrador.especificarColorPrincipal(new Color(255, 255, 255));
    borrador.especificarMaterial(ALGODON);
    return borrador.crearPrenda();
  }
}
