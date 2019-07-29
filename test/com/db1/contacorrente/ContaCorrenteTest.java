package com.db1.contacorrente;

import org.junit.Assert;
import org.junit.Test;

public class ContaCorrenteTest {

	@Test
	public void deveRetornarErroQuandoInformadoAgenciaInvalida() {

		String mensagem = null;

		try {
			ContaCorrente contaCorrente = new ContaCorrente(null, "000987654321", "Filipe Moreno");
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}

		Assert.assertNotNull(mensagem);
		Assert.assertEquals("Informe uma agência válida.", mensagem);
	}

	@Test
	public void deveRetornarErroQuandoInformadoNumeroInvalida() {

		String mensagem = null;

		try {
			ContaCorrente contaCorrente = new ContaCorrente("000987", null, "Filipe Moreno");
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}

		Assert.assertNotNull(mensagem);
		Assert.assertEquals("Informe um número de conta válido.", mensagem);
	}

	@Test
	public void deveRetornarErroQuandoInformadoClienteInvalida() {

		String mensagem = null;

		try {
			ContaCorrente contaCorrente = new ContaCorrente("000987", "00000345", null);
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}

		Assert.assertNotNull(mensagem);
		Assert.assertEquals("Informe um cliente válido.", mensagem);
	}
	
	@Test
	public void deveCriarContaCorrenteComValoresValidos() {
		ContaCorrente contaCorrente = new ContaCorrente("000123", "0000012345", "Filipe Moreno");
		Assert.assertEquals("000123", contaCorrente.getAgencia());
		Assert.assertEquals("0000012345", contaCorrente.getNumero());
		Assert.assertEquals("Filipe Moreno", contaCorrente.getCliente());
		Assert.assertEquals(0.0, contaCorrente.getSaldo(), 0);
		Assert.assertEquals(0, contaCorrente.getHistorico().size());
		
	}
	
	@Test
	public void deveRetornarExecaoQuandoValorDepositadoInvalido() {
		ContaCorrente contaCorrente = new ContaCorrente("000123", "0000012345", "Filipe Moreno");
		String mensagem = null;
		try {
			contaCorrente.depositar(-0.01);
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor a ser depositado deve ser maior que zero", mensagem);
		Assert.assertEquals(0.0, contaCorrente.getSaldo(), 0.0001);
		Assert.assertEquals(0, contaCorrente.getHistorico().size());
	}
	
	@Test
	public void deveRetornarExecaoQuandoValorDepositadoForZero() {
		ContaCorrente contaCorrente = new ContaCorrente("000123", "0000012345", "Filipe Moreno");
		String mensagem = null;
		try {
			contaCorrente.depositar(0.0);
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor a ser depositado deve ser maior que zero", mensagem);
		Assert.assertEquals(0.0, contaCorrente.getSaldo(), 0.0001);
		Assert.assertEquals(0, contaCorrente.getHistorico().size());
	}
	
	@Test
	public void deveRetornarExecaoQuandoValorDepositadoForNull() {
		ContaCorrente contaCorrente = new ContaCorrente("000123", "0000012345", "Filipe Moreno");
		String mensagem = null;
		try {
			contaCorrente.depositar(null);
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor a ser depositado deve ser maior que zero", mensagem);
		Assert.assertEquals(0.0, contaCorrente.getSaldo(), 0.0001);
		Assert.assertEquals(0, contaCorrente.getHistorico().size());
	}
	
	@Test
	public void deveDepositarValor() {
		ContaCorrente contaCorrente = new ContaCorrente("000123", "0000012345", "Filipe Moreno");
		contaCorrente.depositar(100.0);
		
		Assert.assertEquals(100.0, contaCorrente.getSaldo(), 0.0001);
		Assert.assertEquals("Depositado: R$ 100.0", contaCorrente.getHistorico().get(0));
	}
	
	@Test
	public void deveRetornarExecaoQuandoValorSacadoForZero() {
		ContaCorrente contaCorrente = new ContaCorrente("000123", "0000012345", "Filipe Moreno");
		String mensagem = null;
		try {
			contaCorrente.sacar(0.0);
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor a ser sacado deve ser maior que zero", mensagem);
		Assert.assertEquals(0.0, contaCorrente.getSaldo(), 0.0);
		Assert.assertEquals(0, contaCorrente.getHistorico().size());
	}
	
	@Test
	public void deveRetornarExecaoQuandoValorSacadoForInvalido() {
		ContaCorrente contaCorrente = new ContaCorrente("000123", "0000012345", "Filipe Moreno");
		String mensagem = null;
		try {
			contaCorrente.sacar(-0.01);
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor a ser sacado deve ser maior que zero", mensagem);
		Assert.assertEquals(0.0, contaCorrente.getSaldo(), 0.0);
		Assert.assertEquals(0, contaCorrente.getHistorico().size());
	}
	
	@Test
	public void deveRetornarExecaoQuandoValorSacadoForNull() {
		ContaCorrente contaCorrente = new ContaCorrente("000123", "0000012345", "Filipe Moreno");
		String mensagem = null;
		try {
			contaCorrente.sacar(null);
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor a ser sacado deve ser maior que zero", mensagem);
		Assert.assertEquals(0.0, contaCorrente.getSaldo(), 0.0);
		Assert.assertEquals(0, contaCorrente.getHistorico().size());
	}
	
	@Test
	public void deveRetornarExecaoQuandoValorSacadoForMaiorSaldo() {
		ContaCorrente contaCorrente = new ContaCorrente("000123", "0000012345", "Filipe Moreno");
		String mensagem = null;
		try {
			contaCorrente.depositar(5.0);
			contaCorrente.sacar(10.0);
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Você não possui saldo suficiente para realizar o saque", mensagem);
		Assert.assertEquals(5.0, contaCorrente.getSaldo(), 0.0);
		Assert.assertEquals(1, contaCorrente.getHistorico().size());
	}
	
	@Test
	public void deveSacarValor() {
		ContaCorrente contaCorrente = new ContaCorrente("000123", "0000012345", "Filipe Moreno");
		contaCorrente.depositar(100.0);
		contaCorrente.sacar(10.0);
		
		Assert.assertEquals(90.0, contaCorrente.getSaldo(), 0.0001);
		Assert.assertEquals("Sacado: R$ 10.0", contaCorrente.getHistorico().get(1));
	}
	
	

}
