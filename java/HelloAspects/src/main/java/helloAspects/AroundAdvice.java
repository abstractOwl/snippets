package helloAspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Advice run before and after a method call.
 */
@Component
@Aspect
public class AroundAdvice {
  private static final Logger LOGGER = LoggerFactory.getLogger(AroundAdvice.class);
  
  @Around("execution(* *(..))")
  public Object trace(ProceedingJoinPoint proceedingJoinPoint)
    throws Throwable {
    
    String methodSignature = proceedingJoinPoint.getStaticPart().getSignature().toString();
    LOGGER.trace("Entering {} ", methodSignature);
    
    try {
      return proceedingJoinPoint.proceed();
    } catch (Throwable ex) {
      LOGGER.error("Exception in {}", methodSignature, ex.getMessage());
      throw ex; // Propagate exception
    } finally {
      LOGGER.trace("Exiting {}", methodSignature);
    }
  }
}
