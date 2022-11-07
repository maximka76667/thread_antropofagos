package thread_antropofagos;

public class Cocinero implements Runnable {

	protected Olla olla;

	public Cocinero(Olla olla) {
		this.olla = olla;
	}

	@Override
	public void run() {
		while (true) {
			try {
				olla.cocinar();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
