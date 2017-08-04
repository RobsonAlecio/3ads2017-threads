package threads.tipo2;

public class Run {
	
	public static void main(String[] args) {
		Contador contador1 = new Contador(1, 1_000_000, 1, 10);
		Contador contador2 = new Contador(1, -1_000_000, -1, 5);
		
		new Thread(contador1, "contador1-fator-1").start();
		new Thread(contador2, "contador2-fator--1").start();
	}

}
