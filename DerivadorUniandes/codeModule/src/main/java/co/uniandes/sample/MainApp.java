package co.uniandes.sample; 

public class MainApp {

	public void foo(String name) {
		System.out.println("Entra a foo(String) " + name);
	}

	public void bar(int value) {
		System.out.println("Entra a bar(int) " + value);
	}

	public static void main(String[] args) {
		MainApp app = new MainApp();
		app.foo("Hello World");
		app.bar(1);
	}

}