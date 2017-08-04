package threads.tipo2.semtravar;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run {
	
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(5);
		
		Contador contador1 = new Contador(1, 10, 1, 2, "cara", threadPool);
//		Contador contador2 = new Contador(1, -100, -1, 5, "maneiro", threadPool);
		
		threadPool.submit(contador1);
//		threadPool.submit(contador2);
		
		threadPool.shutdown();
	}

}
