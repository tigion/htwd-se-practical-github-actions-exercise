package example;

public class Main {

	public static void main(String[] args) {
		Town t = new Town("Dresden", 11);
		System.out.println(t.toString());
		t.setResidents(12);
		System.out.println(t.getName());
		System.out.println(t.getResidents());
	}

}
