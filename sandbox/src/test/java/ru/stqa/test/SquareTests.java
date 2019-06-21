package ru.stqa.test;

import org.junit.Test;

public class SquareTests {

    @Test

    public void testArea() {
      Square s = new Square(5);
      assert s.area() = 25;


    }
}
