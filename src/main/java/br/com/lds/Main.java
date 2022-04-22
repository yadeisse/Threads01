package br.com.lds;

import br.com.lds.models.Caminhao;

public class Main {

	public static void main(String[] args) {

		Main app = new Main();
		app.start();

	}

	private void start() {

		Caminhao primeiroCaminhao = new Caminhao("Tiburssuslog", 2);
		Caminhao segundoCaminhao = new Caminhao("Arolduslog", 1);

		Thread threadPrimeiroCaminhao = new Thread(primeiroCaminhao);
		Thread threadSegundoCaminhao = new Thread(segundoCaminhao);

		threadPrimeiroCaminhao.start();
		threadSegundoCaminhao.start();

		System.out.println(
				"A aplicacao ja esta livre para trabalhar em outras coisas caso necessario enquanto as threads estao trabalhando");

	}

}
