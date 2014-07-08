package helloAspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Advice run on methods annotated with a specified annotation.
 */
@Component
@Aspect
public class AnnotationAdvice {
  private static final Logger LOGGER = LoggerFactory.getLogger(AnnotationAdvice.class);
  
  @Before("execution(@helloAspects.util.Annotation * *(..))")
  public void logAnnotation(JoinPoint joinPoint) {
    LOGGER.trace("{} is annotated", joinPoint.getStaticPart().getSignature());
  }
}
