import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DerivadorEcotouring {

	public static void main(String[] args) {
		try {
			List<String> features = cargarConfig("data/producto.conf");
			derivarProducto(features);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void derivarProducto(List<String> features) {
		for (String element : features) {
			derivar(element);
		}

	}

	private static void derivar(String feature) {

		//Maven: pom.xml
		if (feature.equals("CORE")) {
			// Weaver weaver = new AspectJWeaver();
			// aspectj.weave(b);
			System.out.println("Se incluyó CORE");
		}
		
		//Condición sobre constante
		if (feature.equals("FEATURE1")) {
			// patron decorador abrir set= true
			// escribir una propiedad en un archivo .properties
			System.out.println("Se incluyó FEATURE1");
		}
		
		//Aspecto
		if (feature.equals("FEARURE2")) {
			// abrir
			// add
			// write
			// jaxb agregar dependency en el pom
			System.out.println("Se incluyó FEARURE2");
		}
		
		//Patrón decorador
		if (feature.equals("FEARURE3")) {
			System.out.println("Se incluyó FEARURE3");
		}		
		
		//Reemplazo de binario
		if (feature.equals("FEARURE4")) {
			System.out.println("Se incluyó FEARURE4");
		}		
	}

	private static List<String> cargarConfig(String archivo) throws Exception {
		List<String> features = new ArrayList<String>();
		String texto;
		BufferedReader lector;
		try {
			File datos = new File(archivo);
			lector = new BufferedReader(new FileReader(datos));
			texto = lector.readLine();
		} catch (Exception e) {
			throw new Exception("Error al cargar los datos de configuración");
		}

		while (texto != null) {
			features.add(texto);
			try {
				texto = lector.readLine();
			} catch (Exception e) {
				System.out.println("Error al cargar los datos de configuración");
			}
		}
		lector.close();
		return features;
	}

}
