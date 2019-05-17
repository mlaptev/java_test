package ru.stqa;

public class Point2 {

    public double x;
    public double y;

    public Point2(double x, double y) {
        this.x = x;
        this.y = y;

    }
    public double distance(Point p2) {
        return Math.sqrt(((p2.x- this.x) * (p2.x - this.x)) + ((p2.y - this.y) * (p2.y - this.y)));
    }

    public static void main(String[] args) {

        Square2 s = new Square2(5);
        System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

        Rectangle r = new Rectangle(1, 1);
        System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

        Point p = new Point( 3, 3);
        System.out.println("Координаты точек = " + p.x + " и " +  p.y);

        Point p1 = new Point(5, 5);
        Point p2 = new Point(3, 3);

        System.out.println("p1 = " + p1.x + ", " + p1.y);
        System.out.println("p2 = " + p2.x + ", " + p2.y);
        System.out.println("Расстояние между двумя точками = " + p1.distance(p2));





    }


    }







