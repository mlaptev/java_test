package ru.stqa.test;

import org.junit.Test;

public class SquareTests {


@Test
    public void testArea() {

      ru.stqa.test.Square s = new ru.stqa.test.Square(5);
      assert s.area() == 24;


    }
}
