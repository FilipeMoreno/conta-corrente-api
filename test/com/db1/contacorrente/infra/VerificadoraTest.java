package com.db1.contacorrente.infra;

import org.junit.Assert;
import org.junit.Test;

public class VerificadoraTest {

	@Test
	public void deveRetornarExceptionQuandoValorNull() {
		String mensagem = null;
		try {
			Verificadora.verificaStringValida(null, "Valor não pode ser nulo");
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor não pode ser nulo", mensagem);
	}

	@Test
	public void deveRetornarExceptionQuandoValorVazio() {
		String mensagem = null;
		try {
			Verificadora.verificaStringValida(" ", "Valor não pode ser vazio");
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor não pode ser vazio", mensagem);
	}

	@Test
	public void naoDeveRetornarExceptionQuandoValorValido() {
		String mensagem = null;
		try {
			Verificadora.verificaStringValida("123456", "Valor Valido");
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertNull(mensagem);
	}
	
	@Test
	public void deveRetornarExceptionQuandoValorForMaiorSaldo() {
		String mensagem = null;
		try {
			Verificadora.verificarSaldo(10.0, "Você não possui saldo suficiente para realizar o saque");
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Você não possui saldo suficiente para realizar o saque", mensagem);
	}
	
	@Test
	public void naoDeveRetornarExceptionQuandoValorSaqueForValido() {
		String mensagem = null;
		try {
			Verificadora.verificarSaldo(0.0, "Você não possui saldo suficiente para realizar o saque");
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals(null, mensagem);
	}
	
}
