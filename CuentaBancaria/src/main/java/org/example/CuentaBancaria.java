package org.example;

import java.util.ArrayList;
import java.util.List;

public class CuentaBancaria {
    private double saldo;
    private List<String> historialTransacciones;
    private CuentaBancaria cuentaAsociada;

    public CuentaBancaria(double saldoInicial) {
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo");
        }
        this.saldo = saldoInicial;
        this.historialTransacciones = new ArrayList<>();
        this.historialTransacciones.add("Cuenta creada con saldo inicial de " + saldoInicial);
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) {
        if (monto < 0) {
            throw new IllegalArgumentException("El monto a depositar no puede ser negativo");
        }
        saldo += monto;
        historialTransacciones.add("Depósito de " + monto);
    }

    public void retirar(double monto) {
        if (monto < 0) {
            throw new IllegalArgumentException("El monto a retirar no puede ser negativo");
        }
        if (monto > saldo) {
            throw new IllegalArgumentException("Fondos insuficientes");
        }
        saldo -= monto;
        historialTransacciones.add("Retiro de " + monto);
    }

    public List<String> getHistorialTransacciones() {
        return historialTransacciones;
    }

    public CuentaBancaria getCuentaAsociada() {
        return cuentaAsociada;
    }

    public void asociarCuenta(CuentaBancaria cuenta) {
        this.cuentaAsociada = cuenta;
    }
}