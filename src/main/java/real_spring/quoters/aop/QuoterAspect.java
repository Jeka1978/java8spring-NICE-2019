package real_spring.quoters.aop;

import lombok.SneakyThrows;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Aspect
@Component
public class QuoterAspect {

    @Before("execution(* real_spring..*.say*(..))")
    @Around("@annotation(Deprecated)")
    public void handleSayMethods(JoinPoint jp){
        String simpleName = jp.getTarget().getClass().getSimpleName();
        System.out.println("this is quote of "+simpleName);
    }

    @Around("execution(* real_spring..*.say*(..))")
    @SneakyThrows
    public Object handleSayMethods2(ProceedingJoinPoint jp){
        System.out.println(123);
        Object retVal = jp.proceed();
        System.out.println(456);
        return retVal;
    }





}
