package aspectos;

public aspect MailerTaller3 {

	pointcut sendMail() : execution(* calcularPago(..));
	
	double around(): sendMail() {
		SendMailTLSTaller3 mailer = new SendMailTLSTaller3();
		System.out.printf("Dentro de calcularPago\n");
		double original_return_value = proceed();
		System.out.println(original_return_value);
		if (original_return_value > 2000000){
			mailer.send("El impuesto es: "+original_return_value);
		}
		return original_return_value;
	}
}
