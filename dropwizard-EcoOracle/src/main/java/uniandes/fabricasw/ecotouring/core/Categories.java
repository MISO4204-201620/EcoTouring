package uniandes.fabricasw.ecotouring.core;

public class Categories implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	String name;
	int size;
	
	public Categories(String name, int size) {
		this.name = name;
		this.size = size;
	}	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
}
