package test.wallet;

import static org.junit.Assert.*;

import org.junit.jupiter.api.*;

import wallet.Moneda;

public class MonedaTest {

    private Moneda moneda;

    @BeforeEach
    void setUp() {
        moneda = new Moneda("CLP", "PesoChileno");
    }

    @DisplayName("Comprobación de ingreso de datos")
    @Test
    void testConstructor() {

        assertEquals("CLP", moneda.getSimbolo());
        assertEquals("PesoChileno", moneda.getNombreMoneda());

        moneda.setSimbolo("USD");
        moneda.setNombreMoneda("Dolar");

        assertEquals("USD", moneda.getSimbolo());
        assertEquals("Dolar", moneda.getNombreMoneda());
    }

    @DisplayName("Comprobación de conversion de divisas")
    @Test
    void testConversionDivisa() {

        double conversion = moneda.ConversionDivisas(10000, "USD");
        assertEquals(10.49, conversion, 0.01);

        conversion = moneda.ConversionDivisas(10000, "EURO");
        assertEquals(9.85, conversion, 0.01);

        conversion = moneda.ConversionDivisas(10000, "ARS");
        assertEquals(0, conversion, 0);
    }

    @DisplayName("Comprobación si el saldo es 0 para hacer conversion")
    @Test
    public void testSaldoCero() {

        double conversion = moneda.ConversionDivisas(0, "USD");

        assertEquals(0, conversion, 0.01);
    }
}
