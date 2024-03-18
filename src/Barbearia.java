import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Barbearia implements Runnable {
	
	public static Semaphore clienteSemaforo = new Semaphore(0);
	public static Semaphore barbeiroSemaforo = new Semaphore(0);
	public static ReentrantLock mutex = new ReentrantLock();
	public static int esperando = 0;
	public static int cadeiras = 2;
	
	@Override
	public void run(){
		while(true) {
			try {
				// Permanece dormindo pelo semáforo até que algum cliente apareça
				clienteSemaforo.acquire();
				Barbearia.esperando--;
				System.out.println("Barbeiro começa a cortar o cabelo...");
				Thread.sleep(2000);
				System.out.println("Barbeiro termina de cortar o cabelo...");
				barbeiroSemaforo.release();
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
