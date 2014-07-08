package helloAspects;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Advice run before a method call.
 */
@Component
@Aspect
public class BeforeAdvice {
  private static final Logger LOGGER = LoggerFactory.getLogger(BeforeAdvice.class);
  
  @Before("execution(* *(..))") // Wildcards: [return type, method name, parameters]
  public void entering(JoinPoint joinPoint) {
    LOGGER.trace("entering {}", joinPoint.getStaticPart().getSignature().toString());
  }
}
