package thread_antropofagos;

import java.util.ArrayList;

public class Olla {

	ArrayList<Misionero> misioneros;
	int SIZE;

	public void rellenar() {
		for (int i = 0; i < this.SIZE; i++) {
			misioneros.add(new Misionero(i));
		}
		System.out.println("El cocinero rellenó la olla");
	}

	public Olla(int n) {
		misioneros = new ArrayList<Misionero>();
		this.SIZE = n;
		rellenar();
	}

	public void cocinar() throws InterruptedException {
		synchronized (this) {
			while (!getEstaVacia()) {
				wait();
			}
			System.out.println("El cocinero está cocinando...");
			Thread.sleep(5000);
			rellenar();
			notifyAll();
		}
	}

	public void comer() throws InterruptedException {
		Thread.sleep(1);
		synchronized (this) {
			while (getEstaVacia()) {
				System.out.println("La olla está vacia");
				wait();
			}
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " ha comido " + misioneros.remove(0));
			notifyAll();
		}
	}

	public boolean getEstaVacia() {
		return misioneros.size() <= 0;
	}
}
