
import static org.junit.jupiter.api.Assertions.*;

import org.example.CuentaBancaria;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class CuentaBancariaTest {

    @Test
    public void testConstructor() {
        // aca creo una cuenta nueva conh un saldo inicial de 100.0
        CuentaBancaria cuenta = new CuentaBancaria(100.0);
        // aca verifico  que el saldo inicial es el esperado utilizando assertEquals
        assertEquals(100.0, cuenta.getSaldo());
    }

    @Test
    public void testDepositar() {
        CuentaBancaria cuenta = new CuentaBancaria(100.0);
         // Realizamos un depósito de 50.0
        cuenta.depositar(50.0);
        // Ver si el saldo se ha actualizado correctamente
        assertEquals(150.0, cuenta.getSaldo());
    }

    @Test
    public void testRetirar() {
        CuentaBancaria cuenta = new CuentaBancaria(100.0);
        cuenta.retirar(50.0);
        // Verificamos que el saldo se ha actualizado correctamente
        assertEquals(50.0, cuenta.getSaldo());
    }

    @Test
    public void testFondosInsuficientes() {
        CuentaBancaria cuenta = new CuentaBancaria(100.0);
         //  retirar un monto mayor al saldo disponible, lo cual debería lanzar una excepción
        assertThrows(IllegalArgumentException.class, () -> cuenta.retirar(150.0));
    }

    @Test
    public void testDepositoNegativo() {
        CuentaBancaria cuenta = new CuentaBancaria(100.0);
        // deposita un monto negativo, lo cual debería lanzar una excepción
        assertThrows(IllegalArgumentException.class, () -> cuenta.depositar(-10.0));
    }

    @Test
    public void testHistorialTransacciones() {
        CuentaBancaria cuenta = new CuentaBancaria(100.0);
        // Realizamos algunas transacciones
        cuenta.depositar(50.0);
        cuenta.retirar(20.0);
        
        // Define la lista de historial esperada
        List<String> historialEsperado = Arrays.asList(
                "Cuenta creada con saldo inicial de 100.0",
                "Depósito de 50.0",
                "Retiro de 20.0"
        );
        // Verifica que el historial de transacciones coincida con la lista esperada
        // assertIterableEquals compara dos listas para asegurar que contienen los mismos elementos en el mismo orden
        assertIterableEquals(historialEsperado, cuenta.getHistorialTransacciones());
    }

    @Test
    public void testCuentaAsociadaNull() {
        CuentaBancaria cuenta = new CuentaBancaria(100.0);
         // Verifica que inicialmente no hay ninguna cuenta asociada
        // assertNull verifica que el valor es null
        assertNull(cuenta.getCuentaAsociada());

        // Creo otra cuenta con un saldo inicial de 200.0
        CuentaBancaria otraCuenta = new CuentaBancaria(200.0);
        // Asocia la segunda cuenta con la primera
        cuenta.asociarCuenta(otraCuenta);
      
        
        // Verifico que ahora la cuenta asociada no es null
        // assertNotNull verifica que el valor no es null
        assertNotNull(cuenta.getCuentaAsociada());
        //  cuenta asociada es la que se ha asignado
        assertEquals(otraCuenta, cuenta.getCuentaAsociada());
    }
}