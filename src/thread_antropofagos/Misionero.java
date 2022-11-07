package thread_antropofagos;

public class Misionero {

	protected int id;

	public Misionero(int i) {
		this.id = i;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Misionero-" + id;
	}

}
