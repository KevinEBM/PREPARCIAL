package pronosticos.unitarias;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    @DisplayName("Rechaza series de distinto tamaño")
    void rechazaSeriesDeDistintoTamano() {
        CalculadoraPronosticos calculadora = new CalculadoraPronosticos();

        assertThrows(IllegalArgumentException.class,
                () -> calculadora.mse(List.of(100.0, 110.0), List.of(100.0)));
    }

    @Test
    @DisplayName("Rechaza series vacías")
    void rechazaSeriesVacias() {
        CalculadoraPronosticos calculadora = new CalculadoraPronosticos();

        assertThrows(IllegalArgumentException.class, () -> calculadora.mse(List.of(), List.of()));
    }

    @Test
    @DisplayName("Es cero cuando el pronóstico es exacto")
    void esCeroCuandoElPronosticoEsExacto() {
        double resultado = new CalculadoraPronosticos().mse(List.of(100.0, 100.0), List.of(100.0, 100.0));

        assertEquals(0.0, resultado, 0.01);
    }
}
