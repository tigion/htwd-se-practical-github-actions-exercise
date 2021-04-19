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
			throw new RuntimeException("Exception: empty String or null value");
		else
			this.name = name;
	}

	public void setResidents(int residents) {
		this.residents = residents;
	}

	public String toString() {
		return "Name: " + this.name + ", Residents: " + this.residents;
	}

	public static void main(String[] args) {
		Town t = new Town("Dresden", 11);
		System.out.println(t.toString());
		t.setResidents(12);
		System.out.println(t.getName());
		System.out.println(t.getResidents());
	}

}
