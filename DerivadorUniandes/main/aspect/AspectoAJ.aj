package main.aspect;

public aspect AspectoAJ {
	pointcut metodoBar(): execution(* bar(int));

	before(): metodoBar() {
		System.out.printf("Advice antes de m�todo \n", thisJoinPoint.getSignature());
	}

	after(): metodoBar() {
		System.out.printf("Advice despu�s de m�todo \n", thisJoinPoint.getSignature());
	}
}