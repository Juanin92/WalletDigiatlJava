package test.wallet;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import wallet.Cuenta;
import wallet.*;

public class CuentaTest {

    private Cuenta cuenta;
    private Moneda pesoChileno;

    @BeforeEach
    private void setUp() {
        pesoChileno = new Moneda("CLP", "PesoChileno");
        cuenta = new Cuenta("Juan", "Claveria", "jc@gmail.com", "12345678-9", 123456, "Corriente", "BancoChile",
                123456788, 500000, true, pesoChileno);
    }

    @DisplayName("Comprobación de constructor, getter / setter")
    @Test
    void testConstructor() {
        assertEquals("Juan", cuenta.getNombre());
        assertEquals("Claveria", cuenta.getApellido());
        assertEquals("jc@gmail.com", cuenta.getEmail());
        assertEquals("12345678-9", cuenta.getRut());
        assertEquals(123456, cuenta.getPass());
        assertEquals("Corriente", cuenta.getTipoCuenta());
        assertEquals("BancoChile", cuenta.getNombreBanco());
        assertEquals(123456788, cuenta.getNumeroCuenta());
        assertEquals(500000, cuenta.getSaldo(), 0.01);
        assertEquals(true, cuenta.isValidacionCuenta());
        assertEquals(pesoChileno, cuenta.getMoneda());

        cuenta.setNombre("Ignacio");
        cuenta.setApellido("Cordero");
        cuenta.setEmail("ic@gmail.com");
        cuenta.setRut("12345678-0");
        cuenta.setPass(654321);
        cuenta.setTipoCuenta("Vista");
        cuenta.setNombreBanco("BancoEstado");
        cuenta.setNumeroCuenta(876554433);
        cuenta.setSaldo(600000);
        cuenta.setValidacionCuenta(false);
        cuenta.setMoneda(pesoChileno);

        assertEquals("Ignacio", cuenta.getNombre());
        assertEquals("Cordero", cuenta.getApellido());
        assertEquals("ic@gmail.com", cuenta.getEmail());
        assertEquals("12345678-0", cuenta.getRut());
        assertEquals(654321, cuenta.getPass());
        assertEquals("Vista", cuenta.getTipoCuenta());
        assertEquals("BancoEstado", cuenta.getNombreBanco());
        assertEquals(876554433, cuenta.getNumeroCuenta());
        assertEquals(600000, cuenta.getSaldo(), 0.01);
        assertEquals(false, cuenta.isValidacionCuenta());
        assertEquals(pesoChileno, cuenta.getMoneda());
    }

    @DisplayName("Verificar que se imprima el saldo correcto en la consola")
    @Test
    void testConsultaSaldo() {
        cuenta.ConsultaSaldo();
    }

    @Test
    void testDepositar() {
        double montoDepositar = 100000;
        cuenta.Depositar(montoDepositar);
        assertEquals(600000, cuenta.getSaldo(), 0.01);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0,-10000})
    @DisplayName("Test para depositar de dinero números negativos")
    void testDepositarEscenarios(double montoDepositar){
        cuenta.RetiroDinero(montoDepositar);
        assertEquals(500000, cuenta.getSaldo(),0.01);
    }

    @ParameterizedTest
    @ValueSource(doubles = {5000,30000,2000})
    @DisplayName("Test para retiro de dinero")
    void testRetiroDinero(double montoRetirar){
        cuenta.RetiroDinero(montoRetirar);
        assertEquals(500000 - montoRetirar, cuenta.getSaldo(), 0.0);
    }

    @ParameterizedTest
    @ValueSource(doubles = {700000,0,-10000})
    @DisplayName("Test para retiro de dinero, numero negativo y monto mayor a saldo de cuenta")
    void testRetiroDineroEscenarios(double montoRetirar){
        cuenta.RetiroDinero(montoRetirar);
        assertEquals(500000, cuenta.getSaldo(),0.01);
    }

    @DisplayName("Comprobación que la transferencia sea del mismo banco")
    @Test
    void testTransferirMismoBanco() {
        Cuenta cuentaDestino = new Cuenta("Ignacio", "Cordero", "ic@gmail.com", "12345678-0", 654321, "Vista", "BancoChile", 456456457, 100000, true, pesoChileno);
        double montoTransferir = 100000;
        cuenta.Transferir(montoTransferir, cuentaDestino);
        assertEquals(400000, cuenta.getSaldo(), 0.01);
        assertEquals(200000, cuentaDestino.getSaldo(),0.01);
    }

    @DisplayName("Comprobación que la transferencia sea de distinto banco, y asi se cobre una comisión")
    @Test
    void testTransferirDistintoBanco(){
        Cuenta cuentaDestino = new Cuenta("Ignacio", "Cordero", "ic@gmail.com", "12345678-0", 654321, "Vista", "BancoEstado", 456456457, 100000, true, pesoChileno);
        double montoTransferir = 100000;
        cuenta.Transferir(montoTransferir, cuentaDestino);
        assertEquals(399700, cuenta.getSaldo(), 0.01);
        assertEquals(200000, cuentaDestino.getSaldo(),0.01);
    }

    @Test
    public void testToString() {
        String expectedToString = "\nNombre: Juan Claveria" +
                                  "\nBanco: BancoChile" +
                                  "\nCuenta: Corriente" +
                                  "\nN° Cuenta: 123456788" +
                                  "\nSaldo: $500000.0";

        String actualToString = cuenta.toString();

        assertEquals(expectedToString, actualToString);
    }
}
