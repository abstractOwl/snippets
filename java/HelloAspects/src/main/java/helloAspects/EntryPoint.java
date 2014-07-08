package helloAspects;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Driver class for HelloAspects.
 */
public class EntryPoint {
  public static void main(String args[]) {
    @SuppressWarnings("resource") // Suppress "Resource never closed" warning for example 
    ApplicationContext context = new ClassPathXmlApplicationContext("/application-context.xml");
    
    HelloAspects helloAspects = (HelloAspects) context.getBean("helloAspects");

    helloAspects.sayHello();
    helloAspects.returnsString();
    
    try {
      helloAspects.throwException();
    } catch (RuntimeException ex) {
      // Swallow exception, don't print stacktrace
    }
  }
}
