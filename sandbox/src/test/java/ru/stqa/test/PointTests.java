package ru.stqa.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.Point;


public class PointTests {

    @Test
    public void testArea() {

        Point p1 = new Point(2, 0);
        Point p2 = new Point(8, 0);
        double distance = p2.distance(p1);
        Assert.assertEquals(distance, 6.0);

    }

    @Test
    public void testArea2() {

        Point p3 = new Point(1, 0);
        Point p4 = new Point(8, 0);
        double distance = p4.distance(p3);
        Assert.assertNotEquals(distance, 8.0, "Дистанция не корректная");
    }

}