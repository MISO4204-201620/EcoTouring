package uniandes.fabricasw.ecotouring.core;

public class Categories implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	Category name;
	int size;

	public Categories(Category name, int size) {
		this.name = name;
		this.size = size;
	}

	public Category getName() {
		return name;
	}

	public void setName(Category name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
