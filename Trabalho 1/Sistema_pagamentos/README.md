# Sistema de Pagamentos (Trabalho 1)

Autor: **João Paulo**  
Disciplina: Programação 3 (Java)  
Data: Dezembro/2025

## Objetivo acadêmico

Este trabalho implementa um **sistema simples de pagamentos** em Java, com foco em **POO** (classes, herança e polimorfismo) e **simulação de operações financeiras**.

O programa permite:

- **Criar contas correntes** identificadas por CPF.
- **Consultar e alterar saldo** (depósito).
- **Realizar pagamentos entre contas** usando diferentes meios:
	- **PIX**: transferência imediata entre contas.
	- **Boleto**: transferência simulando pagamento (mesma lógica de débito/crédito).
	- **Cartão de crédito**: compra no crédito com **parcelamento** e controle de **limite**, além de pagamento de fatura/parcelas com saldo da conta.

## Estrutura técnica

O projeto está organizado em dois pacotes:

- `contabancarias`
	- `ContaCorrente`: representa uma conta com `cpf` e `saldo`.

- `pagamentos`
	- `pagamento` (classe abstrata): define a base comum dos pagamentos e o método `processar(...)`.
	- `pagamento_pix`: implementa transferência PIX (debita remetente e credita destinatário).
	- `pagamento_boleto`: implementa pagamento via boleto (debita remetente e credita destinatário).
	- `pagamento_cartao`: simula cartão de crédito com:
		- lista de `parcelas` (fatura aberta)
		- `limiteCartao` e `limiteDisponivel`
		- compra no crédito (usa limite e credita destinatário)
		- pagamento de parcela/fatura usando saldo da conta

## Funcionamento do programa (menu)

A execução acontece via console, com dois menus principais:

1. **Contas bancárias**
	 - Criar conta
	 - Listar contas
	 - Consultar saldo
	 - Depositar

2. **Pagamentos**
	 - PIX entre contas
	 - Boleto entre contas
	 - Cartão: compra no crédito (gera parcelas e usa limite)
	 - Cartão: ver fatura
	 - Cartão: pagar parcela
	 - Cartão: pagar fatura completa
	 - Cartão: definir limite

## Como compilar e executar (Windows / PowerShell)

Na pasta do trabalho:

```powershell
cd "c:\Users\GATO ROXO\Downloads\Semestre 2025_2\Progamacao_3\Trabalho 1\Sistema_pagamentos"
javac -d bin (Get-ChildItem -Recurse -Filter *.java -Path src | ForEach-Object FullName)
java -cp bin pagamentos.App
```

## Observações

- O CPF é validado apenas pelo formato (**11 dígitos numéricos**).
- PIX e boleto exigem saldo suficiente no remetente.
- Cartão de crédito não debita saldo na compra; ele compromete `limiteDisponivel` e cria parcelas na fatura.
- Pagamento de parcela/fatura do cartão debita saldo da conta do cliente e libera limite novamente.
