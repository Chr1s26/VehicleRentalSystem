package Model;

public class Customer {

	private String name;
	private int id;
	private static int count = 1;
	
	public Customer(int id, String name) {
		this.name = name;
		this.id = id;
	}
	
	public Customer(String name) {
		this.name = name;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
