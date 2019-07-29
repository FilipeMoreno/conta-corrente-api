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
	public void  naoDeveRetornarExceptionQuandoValorForZero2() {
		String mensagem = null;
		try {
			Verificadora.valorMenorQueZero(0.0, "Valor inválido");
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertNull(mensagem);
	}
	
	@Test
	public void deveRetornarExceptionQuandoNull2() {
		String mensagem = null;
		try {
			Verificadora.valorMenorQueZero(null, "Valor não pode ser nulo");
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor não pode ser nulo", mensagem);
	}
	
}
