package ar.edu.utn.frba.dds.sugerencias;

import ar.edu.utn.frba.dds.excepciones.PrendaInexistenteException;
import ar.edu.utn.frba.dds.prenda.Prenda;
import ar.edu.utn.frba.dds.usuarios.Usuario;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class MotorSugerencia {

  // Uso Sets para remover duplicados y asegurar que cada atuendo tenga una prenda de cada tipo
  private Set<Prenda> getPrendasSuperiores(List<Prenda> prendas) {
    Set<Prenda> prendasSuperiores = prendas.stream()
        .filter(Prenda::esSuperior)
        .collect(Collectors.toSet());
    if (prendasSuperiores.isEmpty()) {
      throw new PrendaInexistenteException(
          "Usuario sin prenda superior para sugerir un atuendo.");
    }
    return prendasSuperiores;
  }

  private Set<Prenda> getPrendasInferiores(List<Prenda> prendas) {
    Set<Prenda> prendasInferiores = prendas.stream()
        .filter(Prenda::esInferior)
        .collect(Collectors.toSet());
    if (prendasInferiores.isEmpty()) {
      throw new PrendaInexistenteException(
          "Usuario sin prenda inferior para sugerir un atuendo.");
    }
    return prendasInferiores;

  }

  private Set<Prenda> getCalzados(List<Prenda> prendas) {
    Set<Prenda> prendasCalzados = prendas.stream()
        .filter(Prenda::esCalzado)
        .collect(Collectors.toSet());
    if (prendasCalzados.isEmpty()) {
      throw new PrendaInexistenteException(
          "Usuario sin prenda de tipo calzado para sugerir un atuendo.");
    }
    return prendasCalzados;
  }

  public List<Atuendo> generarCombinacionesDeAtuendos(Usuario usuario) {
    // Obtengo todas las prendas del usuario y las valido según el criterio del motor
    List<Prenda> prendas = validarPrendasDe(usuario);

    // Valido los grupos de prendas necesarios para formar un atuendo
    Set<Prenda> prendasSuperiores = getPrendasSuperiores(prendas);
    Set<Prenda> prendasInferiores = getPrendasInferiores(prendas);
    Set<Prenda> calzados = getCalzados(prendas);

    // Armo las combinaciones de atuendos posibles
    Set<List<Prenda>> combinaciones = Sets.cartesianProduct(
        prendasSuperiores, prendasInferiores, calzados);

    return combinaciones.stream()
        .map(comb -> new Atuendo(comb.get(0), comb.get(1), comb.get(2)))
        .collect(Collectors.toList());
  }

  public abstract List<Prenda> validarPrendasDe(Usuario usuario);

  public Atuendo sugerirAtuendo(Usuario usuario) {
    List<Atuendo> combinaciones = generarCombinacionesDeAtuendos(usuario);
    Collections.shuffle(combinaciones);
    return combinaciones.get(0);
  }
}
