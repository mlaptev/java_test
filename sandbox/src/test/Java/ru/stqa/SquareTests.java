package ru.stqa;

//import org.testing.annotations.Test;

public class SquareTests {


 //   @Test


    public void testArea() {
      Square s = new Square(5);
      assert s.area() == 25;

    }
}
