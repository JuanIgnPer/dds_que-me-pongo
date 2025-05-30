package ar.edu.utn.frba.dds;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import ar.edu.utn.frba.dds.excepciones.PrendaInvalidaException;
import ar.edu.utn.frba.dds.prenda.Categoria;
import ar.edu.utn.frba.dds.prenda.Color;
import ar.edu.utn.frba.dds.prenda.Material;
import ar.edu.utn.frba.dds.prenda.Prenda;
import ar.edu.utn.frba.dds.prenda.TipoDePrenda;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class QMP1Test {

  public static TipoDePrenda ZAPATO;
  public static TipoDePrenda REMERA;
  public static TipoDePrenda PANTALON;
  public static TipoDePrenda CAMISA;

  public static Color ROJO;
  public static Color AZUL;
  public static Color AMARILLO;

  @BeforeAll
  public static void setUp() {
    ZAPATO = new TipoDePrenda(Categoria.CALZADO);
    REMERA = new TipoDePrenda(Categoria.PARTE_SUPERIOR);
    PANTALON = new TipoDePrenda(Categoria.PARTE_INFERIOR);
    CAMISA = new TipoDePrenda(Categoria.PARTE_INFERIOR);

    ROJO = new Color(255, 0, 0);
    AZUL = new Color(0, 0, 255);
    AMARILLO = new Color(255, 255, 0);
  }


  @Test
  public void crearUnaPrendaYEspecificarElTipoDePrenda() {
    // Como usuarie de QuéMePongo, quiero especificar qué tipo de prenda estoy cargando
    // (zapatos, camisa de mangas cortas, pantalón, etc).

    Prenda prenda = new Prenda(CAMISA, Material.ALGODON, ROJO);
    assertEquals(prenda.getTipoDePrenda(), CAMISA);
  }

  @Test
  public void crearUnaPrendaYEspecificarLaCategoria() {
    // Como usuarie de QuéMePongo, quiero identificar a qué categoría pertenece una prenda
    // (parte superior, calzado, parte inferior, accesorios).

    Prenda prenda = new Prenda(ZAPATO, Material.CUERO, ROJO);
    assertEquals(prenda.getCategoria(), Categoria.CALZADO);
  }

  @Test
  public void crearUnaPrendaYEspecificarElMaterial() {
    // Como usuarie de QuéMePongo, quiero poder indicar de qué tela o material está hecha una prenda

    Prenda prenda = new Prenda(REMERA, Material.ALGODON, ROJO);
    assertEquals(prenda.getTipoDePrenda(), REMERA);
  }

  @Test
  public void crearUnaPrendaYEspecificarElColor() {
    // Como usuarie de QuéMePongo, quiero poder indicar un color principal para mis prendas

    Prenda prenda = new Prenda(PANTALON, Material.ALGODON, ROJO);
    assertEquals(prenda.getColorPrimario(), ROJO);
  }

  @Test
  public void crearUnaPrendaYEspecificarElColorSecundario() {
    // Como usuarie de QuéMePongo, quiero poder indicar, si existe, un color secundario para mis prendas.

    Prenda prendaConColorSecundario = new Prenda(PANTALON, Material.ALGODON, ROJO, AMARILLO);
    assertEquals(prendaConColorSecundario.getColorPrimario(), ROJO);
    assertEquals(prendaConColorSecundario.getColorSecundario(), AMARILLO);
  }

  @Test
  public void crearUnaPrendaInvalida() {
    // Como usuarie de QuéMePongo, quiero evitar que haya prendas sin tipo, tela, categoría o color primario.

    assertThrows(
        PrendaInvalidaException.class,
        () -> new Prenda(null, null, null)
    );
  }

  @Test
  public void crearUnaPrendaInvalidaSinColorSecundario() {
    // Como usuarie de QuéMePongo, quiero evitar que haya prendas cuya categoría
    // no se condiga con su tipo. (Ej, una remera no puede ser calzado).

    Prenda prenda = new Prenda(PANTALON, Material.ALGODON, ROJO);
    assertNotEquals(prenda.getCategoria(), Categoria.CALZADO);
  }
}
