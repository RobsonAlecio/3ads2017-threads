package threads.tipo2.semtravar;

import java.util.concurrent.ExecutorService;

public class Contador implements Runnable {
	
	private int inicio;
	private int fim;
	private int incremento;
	private int fatorSeparacao;
	private String nome;
	private ExecutorService threadPool;

	public Contador(int inicio, int fim, int incremento, int fatorSeparacao, String nome, ExecutorService threadPool) {
		super();
		this.inicio = inicio;
		this.fim = fim;
		this.incremento = incremento;
		this.fatorSeparacao = fatorSeparacao;
		this.nome = nome;
		this.threadPool = threadPool;
	}

	@Override
	public void run() {
		for (int i = inicio; i < fim; i = i + incremento) {
			System.out.printf("%s-%d -> %d\t", nome, fatorSeparacao, i);
			
			if (i % 20 == 0)
				System.out.println();
		}

		int quantidade = fim - inicio;
		int porcaoPorFaixa = quantidade / fatorSeparacao;
		int restante = quantidade % fatorSeparacao;
		
		int inicioDelegacao;
		int fimDelegacao;
		for (int i = 0; i < fatorSeparacao; i++) {
			inicioDelegacao = inicio + (porcaoPorFaixa * i);
			fimDelegacao = inicioDelegacao + porcaoPorFaixa;
			Contador subContador = new Contador(inicioDelegacao, fimDelegacao, incremento, fatorSeparacao - 1, nome, threadPool);
			threadPool.submit(subContador);
		}
		
		if (restante != 0) {
			Contador subContador = new Contador(fim - restante, fim, incremento, fatorSeparacao - 1, nome, threadPool);
			threadPool.submit(subContador);
		}
	}

}
