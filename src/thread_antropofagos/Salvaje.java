package thread_antropofagos;

public class Salvaje implements Runnable {

	protected Olla olla;

	public Salvaje(Olla olla) {
		this.olla = olla;
	}

	@Override
	public void run() {
		while (true) {
			try {
				olla.comer();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
