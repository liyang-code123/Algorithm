package javaregular;

public class Singleton {
	private static final Singleton instance = new Singleton();
	private String name;
	private Singleton() {
		this.name = "John";
	}
	public static Singleton getInstance() {
		return instance;
	}
	
	public static void main (String[] args) {
		Singleton c1 = Singleton.getInstance();
		Singleton c2 = Singleton.getInstance();
		System.out.println(c1 == c2);
	}
}
