package ru.stqa;

import ru.stqa.test.Square;


public class MyFirstProgram {

	public static void main(String[] args) {
		hello("world");
		hello("user");
		hello("Test");

		Square s = new Square(5);
		System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

		Rectangle r = new Rectangle(4, 6);
		System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());
	}
		public static void hello (String somebody){
			System.out.println("Hello, " + somebody + "!");
			System.out.println("2 + 2 = " + (2 + 2));


			Point p1 = new Point(2, 0);
			Point p2 = new Point(8, 0);
			double distance = p2.distance(p1);

			System.out.println("Координаты точки p1 = " + p1.x + ", " + p1.y);
			System.out.println("Координаты точки p2 = " + p2.x + ", " + p2.y);
			System.out.println("Расстояние между двумя точками = " + p1.distance(p2));

		}

		public static double distance (Point p1, Point p2){
			double dx = p2.x - p1.x;
			double dy = p2.y - p1.y;
			return Math.sqrt(dx * dx + dy * dy);
		}

		public static double area ( Rectangle r){
			return r.a * r.b;

		}

	}


