package main.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectoAnotacion {

	@Pointcut("execution(* createAJ*(..))")
	public void notificacion() {
	}

	@AfterReturning("notificacion()")
	public void despuesPunto(JoinPoint joinPoint) {
		System.out.println("\t\t***");
		System.out.println("Advice @AfterReturning de createAJ");
		System.out.println("\t\t***");
		/*messageDAO.create(new Message("Notificaci�n Sistema",
				"Se realiz� una operaci�n sobre el item" + i.get().getName(),
				i.get().getSupplier(), i.get().getSupplier(), new Date(),
				MessageStatus.UNREAD));*/
	}
}