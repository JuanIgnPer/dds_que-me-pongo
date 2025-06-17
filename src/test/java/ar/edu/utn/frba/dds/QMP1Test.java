package ar.edu.utn.frba.dds;

import static ar.edu.utn.frba.dds.prenda.Categoria.CALZADO;
import static ar.edu.utn.frba.dds.prenda.Material.ALGODON;
import static ar.edu.utn.frba.dds.prenda.Material.CUERO;
import static ar.edu.utn.frba.dds.prenda.TipoDePrenda.CAMISA_MANGA_CORTA;
import static ar.edu.utn.frba.dds.prenda.TipoDePrenda.PANTALON;
import static ar.edu.utn.frba.dds.prenda.TipoDePrenda.REMERA;
import static ar.edu.utn.frba.dds.prenda.TipoDePrenda.ZAPATOS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import ar.edu.utn.frba.dds.excepciones.PrendaInvalidaException;
import ar.edu.utn.frba.dds.prenda.Borrador;
import ar.edu.utn.frba.dds.prenda.Color;
import ar.edu.utn.frba.dds.prenda.Prenda;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class QMP1Test {

  public static Color ROJO;
  public static Color AZUL;
  public static Color AMARILLO;

  @BeforeAll
  public static void setUp() {
    ROJO = new Color(255, 0, 0);
    AZUL = new Color(0, 0, 255);
    AMARILLO = new Color(255, 255, 0);
  }


  @Test
  public void crearUnaPrendaYEspecificarElTipoDePrenda() {
    // Como usuarie de QuéMePongo, quiero especificar qué tipo de prenda estoy cargando
    // (zapatos, camisa de mangas cortas, pantalón, etc).

    Prenda prenda = new Prenda(CAMISA_MANGA_CORTA, ALGODON, null, ROJO, null, null);
    assertEquals(CAMISA_MANGA_CORTA, prenda.getTipoDePrenda());
  }

  @Test
  public void crearUnaPrendaYEspecificarLaCategoria() {
    // Como usuarie de QuéMePongo, quiero identificar a qué categoría pertenece una prenda
    // (parte superior, calzado, parte inferior, accesorios).

    Prenda prenda = new Prenda(ZAPATOS, CUERO, null, ROJO, null, null);
    assertEquals(CALZADO, prenda.getCategoria());
  }

  @Test
  public void crearUnaPrendaYEspecificarElMaterial() {
    // Como usuarie de QuéMePongo, quiero poder indicar de qué tela o material está hecha una prenda

    Prenda prenda = new Prenda(REMERA, ALGODON, null, ROJO, null, null);
    assertEquals(REMERA, prenda.getTipoDePrenda());
  }

  @Test
  public void crearUnaPrendaYEspecificarElColor() {
    // Como usuarie de QuéMePongo, quiero poder indicar un color principal para mis prendas

    Prenda prenda = new Prenda(PANTALON, ALGODON, null, ROJO, null, null);
    assertEquals(prenda.getColorPrincipal(), ROJO);
  }

  @Test
  public void crearUnaPrendaYEspecificarElColorSecundario() {
    // Como usuarie de QuéMePongo, quiero poder indicar, si existe, un color secundario para mis prendas.

    Prenda prendaConColorSecundario = new Prenda(PANTALON, ALGODON, null, ROJO, AMARILLO, null);
    assertEquals(prendaConColorSecundario.getColorPrincipal(), ROJO);
    assertEquals(prendaConColorSecundario.getColorSecundario(), AMARILLO);
  }

  @Test
  public void crearUnaPrendaInvalida() {
    // Como usuarie de QuéMePongo, quiero evitar que haya prendas sin tipo, tela, categoría o color primario.
    /*
    assertThrows(
        PrendaInvalidaException.class,
        () -> new Prenda(null, null, null, null)
    );
     */
    // En QMP2 se implementa un Borrador para crear prendas, que valida los campos obligatorios.
    assertThrows(
        PrendaInvalidaException.class,
        () -> new Borrador(null)
    );
  }

  @Test
  public void crearUnaPrendaInvalidaSinColorSecundario() {
    // Como usuarie de QuéMePongo, quiero evitar que haya prendas cuya categoría
    // no se condiga con su tipo. (Ej, una remera no puede ser calzado).

    Prenda prenda = new Prenda(PANTALON, ALGODON, null, ROJO, null, null);
    assertNotEquals(CALZADO, prenda.getCategoria());
  }
}
