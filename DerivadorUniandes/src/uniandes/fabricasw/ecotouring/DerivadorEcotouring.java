package uniandes.fabricasw.ecotouring;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.model.io.xpp3.MavenXpp3Writer;
import org.codehaus.plexus.util.WriterFactory;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

public class DerivadorEcotouring {

	public static void main(String[] args) {
		try {
			List<String> features = cargarConfig("data/producto.conf");
			derivarProducto(features);
		} catch (Exception e) {
			e.printStackTrace();
		}

		File pomfile = new File("data/pom.xml");
		Model model;
		try {
			// Properties
			Properties prop = new Properties();
			prop.put("test", "true");

			// Dependency
			Dependency dep = new Dependency();
			dep.setGroupId("org.aspectj");
			dep.setArtifactId("aspectjrt");
			dep.setVersion("1.8.9");

			// Edit Pom
			model = loadPom(pomfile);
			model.setProperties(prop);
			model.addDependency(dep);
			writePom(pomfile, model);
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

		// Maven: pom.xml
		if (feature.equals("CORE")) {
			// Weaver weaver = new AspectJWeaver();
			// aspectj.weave(b);
			System.out.println("Se incluyo CORE");
		}

		// Condicion sobre constante
		if (feature.equals("FEATURE1")) {
			// patron decorador abrir set= true
			// escribir una propiedad en un archivo .properties
			System.out.println("Se incluyo FEATURE1");
		}

		// Aspecto
		if (feature.equals("FEARURE2")) {
			// abrir
			// add
			// write
			// jaxb agregar dependency en el pom
			System.out.println("Se incluyo FEARURE2");
		}

		// Patron decorador
		if (feature.equals("FEARURE3")) {
			System.out.println("Se incluyo FEARURE3");
		}

		// Reemplazo de binario
		if (feature.equals("FEARURE4")) {
			System.out.println("Se incluyo FEARURE4");
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
			throw new Exception("Error al cargar los datos de configuracion");
		}

		while (texto != null) {
			features.add(texto);
			try {
				texto = lector.readLine();
			} catch (Exception e) {
				System.out.println("Error al cargar los datos de configuracion");
			}
		}
		lector.close();
		return features;
	}

	public static Model loadPom(File pomfile) throws IOException, XmlPullParserException {
		FileReader reader = null;
		MavenXpp3Reader mavenreader = new MavenXpp3Reader();
		reader = new FileReader(pomfile);
		Model model = mavenreader.read(reader);
		model.setPomFile(pomfile);
		return model;
	}

	public static void writePom(File pomfile, Model model) throws IOException {
		MavenXpp3Writer mavenXpp3Writer = new MavenXpp3Writer();
		Writer fileWriter = null;
		fileWriter = WriterFactory.newXmlWriter(pomfile);
		mavenXpp3Writer.write(fileWriter, model);
	}

}
