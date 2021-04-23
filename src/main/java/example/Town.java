package example;

public class Town {

	private String name;
	private int residents;

	public Town(String name, int residents) {
		this.setName(name);
		this.setResidents(residents);
	}

	public String getName() {
		return this.name;
	}

	public int getResidents() {
		return this.residents;
	}

	public void setName(String name) {
		if (name == null || name.isBlank())
			throw new IllegalArgumentException("name cannot be null, empty or contain only spaces");
		this.name = name;
	}

	public void setResidents(int residents) {
		this.residents = residents;
	}

	@Override
	public String toString() {
		return "Town [name=" + name + ", residents=" + residents + "]";
	}

}
