package Model;

public class Customer {

	private String name;
	private int id;
	private static int count = 1;
	
	public Customer(String name) {
		this.name = name;
		this.id = count;
		this.count++;
	}

	public static int getCount() {
		return count;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", id=" + id + "]";
	}

}
