package co.edu.uniandes.fabricasw.derivator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.model.io.xpp3.MavenXpp3Writer;
import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.Invoker;
import org.apache.maven.shared.invoker.MavenInvocationException;
import org.aspectj.bridge.IMessage;
import org.aspectj.bridge.MessageHandler;
import org.aspectj.tools.ajc.Main;
import org.codehaus.plexus.util.WriterFactory;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

public class DerivadorEcotouring {

	public static void main(String[] args) {
		try {
			List<String> features = cargarConfig("data/default.config");
			derivarProducto(features);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void derivarProducto(List<String> features) {
		Properties properties = new Properties();
		File pomfileOrigen = new File("data/pom.xml");
		File pomfileDestino = new File("coreModule/pom.xml");
		Model model;
		try {
			model = loadPom(pomfileOrigen);
			for (String element : features) {
				if (element.startsWith("A")) {
					derivarPOM(element, model, properties);
				}
			}
			derivarFrontEnd(properties);
			derivarCore(model);
			writePom(pomfileDestino, model);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void derivarPOM(String feature, Model model, Properties properties) {
		System.out.println("Derivando \t" + feature);
		switch (feature) {
		case "ANotificaciones":
			derivarNotificaciones(model, properties);
		case "AMensajes":
			derivarMensajes(model, properties);
			break;
		case "ARegistrar":
			derivarRedesSociales(model, properties);
			break;
		case "AGestionarBlog":
			derivarBlog(model, properties);
			break;
		case "ACrearCalificacion":
			derivarCalificacion(model, properties);
			break;
		case "ACrearReportesProveedor":
			derivarRepores(model, properties);
			break;
		}
	}

	private static void derivarCore(Model model) {
		// Revisar el orden tal vez toque movel al final
		// Que genere el package
		System.out.println("Se incluyo el CORE");
	}

	// Aspectos
	private static void derivarNotificaciones(Model model, Properties properties) {
		// Weaver weaver = new AspectJWeaver();
		// aspectj.weave(b);
		// The AspectJ compiler API
		// https://eclipse.org/aspectj/doc/next/devguide/ajc-ref.html
		/*
		 * if (feature.equals("FEARURE2")) { String[] args = new String[2];
		 * args[0] = "HelloWorld.java"; args[1] = "Trace.java";
		 * aspectjWeaver(args); System.out.println("Se incluyo FEARURE2"); }
		 */
		System.out.println("Se incluyo Notificaciones");
	}

	// Patron
	private static void derivarRedesSociales(Model model, Properties properties) {
		// patron decorador abrir set= true
		// escribir una propiedad en un archivo .properties
		System.out.println("Se incluyo Redes Sociales");
	}

	// Dependencia
	private static void derivarBlog(Model model, Properties properties) {
		Dependency dep = new Dependency();
		dep.setGroupId("org.aspectj");
		dep.setArtifactId("aspectjrt");
		dep.setVersion("1.8.9");
		properties.setProperty("blog", "true");
		model.addProperty("blog", "true");
		System.out.println("Se incluyo Blog");
	}

	// Condicion sobre constante
	private static void derivarMensajes(Model model, Properties properties) {
		properties.setProperty("mensajes", "true");
		model.addProperty("mensajes", "true");
		System.out.println("Se incluyo mensajes");
	}

	// Condicion sobre constante
	private static void derivarCalificacion(Model model, Properties properties) {
		properties.setProperty("calificacion", "true");
		model.addProperty("calificacion", "true");
		System.out.println("Se incluyo Calificación");
	}

	// Condicion sobre constante
	private static void derivarRepores(Model model, Properties properties) {
		properties.setProperty("reportes", "true");
		model.addProperty("reportes", "true");
		System.out.println("Se incluyo Reportes");
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

	public static void aspectjWeaver(String[] args) {
		Main compiler = new Main();
		MessageHandler m = new MessageHandler();
		compiler.run(args, m);
		IMessage[] ms = m.getMessages(null, true);
		System.out.println("messages: " + Arrays.asList(ms));
	}

	public static void buildProduct() {
		InvocationRequest request = new DefaultInvocationRequest();
		request.setPomFile(new File("/data/pom.xml"));
		request.setGoals(Collections.singletonList("package"));
		Invoker invoker = new DefaultInvoker();
		invoker.setMavenHome(new File("/usr"));
		try {
			invoker.execute(request);
		} catch (MavenInvocationException e) {
			e.printStackTrace();
		}
	}

	public static void derivarFrontEnd(Properties properties) {
		File featuresFile = new File("data/EcoTouringFeaturesConfig.ts");
		try {
			// Se establecen controladores de archivo
			FileOutputStream featuresFileStream = new FileOutputStream(featuresFile);
			OutputStreamWriter featuresFileStreamWriter = new OutputStreamWriter(featuresFileStream);
			BufferedWriter featuresFileWriter = new BufferedWriter(featuresFileStreamWriter);
			featuresFileWriter.write("export class EcoTouringFeaturesConfig {");
			featuresFileWriter.newLine();
			featuresFileWriter.newLine();
			// Se recorren los features para crear las propiedades de la clase
			for (String key : properties.stringPropertyNames()) {
				featuresFileWriter.write("	public " + key + " : boolean;");
				featuresFileWriter.newLine();
			}
			featuresFileWriter.newLine();
			featuresFileWriter.write("	constructor (){");
			featuresFileWriter.newLine();
			// Se recorren los features para inicializar las propiedades en el
			// constructor
			for (String key : properties.stringPropertyNames()) {
				String value = properties.getProperty(key);
				String state = "false";
				if (value.equals("true")) {
					state = "true";
				}
				featuresFileWriter.write("		this." + key + " = " + state + ";");
				featuresFileWriter.newLine();
			}
			featuresFileWriter.write("	}");
			featuresFileWriter.newLine();
			featuresFileWriter.write("}");
			featuresFileWriter.close();
		} catch (IOException e) {
			System.err.println("Error al generar el de configuración del front.");
		}
	}
}
