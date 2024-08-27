package org.example;

import java.util.ArrayList;
import java.util.List;

public class CuentaBancaria {
    // Variable que almacena el saldo de la cuenta
    private double saldo;
    // Lista que guarda el historial de todas las transacciones realizadas en la cuenta
    private List<String> historialTransacciones;
    // Referencia a otra cuenta bancaria asociada, puede ser null si no hay ninguna cuenta asociada
    private CuentaBancaria cuentaAsociada;
    
    // Constructor que inicializa la cuenta con un saldo inicial dado
    public CuentaBancaria(double saldoInicial) {
        // Si el saldo inicial es negativo, lanza una excepción indicando que no es válido
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo");
        }
        this.saldo = saldoInicial;
        // Inicializa el historial de transacciones como una lista vacía
        this.historialTransacciones = new ArrayList<>();
        // Registra la creación de la cuenta con el saldo inicial en el historial de transacciones
        this.historialTransacciones.add("Cuenta creada con saldo inicial de " + saldoInicial);
    }
// Método para obtener el saldo actual de la cuenta
    public double getSaldo() {
        return saldo;
    }
    // Método para depositar una cantidad en la cuenta
    public void depositar(double monto) {
        // Si el monto a depositar es negativo, lanza una excepción indicando que no es válido
        if (monto < 0) {
            throw new IllegalArgumentException("El monto a depositar no puede ser negativo");
        }
        // Incrementa el saldo con el monto depositado
        saldo += monto;
        historialTransacciones.add("Depósito de " + monto);
    }
     // Método para retirar una cantidad de la cuenta
    public void retirar(double monto) {
     // Si el monto a retirar es negativo, lanza una excepción indicando que no es válido
        if (monto < 0) {
            throw new IllegalArgumentException("El monto a retirar no puede ser negativo");
        }
     // Si el monto a retirar es mayor que el saldo disponible, lanza una excepción indicando fondos insuficientes
        if (monto > saldo) {
            throw new IllegalArgumentException("Fondos insuficientes");
        }
        // Resta el saldo con el monto retirado
        saldo -= monto;
        // Registra el retiro en el historial de transacciones
        historialTransacciones.add("Retiro de " + monto);
    }
// Método para obtener el historial de transacciones de la cuenta
    public List<String> getHistorialTransacciones() {
        return historialTransacciones;
    }
    // Método para obtener la cuenta bancaria asociada, si existe

    public CuentaBancaria getCuentaAsociada() {
        return cuentaAsociada;
    }
    // Método para asociar otra cuenta bancaria a la actual

    public void asociarCuenta(CuentaBancaria cuenta) {
        this.cuentaAsociada = cuenta;
    }
}