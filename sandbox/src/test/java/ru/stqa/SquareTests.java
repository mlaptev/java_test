package ru.stqa;

//import org.testing.annotations.Test;

public class SquareTests {


 //   @Test


    public void testArea() {
      Square2 s = new Square2(5);
      assert s.area() == 25;

    }
}
