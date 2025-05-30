package ar.edu.utn.frba.dds;

import static ar.edu.utn.frba.dds.prenda.Material.ALGODON;
import static ar.edu.utn.frba.dds.prenda.Material.CUERO;
import static ar.edu.utn.frba.dds.prenda.TipoDePrenda.CAMISA_MANGA_CORTA;
import static ar.edu.utn.frba.dds.prenda.TipoDePrenda.PANTALON;
import static ar.edu.utn.frba.dds.prenda.TipoDePrenda.ZAPATOS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ar.edu.utn.frba.dds.excepciones.PrendaInexistenteException;
import ar.edu.utn.frba.dds.excepciones.PrendaInvalidaException;
import ar.edu.utn.frba.dds.prenda.Borrador;
import ar.edu.utn.frba.dds.prenda.Color;
import ar.edu.utn.frba.dds.prenda.Prenda;
import ar.edu.utn.frba.dds.sugerencias.Atuendo;
import ar.edu.utn.frba.dds.sugerencias.Guardarropa;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class QMP3Test {

  public static Color ROJO;
  public static Color AZUL;
  public static Color AMARILLO;
  public static Color NEGRO;
  public static Borrador borrador;
  public static Prenda parteSuperior;
  public static Prenda parteInferior;
  public static Prenda calzado;

  @BeforeAll
  public static void setUp() {
    ROJO = new Color(255, 0, 0);
    AZUL = new Color(0, 0, 255);
    AMARILLO = new Color(255, 255, 0);
    NEGRO = new Color(0, 0, 0);

    borrador = new Borrador(CAMISA_MANGA_CORTA);
    borrador.especificarMaterial(ALGODON);
    borrador.especificarColorPrincipal(ROJO);
    parteSuperior = borrador.crearPrenda();

    borrador = new Borrador(PANTALON);
    borrador.especificarMaterial(CUERO);
    borrador.especificarColorPrincipal(AZUL);
    parteInferior = borrador.crearPrenda();

    borrador = new Borrador(ZAPATOS);
    borrador.especificarMaterial(CUERO);
    borrador.especificarColorPrincipal(NEGRO);
    calzado = borrador.crearPrenda();
  }

  @Test
  public void recibirUnaSugerenciaDePrendas() {
    // Como usuarie de QuéMePongo, quiero recibir una sugerencia de prendas
    // que me vista completamente (torso, piernas, pies),
    // cubriendo cada parte del cuerpo con no más de una prenda
    // (es decir, evitando superposiciones por ahora).

    List<Prenda> listaDePrendas = Arrays.asList(parteSuperior, parteInferior, calzado);
    Guardarropa guardarropa = new Guardarropa(listaDePrendas);

    Atuendo atuendoSugerido = guardarropa.generarAtuendo();

    assertEquals(parteSuperior, atuendoSugerido.getPrendaSuperior());
  }

  @Test
  public void lanzarUnaExcepcionSiNoSeEncuentraUnaPrendaConLaCategoriaCorrecta(){
    List<Prenda> listaDePrendas = Arrays.asList();
    Guardarropa guardarropa = new Guardarropa(listaDePrendas);

    assertThrows(
        PrendaInexistenteException.class,
        () -> guardarropa.generarParteSuperior(),
        "No se encontraron prendas de la categoria Parte Superior"
    );

    assertThrows(
        PrendaInexistenteException.class,
        () -> guardarropa.generarParteInferior(),
        "No se encontraron prendas de la categoria Parte Inferior"
    );

    assertThrows(
        PrendaInexistenteException.class,
        () -> guardarropa.generarCalzado(),
        "No se encontraron prendas de la categoria Calzado"
    );
  }

  @Test
  public void recibirMultiplesSugerenciasDePrendas() {
    //Como usuarie de QuéMePongo, quiero recibir varias sugerencias
    // que combinen todas las prendas de mi guardarropas

    // Hacer la combinatoria con todas las prendas del guardarropas
  }

  @Test
  public void cadaPrendaTieneUnNivelDeFormalidad() {
    // Como usuarie de QuéMePongo, quiero poder indicar
    // si una prenda es formal, informal, o neutra.

    // Cada prenda debe tener un nivelDeFormalidad, un enum similar a tipoDePrenda.
  }

  @Test
  public void recibirSugerenciasSegunNivelDeFormalidad() {
    // Como administradore de QuéMePongo, quiero que, si así está configurado
    // al generarse las sugerencias, se filtre la ropa informal
    // para les usuaries mayores de 55 años.

    // Implementar lógica para filtrar atuendos según el nivel de formalidad.
  }

  @Test
  public void noEjecutarLogicaAdicionalAlGenerarSugerencias() {
    // Como administradore de QuéMePongo, quiero que, si así esta configurado,
    // al generarse las sugerencias, no se ejecute ningún tipo de lógica adicional.

    // Implementar lógica para cambiar el motor de sugerencias.
  }

  @Test
  public void cambiarMotorDeSugerenciasPeriodicamente() {
    // Como administradore de QuéMePongo, quiero poder
    // cambiar el motor de sugerencias periódicamente entre los existentes (o nuevos)
    // para evaluar cuál genera un mejor efecto sobre los usuarios.

    // Implementar lógica para cambiar el motor de sugerencias periódicamente.
  }

  /*
  "Nivel de formalidad": es un atributo de la clase prenda.
  enum NivelDeFormalidad{FORMAL, INFORMAL o NEUTRO.}


  "Motor de sugerencias": es un atributo de la clase Guardarropa.
  Me suena a un strategy de sugerencias.

  "Usuarie mayor de 55 años": no hay nada definido al respecto en el enunciado,
   */

}
