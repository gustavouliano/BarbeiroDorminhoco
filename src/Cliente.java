public class Cliente implements Runnable {

	@Override
	public void run() {
		Barbearia.mutex.lock();
		System.out.println("Cliente " + Thread.currentThread().getName() + " entra na barbearia.");
		// Se houver cadeiras vagas...
		if (Barbearia.esperando < Barbearia.cadeiras) {
			Barbearia.esperando++;	
			Barbearia.clienteSemaforo.release();
			Barbearia.mutex.unlock();
			try {
				Barbearia.barbeiroSemaforo.acquire();
				System.out.println("Cliente " + Thread.currentThread().getName() + " deixa a barbearia.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("-> Cliente " + Thread.currentThread().getName() + " saiu sem cortar o cabelo.");
			Barbearia.mutex.unlock();
		}
	}
	
	
}
