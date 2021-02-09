package javaregular;

public class TestException {
	public static void main(String[] args) {
		try {
			int a = 0;
			System.out.println("a =" + a);
			int b = 20 / a;
			System.out.println("Division done.");
			System.out.println("b=" + b);
		} catch(ArithmeticException e) {
			System.out.println("Divide by zero error");
		} finally {
			System.out.println("inside the finally block");
		}
		System.out.println("after the finally block");
//		try {
//
//		} catch (Exception e) {
//
////		} catch (ArrayIndexOutOfBoundsException e) {
////
////		}
	}
}