package com.db1.contacorrente.infra;

import com.db1.contacorrente.ContaCorrente;

public class Verificadora {
	
	public static void verificaStringValida(String value, String message) {
		if (value == null || value.trim().isEmpty()){
			throw new RuntimeException(message);
		}
	}
	
	public static void valorMaiorQueZero(Double value, String message) {
		if (value == null || value <= 0) {
			throw new RuntimeException(message);
		}
	}
	
	public static void verificarSaldo(Double value, String message) {
		ContaCorrente contaCorrente = new ContaCorrente(null, null, null);
		Double saldo = contaCorrente.getSaldo();
		if (saldo < value) {
			throw new RuntimeException();
		}
	}
}
