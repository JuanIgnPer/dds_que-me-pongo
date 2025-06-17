package ar.edu.utn.frba.dds;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import static ar.edu.utn.frba.dds.prenda.Material.ALGODON;
import static ar.edu.utn.frba.dds.prenda.Material.CUERO;
import static ar.edu.utn.frba.dds.prenda.TipoDePrenda.CAMISA_MANGA_CORTA;
import static ar.edu.utn.frba.dds.prenda.TipoDePrenda.CAMISA_MANGA_LARGA;
import static ar.edu.utn.frba.dds.prenda.TipoDePrenda.PANTALON;
import static ar.edu.utn.frba.dds.prenda.TipoDePrenda.ZAPATOS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import ar.edu.utn.frba.dds.excepciones.PrendaInexistenteException;
import ar.edu.utn.frba.dds.prenda.Borrador;
import ar.edu.utn.frba.dds.prenda.Color;
import ar.edu.utn.frba.dds.prenda.Formalidad;
import ar.edu.utn.frba.dds.prenda.Prenda;
import ar.edu.utn.frba.dds.sugerencias.Atuendo;
import ar.edu.utn.frba.dds.sugerencias.MotorSugerencia;
import ar.edu.utn.frba.dds.sugerencias.MotorSugerenciaBasico;
import ar.edu.utn.frba.dds.sugerencias.MotorSugerenciaSegunFormalidad;
import ar.edu.utn.frba.dds.usuarios.Usuario;
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
  public static Prenda parteSuperiorFormal;
  public static Prenda parteInferiorFormal;
  public static Prenda calzadoFormal;
  public static MotorSugerencia motorDeSugerencia;
  public static List<Prenda> prendas;
  public static Usuario unUsuario;

  @BeforeAll
  public static void setUp() {
    ROJO = new Color(255, 0, 0);
    AZUL = new Color(0, 0, 255);
    AMARILLO = new Color(255, 255, 0);
    NEGRO = new Color(0, 0, 0);

    borrador = new Borrador(CAMISA_MANGA_CORTA);
    borrador.especificarMaterial(ALGODON);
    borrador.especificarColorPrincipal(ROJO);
    borrador.especificarFormalidad(Formalidad.INFORMAL);
    parteSuperior = borrador.crearPrenda();

    borrador = new Borrador(PANTALON);
    borrador.especificarMaterial(CUERO);
    borrador.especificarColorPrincipal(AZUL);
    borrador.especificarFormalidad(Formalidad.INFORMAL);
    parteInferior = borrador.crearPrenda();

    borrador = new Borrador(ZAPATOS);
    borrador.especificarMaterial(CUERO);
    borrador.especificarColorPrincipal(NEGRO);
    borrador.especificarFormalidad(Formalidad.NEUTRA);
    calzado = borrador.crearPrenda();

    borrador = new Borrador(CAMISA_MANGA_LARGA);
    borrador.especificarMaterial(ALGODON);
    borrador.especificarColorPrincipal(AZUL);
    borrador.especificarFormalidad(Formalidad.FORMAL);
    parteSuperiorFormal = borrador.crearPrenda();

    borrador = new Borrador(PANTALON);
    borrador.especificarMaterial(CUERO);
    borrador.especificarColorPrincipal(NEGRO);
    borrador.especificarFormalidad(Formalidad.FORMAL);
    parteInferiorFormal = borrador.crearPrenda();

    borrador = new Borrador(ZAPATOS);
    borrador.especificarMaterial(CUERO);
    borrador.especificarColorPrincipal(NEGRO);
    borrador.especificarFormalidad(Formalidad.FORMAL);
    calzadoFormal = borrador.crearPrenda();
  }

  @Test
  public void recibirUnaSugerenciaDeAtuendoBasico() {
    // Como usuarie de QuéMePongo, quiero recibir una sugerencia de prendas
    // que me vista completamente (torso, piernas, pies),
    // cubriendo cada parte del cuerpo con no más de una prenda
    // (es decir, evitando superposiciones por ahora).
    motorDeSugerencia = new MotorSugerenciaBasico();
    prendas = Arrays.asList(parteSuperior, parteInferior, calzado);
    unUsuario = new Usuario(50, prendas, motorDeSugerencia);

    Atuendo atuendoSugerido = unUsuario.generarSugerencia();
    assertEquals(parteSuperior, atuendoSugerido.getPrendaSuperior());
    assertEquals(parteInferior, atuendoSugerido.getPrendaInferior());
    assertEquals(calzado, atuendoSugerido.getCalzado());
  }

  @Test
  public void lanzarUnaExcepcionSiNoSeEncuentraUnaPrendaDeCategoria_Superior() {
    prendas = Arrays.asList(parteInferior, calzado);
    motorDeSugerencia = new MotorSugerenciaBasico();
    unUsuario = new Usuario(30, prendas, motorDeSugerencia);

    assertThrows(
        PrendaInexistenteException.class,
        unUsuario::generarSugerencias,
        "No se encontraron prendas de la categoria Parte Superior"
    );
  }

  @Test
  public void lanzarUnaExcepcionSiNoSeEncuentraUnaPrendaDeCategoria_Inferior() {
    prendas = Arrays.asList(parteSuperior, calzado);
    motorDeSugerencia = new MotorSugerenciaBasico();
    unUsuario = new Usuario(30, prendas, motorDeSugerencia);

    assertThrows(
        PrendaInexistenteException.class,
        unUsuario::generarSugerencias,
        "No se encontraron prendas de la categoria Parte Inferior"
    );
  }

  @Test
  public void lanzarUnaExcepcionSiNoSeEncuentraUnaPrendaDeCategoria_Calzado() {
    prendas = Arrays.asList(parteSuperior, parteInferior);
    motorDeSugerencia = new MotorSugerenciaBasico();
    unUsuario = new Usuario(30, prendas, motorDeSugerencia);

    assertThrows(
        PrendaInexistenteException.class,
        unUsuario::generarSugerencias,
        "No se encontraron prendas de la categoria Calzado"
    );
  }

  @Test
  public void recibirMultiplesSugerenciasDePrendas() {
    //Como usuarie de QuéMePongo, quiero recibir varias sugerencias
    // que combinen todas las prendas de mi guardarropas
    motorDeSugerencia = new MotorSugerenciaBasico();
    prendas = Arrays.asList(parteSuperior, parteInferior, calzado,
        parteSuperiorFormal, parteInferiorFormal, calzadoFormal);
    unUsuario = new Usuario(50, prendas, motorDeSugerencia);

    List<Atuendo> sugerencias = unUsuario.generarSugerencias();

    int cantDeSugerenciasEsperadas = 8; // 2 superiores * 2 inferiores * 2 calzado
    assertEquals(cantDeSugerenciasEsperadas, sugerencias.size());
  }

  @Test
  public void cadaPrendaTieneUnNivelDeFormalidad() {
    // Como usuarie de QuéMePongo, quiero poder indicar
    // si una prenda es formal, informal, o neutra.

    assertEquals(Formalidad.FORMAL, parteSuperiorFormal.getFormalidad());
    assertEquals(Formalidad.INFORMAL, parteSuperior.getFormalidad());
    assertEquals(Formalidad.NEUTRA, calzado.getFormalidad());
  }

  @Test
  public void recibirSugerenciasSegunNivelDeFormalidad() {
    // Como administradore de QuéMePongo, quiero que, si así está configurado
    // al generarse las sugerencias, se filtre la ropa informal
    // para les usuaries mayores de 55 años.

    motorDeSugerencia = new MotorSugerenciaSegunFormalidad();
    prendas = Arrays.asList(parteSuperior, parteInferior, calzado,
        parteSuperiorFormal, parteInferiorFormal, calzadoFormal);
    unUsuario = new Usuario(56, prendas, motorDeSugerencia);

    List<Atuendo> sugerencias = unUsuario.generarSugerencias();

    int cantDeSugerenciasEsperadas = 1; // 1 superiores * 1 inferiores * 1 calzado
    assertEquals(cantDeSugerenciasEsperadas, sugerencias.size());
  }

  @Test
  public void noEjecutarLogicaAdicionalAlGenerarSugerencias() {
    // Como administradore de QuéMePongo, quiero que, si así esta configurado,
    // al generarse las sugerencias, no se ejecute ningún tipo de lógica adicional.
    MotorSugerencia motorSugerencia = Mockito.spy(new MotorSugerenciaBasico());
    prendas = Arrays.asList(parteSuperior, parteInferior, calzado);
    unUsuario = new Usuario(50, prendas, motorSugerencia);

    // Verificar que los métodos se llamen una vez
    unUsuario.generarSugerencia();
    verify(motorSugerencia, times(1)).validarPrendasDe(unUsuario);
    verify(motorSugerencia, times(1)).generarCombinacionesDeAtuendos(unUsuario);
  }

  @Test
  public void cambiarMotorDeSugerenciasPeriodicamente() {
    // Como administradore de QuéMePongo, quiero poder
    // cambiar el motor de sugerencias periódicamente entre los existentes (o nuevos)
    // para evaluar cuál genera un mejor efecto sobre los usuarios.

    motorDeSugerencia = new MotorSugerenciaSegunFormalidad();
    unUsuario = new Usuario(56, List.of(), motorDeSugerencia);

    assertEquals(motorDeSugerencia, unUsuario.getMotorSugerencia());

    motorDeSugerencia = new MotorSugerenciaBasico();
    unUsuario.setMotorSugerencia(motorDeSugerencia);

    assertEquals(motorDeSugerencia, unUsuario.getMotorSugerencia());
  }
}
