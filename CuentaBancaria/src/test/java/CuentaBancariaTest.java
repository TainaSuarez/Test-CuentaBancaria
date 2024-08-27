
import static org.junit.jupiter.api.Assertions.*;

import org.example.CuentaBancaria;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class CuentaBancariaTest {

    @Test
    public void testConstructor() {
        CuentaBancaria cuenta = new CuentaBancaria(100.0);
        assertEquals(100.0, cuenta.getSaldo());
    }

    @Test
    public void testDepositar() {
        CuentaBancaria cuenta = new CuentaBancaria(100.0);
        cuenta.depositar(50.0);
        assertEquals(150.0, cuenta.getSaldo());
    }

    @Test
    public void testRetirar() {
        CuentaBancaria cuenta = new CuentaBancaria(100.0);
        cuenta.retirar(50.0);
        assertEquals(50.0, cuenta.getSaldo());
    }

    @Test
    public void testFondosInsuficientes() {
        CuentaBancaria cuenta = new CuentaBancaria(100.0);
        assertThrows(IllegalArgumentException.class, () -> cuenta.retirar(150.0));
    }

    @Test
    public void testDepositoNegativo() {
        CuentaBancaria cuenta = new CuentaBancaria(100.0);
        assertThrows(IllegalArgumentException.class, () -> cuenta.depositar(-10.0));
    }

    @Test
    public void testHistorialTransacciones() {
        CuentaBancaria cuenta = new CuentaBancaria(100.0);
        cuenta.depositar(50.0);
        cuenta.retirar(20.0);

        List<String> historialEsperado = Arrays.asList(
                "Cuenta creada con saldo inicial de 100.0",
                "Depósito de 50.0",
                "Retiro de 20.0"
        );

        assertIterableEquals(historialEsperado, cuenta.getHistorialTransacciones());
    }

    @Test
    public void testCuentaAsociadaNull() {
        CuentaBancaria cuenta = new CuentaBancaria(100.0);
        assertNull(cuenta.getCuentaAsociada());

        CuentaBancaria otraCuenta = new CuentaBancaria(200.0);
        cuenta.asociarCuenta(otraCuenta);

        assertNotNull(cuenta.getCuentaAsociada());
        assertEquals(otraCuenta, cuenta.getCuentaAsociada());
    }
}