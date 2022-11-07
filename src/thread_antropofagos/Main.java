package thread_antropofagos;

public class Main {

	public static void main(String[] args) {

		System.out.println("START");

		// Configuracion
		final int n = 8; // Cantidad de misioneros en la olla y de salvajes

		Olla olla = new Olla(n);

		Thread tCocinero = new Thread(new Cocinero(olla));
		tCocinero.start();

		for (int i = 0; i < n; i++) {
			Thread tSalvaje = new Thread(new Salvaje(olla), "Salvaje-" + i);
			tSalvaje.start();
		}
	}

}
