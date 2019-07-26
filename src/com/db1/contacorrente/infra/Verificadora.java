package com.db1.contacorrente.infra;

import javax.management.RuntimeErrorException;

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
	
	public static void verificarSaldoConta(Double value, String message) {
		ContaCorrente contaCorrente = new ContaCorrente("000123", "0000012345", "Filipe Moreno");
		if (value < 0 || value < contaCorrente.getSaldo()) {
			throw new RuntimeException(message);
		}
	}

}
