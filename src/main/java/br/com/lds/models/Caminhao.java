package br.com.lds.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Caminhao implements Runnable {

	public Caminhao(String nome, int intervalo) {

		this.nome = nome;
		this.intervalo = intervalo;

	}

	private String nome;
	private int intervalo;

	private final int NUMERO_DE_CAIXAS = 4;

	private Map<Integer, Integer> limiteDeCadaCaixa = new HashMap<Integer, Integer>();

	private Map<Integer, ArrayList<Integer>> caixaDePaes = new HashMap<Integer, ArrayList<Integer>>();

	@Override
	public void run() {

		System.out.println("Caminhao" + this.nome + "comecou a ser carregado...");

		setarLimiteDeCadaCaixa();

		int numeroDaCaixaAtual = 1;
		while (numeroDaCaixaAtual <= NUMERO_DE_CAIXAS) {

			carregarCaminhao(numeroDaCaixaAtual);

			System.out.println(
					"A caixa " + numeroDaCaixaAtual + " do caminhao " + this.nome + " terminou de ser carregada");

			numeroDaCaixaAtual += 1;

		}

		System.out.println("caminhao " + nome + " terminou de ser carregado");

	}

	private int converterSegundosEmMili(int segundo) {

		return segundo * 1000;
	}

	private void carregarCaminhao(int numeroDaCaixa) {

		caixaDePaes.put(numeroDaCaixa, new ArrayList<Integer>());

		int capacidadeDaCaixa = limiteDeCadaCaixa.get(numeroDaCaixa);

		for (int i = 0; i < capacidadeDaCaixa; i++) {

			ArrayList<Integer> paes = caixaDePaes.get(numeroDaCaixa);
			paes.add(i);

			// caixaDePaes.get(numeroDaCaixa).add(i);

			try {

				Thread.sleep(converterSegundosEmMili(this.intervalo));

			} catch (InterruptedException e) {

				e.printStackTrace();
			}

			System.out.println(
					"O pao " + i + "foi inserido na caixa numero " + numeroDaCaixa + " no caminhao " + this.nome);

		}

	}

	private void setarLimiteDeCadaCaixa() {

		// chave: (numero da caixa) - valor: (numero de paes)
		limiteDeCadaCaixa.put(1, 4);
		limiteDeCadaCaixa.put(2, 2);
		limiteDeCadaCaixa.put(3, 5);
		limiteDeCadaCaixa.put(4, 6);

	}

}