package uniandes.fabricasw.ecotouring;

import java.io.FileWriter;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import generated.And;
import generated.Feature;
import generated.FeatureModel;
import generated.ObjectFactory;
import generated.Struct;
import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtAnnotation;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtConstructor;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtNamedElement;

public class FeatureProcessor extends AbstractProcessor<CtAnnotation<?>> {
	ObjectFactory factory;
	FeatureModel fm;
	Struct struct;

	@Override
	public void init() {
		factory = new ObjectFactory();
		fm = factory.createFeatureModel();
		struct = factory.createStruct();
		And root = factory.createAnd();
		root.setName("BibliotecaGersonAlejo");
		struct.setAnd(root);
		fm.setStruct(struct);
		// TODO Auto-generated method stub
		super.init();
	}

	/**
	 * Writes the contents of a JAXB model in an xml file with identation and
	 * blank spaces
	 * 
	 * @param root
	 *            the root of the object to write
	 * @param path
	 *            destination of the file to create
	 */
	private void jaxbWriter(Object root, String path, String schema) {
		try {
			JAXBContext context = JAXBContext.newInstance(root.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, schema);
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(root, new FileWriter(path));
		} catch (JAXBException e) {
			System.err.println("Error while preparing to write the JAXB model in: " + path);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error while writting the JAXB model in: " + path);
			e.printStackTrace();
		}
	}

	public void process(CtAnnotation<?> annotation) {
		if (annotation.getParent() instanceof CtClass) {

			System.out.println("Class Found " + annotation.getParent().getSignature());
		} else if (annotation.getParent() instanceof CtConstructor) {
			System.out.println("Constructor Found " + annotation.getParent().getSignature());
		} else if (annotation.getParent() instanceof CtMethod) {
			System.out.println("Method Found " + annotation.getParent().getSignature());
			Feature newChild = factory.createFeature();
			CtNamedElement temp = (CtNamedElement) annotation.getParent();
			newChild.setName(temp.getSimpleName());
			fm.getStruct().getAnd().getAndOrAltOrOr().add(newChild);
			// System.out.println("ActualAnnotation " +
			// annotation.getActualAnnotation());
			// System.out.println("ElementValues " +
			// annotation.getElementValues().get("andName"));
			// System.out.println("getName " +
			// annotation.getElementValue("andName"));
		}
	}

	@Override
	public void processingDone() {
		fm.setComments("changos");
		jaxbWriter(fm, "./resources/model.xml", "./resources/featureide.xsd");
		super.processingDone();
	}
}
