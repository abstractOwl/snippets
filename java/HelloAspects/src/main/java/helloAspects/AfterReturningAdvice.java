package helloAspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Advice run after a method returns a value.
 */
@Component
@Aspect
public class AfterReturningAdvice {
  private static final Logger LOGGER = LoggerFactory.getLogger(AfterReturningAdvice.class);

  @AfterReturning(pointcut = "execution(* *(..))", returning = "result")
  public void logResult(String result) {
    LOGGER.trace("returns {}", result);
  }
}
