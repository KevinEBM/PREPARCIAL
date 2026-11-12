package pronosticos.unitarias;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pronosticos.CalculadoraPronosticos;

/** Pruebas unitarias del error cuadrático medio (MSE). */
class MseTest {

    @Test
    @DisplayName("Calcula el error cuadrático medio")
    void calculaElErrorCuadraticoMedio() {
        double resultado = new CalculadoraPronosticos().mse(
                List.of(141.0, 138.0, 150.0), List.of(126.67, 133.67, 135.67));

        // (14.33² + 4.33² + 14.33²) / 3 = (205.35 + 18.75 + 205.35) / 3 = 143.15
        assertEquals(143.15, resultado, 0.01);
    }
}
