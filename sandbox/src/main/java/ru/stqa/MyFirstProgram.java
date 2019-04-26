package ru.stqa;

public class MyFirstProgram {
	
	public static void main(String[] args) {
		hello("world");
		hello("user");
		hello("Test");

		double l = 5;
		System.out.println("Площадь квадрата со стороной " + l + " = " + (l));
	}
	public static void hello (String somebody) {
		System.out.println("Hello, " + somebody + "!");
		System.out.println("2 + 2 = " + (2 + 2));
		double l = 8.0;
		double s = l * l;
		System.out.println("Площадь квадрата со стороной " + l + " = " + s);
	}
	
}