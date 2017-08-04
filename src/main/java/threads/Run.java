package threads;

public class Run {

	public static void main(String[] args) {
		Thread threadIncrementa = new Thread(new Runnable() {
			
			public void run() {
				for (int i = 1; i <= 1_000_000; i++) {
					System.out.print(i + " ");
					
					if (i % 30 == 0)
						System.out.println();
				}
			}
		});
		
		Thread threadDecrementa = new Thread(new Runnable() {
			
			public void run() {
				for (int i = 0; i >= -1_000_000; i--) {
					System.out.print(i + " ");

					if (i % 30 == 0)
						System.out.println();
				}
			}
		});
		
		threadIncrementa.start();
		threadDecrementa.start();
	}
	
}
