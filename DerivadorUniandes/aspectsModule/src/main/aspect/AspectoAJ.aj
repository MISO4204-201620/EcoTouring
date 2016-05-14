package main.aspect;

public aspect AspectoAJ {
	pointcut metodoBar(): execution(* bar(int));

	before(): metodoBar() {
		System.out.printf("Advice antes de método \n", thisJoinPoint.getSignature());
	}

	after(): metodoBar() {
		System.out.printf("Advice después de método \n", thisJoinPoint.getSignature());
	}
}