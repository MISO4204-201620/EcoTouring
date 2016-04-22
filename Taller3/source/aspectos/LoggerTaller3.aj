package aspectos;

public aspect LoggerTaller3 {

	//Interceptar todos los métodos públicos del paquete 
	//package uniandes.cupi2.impuestosCarro.mundo;
	
	pointcut logger(): call(* uniandes.cupi2.impuestosCarro.mundo..*(..));

	before(): logger() {
		System.out.printf("In\n");
		System.out.printf("\t Signature\t\t %s. \n", thisJoinPointStaticPart.getSignature());
		System.out.printf("\t Target\t\t\t %s. \n", thisJoinPoint.getTarget());
		
		Object[] arguments = thisJoinPoint.getArgs();
	    for (int i =0; i < arguments.length; i++){
	        Object argument = arguments[i];
	        if (argument != null){
	            System.out.printf("\t *Argument type\t\t %s \n",argument.getClass().toString());
	            System.out.printf("\t *Argument value\t %s \n",argument.toString());
	        }
	    }
	    System.out.printf("Out\n\n");		
	}
	
	after() returning(Object r): logger(){
		if (r != null){
			System.out.printf("After-return %s. \n\n",r.getClass().toString());
		}
	}
	
	after() throwing(Throwable e): logger(){
		if (e != null){
			System.out.printf("After-exception %s. \n\n",e.getClass().toString());
		}
	}
}
