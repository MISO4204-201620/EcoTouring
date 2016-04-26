package aspectos;

import uniandes.cupi2.impuestosCarro.mundo.CalculadorImpuestos;

public aspect AddCarTaller3 {
	
	void around(CalculadorImpuestos calculadorImpuestos): execution(CalculadorImpuestos+.new(..)) && this(calculadorImpuestos) {
	    System.out.println(thisJoinPointStaticPart);
	    proceed(calculadorImpuestos);
	    try {
	    	//El método se cambió de privado a público
			calculadorImpuestos.cargarVehiculos( "data/vehiculosTaller3.txt" );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
