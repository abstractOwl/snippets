package helloAspects;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Advice run after a method throws an exception.
 */
@Component
@Aspect
public class AfterThrowingAdvice {
  private static final Logger LOGGER = LoggerFactory.getLogger(AfterThrowingAdvice.class);
  
  @AfterThrowing(pointcut = "execution(* *(..))", throwing = "ex")
  public void logException(RuntimeException ex) {
    LOGGER.error("Exception {}", ex.getMessage());
  }
}
