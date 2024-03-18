public class main {

	public static void main(String[] args) throws InterruptedException {
		
		Barbearia barbearia = new Barbearia();
		new Thread(barbearia).start();
		Thread.sleep(500);
		
		Cliente cliente = new Cliente();
		for(int i = 0; i < 4; i++) {
			new Thread(cliente).start();
//			Thread.sleep(1000);
		}		
	}

}
