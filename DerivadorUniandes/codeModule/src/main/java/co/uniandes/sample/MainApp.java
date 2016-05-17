package co.uniandes.sample; 

public class MainApp {

	public void createAJString(String name) {
		System.out.println("Entra a foo(String) " + name);
	}

	public void createAJint(int value) {
		System.out.println("Entra a bar(int) " + value);
	}

	public static void main(String[] args) {
		MainApp app = new MainApp();
		app.createAJString("Hello World");
		app.createAJint(1);
	}

}