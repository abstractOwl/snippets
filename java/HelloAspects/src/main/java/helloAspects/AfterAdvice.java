package helloAspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Advice run after a method call.
 */
@Component
@Aspect
public class AfterAdvice {
  private static final Logger LOGGER = LoggerFactory.getLogger(AfterAdvice.class);
  
  @After("execution(* *(..))")
  public void exiting(JoinPoint joinPoint) {
    LOGGER.trace("exiting {}", joinPoint.getSignature());
    
    for (Object arg : joinPoint.getArgs()) {
      LOGGER.trace("Arg: {}", arg);
    }
  }
}
