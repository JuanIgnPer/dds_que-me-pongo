package ar.edu.utn.frba.dds;

import static ar.edu.utn.frba.dds.prenda.Material.ALGODON;
import static ar.edu.utn.frba.dds.prenda.Material.CUERO;
import static ar.edu.utn.frba.dds.prenda.Material.PIQUE;
import static ar.edu.utn.frba.dds.prenda.TipoDePrenda.CAMISA_MANGA_CORTA;
import static ar.edu.utn.frba.dds.prenda.TipoDePrenda.PANTALON;
import static ar.edu.utn.frba.dds.prenda.TipoDePrenda.ZAPATOS;
import static ar.edu.utn.frba.dds.prenda.Trama.A_CUADROS;
import static ar.edu.utn.frba.dds.prenda.Trama.LISA;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import ar.edu.utn.frba.dds.bonus.qmp2.SastreJohnston;
import ar.edu.utn.frba.dds.bonus.qmp2.SastreSanJuan;
import ar.edu.utn.frba.dds.bonus.qmp2.Uniforme;
import ar.edu.utn.frba.dds.excepciones.PrendaInvalidaException;
import ar.edu.utn.frba.dds.prenda.Borrador;
import ar.edu.utn.frba.dds.prenda.Color;
import ar.edu.utn.frba.dds.prenda.Material;
import ar.edu.utn.frba.dds.prenda.Prenda;
import ar.edu.utn.frba.dds.prenda.TipoDePrenda;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class QMP2Test {

  public static Color ROJO;
  public static Color AZUL;
  public static Color AMARILLO;
  Borrador borrador;

  @BeforeAll
  public static void setUp() {
    ROJO = new Color(255, 0, 0);
    AZUL = new Color(0, 0, 255);
    AMARILLO = new Color(255, 255, 0);
  }

  @Test
  public void especificarLaTramaQueTieneUnaPrenda() {
    // Como usuarie de QuéMePongo, quiero especificar qué trama
    // tiene la tela de una prenda (lisa, rayada, con lunares, a cuadros o un estampado).

    borrador = new Borrador(CAMISA_MANGA_CORTA)
        .especificarMaterial(ALGODON)
        .especificarTrama(A_CUADROS)
        .especificarColorPrincipal(ROJO);

    Prenda prenda = borrador.crearPrenda();

    assertEquals(A_CUADROS, prenda.getTrama());
  }

  @Test
  public void crearUnaPrendaEspecificandoPrimeroQueTipoEs() {
    // Como usuarie de QuéMePongo, quiero crear una prenda especificando primero de qué tipo es.

    // Validar que no se puede crear una prenda sin especificar el tipo.
    assertThrows(
        PrendaInvalidaException.class,
        () -> new Borrador(null));
  }

  @Test
  public void crearUnaPrendaEspecificandoMaterialesEnSegundoLugar() {
    // Como usuarie de QuéMePongo, quiero crear una prenda especificando
    // en segundo lugar los aspectos relacionados a su material (colores, material, trama, etc)
    // para evitar elegir materiales inconsistentes con el tipo de prenda.

    borrador = new Borrador(PANTALON)
        .especificarMaterial(ALGODON)
        .especificarColorPrincipal(ROJO)
        .especificarColorSecundario(AZUL)
        .especificarTrama(A_CUADROS);

    Prenda prenda = borrador.crearPrenda();

    assertEquals(PANTALON, prenda.getTipoDePrenda());
    assertEquals(ALGODON, prenda.getMaterial());
    assertEquals(ROJO, prenda.getColorPrincipal());
    assertEquals(AZUL, prenda.getColorSecundario());
    assertEquals(A_CUADROS, prenda.getTrama());
  }

  @Test
  public void crearUnaPrendaConTramaLisaPorDefecto() {
    // Como usuarie de QuéMePongo, quiero guardar un borrador
    // de la última prenda que empecé a cargar para continuar después.

    borrador = new Borrador(CAMISA_MANGA_CORTA)
        .especificarMaterial(ALGODON)
        .especificarColorPrincipal(ROJO);
  }

  @Test
  public void crearUnaPrendaSinEspecificarTrama() {
    // Como usuarie de QuéMePongo, quiero poder no indicar
    // ninguna trama para una tela, y que por defecto ésta sea lisa.

    borrador = new Borrador(CAMISA_MANGA_CORTA)
        .especificarMaterial(ALGODON)
        .especificarColorPrincipal(ROJO);

    Prenda prenda = borrador.crearPrenda();

    assertEquals(LISA, prenda.getTrama()); // Por defecto, la trama es lisa
  }

  @Test
  public void guardarUnaPrendaSiEsValida() {
    // Como usuarie de QuéMePongo, quiero poder guardar una prenda
    // solamente si esta es válida.

    borrador = new Borrador(CAMISA_MANGA_CORTA);

    assertThrows(
        PrendaInvalidaException.class,
        () -> borrador.crearPrenda(),
        "No se puede crear una prenda sin especificar el material, trama y colores"
    );
  }

  // Bonus
  @Test
  public void crearUniformeConSastreSanJuan() {
    SastreSanJuan sastreSanJuan = new SastreSanJuan();
    Uniforme unUniforme = sastreSanJuan.fabricarUniforme();

    // Validar prenda superior (chomba de pique verde)
    assertEquals(TipoDePrenda.CHOMBA, unUniforme.getPrendaSuperior().getTipoDePrenda());
    assertEquals(Material.PIQUE, unUniforme.getPrendaSuperior().getMaterial());

    // Validar prenda inferior (pantalon de acetato gris)
    assertEquals(TipoDePrenda.PANTALON, unUniforme.getPrendaInferior().getTipoDePrenda());
    assertEquals(Material.ACETATO, unUniforme.getPrendaInferior().getMaterial());

    // Validar calzado (zapatillas de algodon blancas)
    assertEquals(TipoDePrenda.ZAPATILLAS, unUniforme.getCalzado().getTipoDePrenda());
    assertEquals(Material.ALGODON, unUniforme.getCalzado().getMaterial());
  }

  @Test
  public void validarUniformeSastreJohnston() {
    SastreJohnston sastre = new SastreJohnston();
    Uniforme unUniforme = sastre.fabricarUniforme();

    // Validar prenda superior (camisa manga corta blanca)
    assertEquals(CAMISA_MANGA_CORTA, unUniforme.getPrendaSuperior().getTipoDePrenda());
    assertEquals(PIQUE, unUniforme.getPrendaSuperior().getMaterial());

    // Validar prenda inferior (pantalon de vestir negro)
    assertEquals(PANTALON, unUniforme.getPrendaInferior().getTipoDePrenda());
    assertEquals(ALGODON, unUniforme.getPrendaInferior().getMaterial());

    // Validar calzado (zapatos negros)
    assertEquals(ZAPATOS, unUniforme.getCalzado().getTipoDePrenda());
    assertEquals(CUERO, unUniforme.getCalzado().getMaterial());
  }
}
