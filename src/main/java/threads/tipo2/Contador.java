package threads.tipo2;

public class Contador implements Runnable {
	
	private int inicio;
	private int fim;
	private int incremento;
	private int fatorSeparacao;

	public Contador(int inicio, int fim, int incremento, int fatorSeparacao) {
		super();
		this.inicio = inicio;
		this.fim = fim;
		this.incremento = incremento;
		this.fatorSeparacao = fatorSeparacao;
	}

	@Override
	public void run() {
		if (fatorSeparacao == 0) {
			for (int i = inicio; i < fim; i = i + incremento) {
				System.out.println(i);
			}
		} else {
			int quantidade = fim - inicio;
			int porcaoPorFaixa = quantidade / fatorSeparacao;
			int restante = quantidade % fatorSeparacao;
			
			int inicioDelegacao;
			int fimDelegacao;
			for (int i = 0; i < fatorSeparacao; i++) {
				inicioDelegacao = inicio + (porcaoPorFaixa * i);
				fimDelegacao = inicioDelegacao + porcaoPorFaixa;
				new Thread( new Contador(inicioDelegacao, fimDelegacao, incremento, fatorSeparacao - 1)).start();
			}
			
			if (restante != 0)
				new Thread( new Contador(fim - restante, fim, incremento, fatorSeparacao - 1)).start();
		}
	}

}
