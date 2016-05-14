package main.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectoAnotacion {

	@Pointcut("execution(* foo(String))")
	public void puntoCorte() {
	}

	@Before("puntoCorte()")
	public void antesPunto(JoinPoint joinPoint) {
		System.out.println("Advice antes de foo");
	}

	@After("puntoCorte()")
	public void despuesPunto(JoinPoint joinPoint) {
		System.out.println("Advice después de foo");
	}
}