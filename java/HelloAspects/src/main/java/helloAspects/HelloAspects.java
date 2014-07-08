package helloAspects;

import helloAspects.util.Annotation;

/**
 * Class containing methods to demonstrate AOP.
 */
public class HelloAspects {
  @Annotation
  public void sayHello() {
    System.out.println("Hello world!");
  }
  
  public String returnsString() {
    System.out.println("Returns foo");
    return "foo";
  }
  
  public void throwException() {
    throw new RuntimeException("A sample exception");
  }
}
