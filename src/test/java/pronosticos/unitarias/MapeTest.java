package pronosticos.unitarias;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pronosticos.CalculadoraPronosticos;

class MapeTest {

    private final CalculadoraPronosticos calculadora = new CalculadoraPronosticos();

    @Test
    @DisplayName("Calcula el MAPE de una serie normal")
    void calculaElMapeDeUnaSerieNormal() {
        double resultado = calculadora.mape(
                List.of(141.0, 138.0, 150.0),
                List.of(126.67, 133.67, 135.67));

        assertEquals(7.62, resultado, 0.01);
    }

    @Test
    @DisplayName("Excluye del cálculo el periodo con demanda 0")
    void excluyeElPeriodoConDemandaCero() {
        double resultado = calculadora.mape(
                List.of(80.0, 0.0, 95.0),
                List.of(80.0, 0.0, 100.0));

        assertEquals(2.63, resultado, 0.01);
    }

    @Test
    @DisplayName("Lanza error si todos los periodos tienen demanda 0")
    void lanzaErrorSiTodosLosPeriodosTienenDemandaCero() {
        assertThrows(IllegalArgumentException.class,
                () -> calculadora.mape(List.of(0.0, 0.0), List.of(10.0, 20.0)));
    }
}