package com.db1.contacorrente;

import java.util.ArrayList;
import java.util.List;

import com.db1.contacorrente.infra.Verificadora;

// Comportamentos
// Depositar
// Sacar
// Criar conta
// Saldo

public class ContaCorrente {

	private Double saldo;
	
	private String cliente;
	
	private String agencia;
	
	private String numero;
	
	private List<String> historico;

	public ContaCorrente(String agencia, String numero, String cliente) {

		Verificadora.verificaStringValida(agencia, "Informe uma agência válida.");
		Verificadora.verificaStringValida(numero, "Informe um número de conta válido.");
		Verificadora.verificaStringValida(cliente, "Informe um cliente válido.");

		this.agencia = agencia;
		this.numero = numero;
		this.cliente = cliente;
		this.saldo = 0.0;
		this.historico = new ArrayList<String>();

	}
	
	public void depositar(Double valor) {
		
		Verificadora.valorMaiorQueZero(valor, "Valor a ser depositado deve ser maior que zero");
		
		this.saldo += valor;
		this.historico.add("Depositado: R$ " + valor);
	}
	
	public void sacar(Double valor) {
		 
		Verificadora.valorMaiorQueZero(valor, "Valor a ser sacado deve ser maior que zero");
		Verificadora.valorMenorQueZero((this.saldo - valor), "Você não possui saldo suficiente para realizar o saque");
		
		this.saldo -= valor;
		this.historico.add("Sacado: R$ " + valor);
	}

	public String getAgencia() {
		return agencia;
	}

	public String getNumero() {
		return numero;
	}

	public String getCliente() {
		return cliente;
	}
	
	public List<String> getHistorico() {
		return historico;
	}
	
	public Double getSaldo() {
		return saldo;
	}

}
