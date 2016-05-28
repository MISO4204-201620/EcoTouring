package uniandes.fabricasw.ecotouring.aspects;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import com.google.common.base.Optional;

import uniandes.fabricasw.ecotouring.core.Item;
import uniandes.fabricasw.ecotouring.core.Message;
import uniandes.fabricasw.ecotouring.core.MessageStatus;
import uniandes.fabricasw.ecotouring.db.MessageDAO;

@Aspect
public class AspectoAnotacion {

	@Pointcut("execution(* createAJ*(..))")
	public void notificacion(Item i, MessageDAO messageDAO) {
	}

	@AfterReturning("notificacion()")
	public void despuesPunto(JoinPoint joinPoint, Optional<Item> i, MessageDAO messageDAO) {
		System.out.println("\t\t***");
		System.out.println("Advice @AfterReturning de createAJ");
		System.out.println("\t\t***");
		messageDAO.create(new Message("Notificacion Sistema",
				"Se realizo una operacion sobre el item" + i.get().getName(),
				i.get().getSupplier(), i.get().getSupplier(), new Date(),
				MessageStatus.UNREAD));
	}
}