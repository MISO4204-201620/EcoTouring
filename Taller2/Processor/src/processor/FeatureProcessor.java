package processor;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import generated.Alt;
import generated.And;
import generated.Feature;
import generated.FeatureModel;
import generated.NamedElement;
import generated.ObjectFactory;
import generated.Or;
import generated.Parent;
import generated.Struct;
import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtAnnotation;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtConstructor;
import spoon.reflect.declaration.CtElement;
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
		root.setName("Biblioteca");
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
		    
		    // Obtenemos los atributos dela anotacion
		    CtNamedElement annotationParent = (CtNamedElement)annotation.getParent();
		    String annotationName = annotationParent.getSimpleName();
		    String attributeName = annotation.getElementValue("name").toString();
		    String attributeMandatory = annotation.getElementValue("mandatory").toString();
		    String attributeParent = annotation.getElementValue("parent").toString();
            
		    // Obtenemos la caracteristica padre de la anotacion
		    List<Object> listOfParents = fm.getStruct().getAnd().getAndOrAltOrOr(); 
		    And andParent = new And();
		    Or orParent = new Or();		    
		    Alt altParent = new Alt();
		    String classParent = "";
		    
		    for(Object elementParent : listOfParents)
		    {
		    	if(elementParent instanceof And)
		    	{
		    		And andObject = (And)elementParent;
		    		if(andObject.getName().equals(attributeParent)){
		    		   andParent = andObject;
		    		   classParent = "and";
		    		   break;
		    		}
		    	}
		    	
		    	if(elementParent instanceof Or)
		    	{
		    		Or orObject = (Or)elementParent;
		    		if(orObject.getName().equals(attributeParent)){
		    		   orParent = orObject;
		    		   classParent = "or";
		    		   break;		    		   
		    		}
		    	}
		    	
		    	if(elementParent instanceof Alt)
		    	{
		    		Alt altObject = (Alt)elementParent;
		    		if(altObject.getName().equals(attributeParent)){
		    		   altParent = altObject;
		    		   classParent = "alt";
		    		   break;		    		   
		    		}
		    	}		    	
		    }
		    
		    // Evaluamos si la anotacion es and
			if(annotation.getAnnotationType().toString().equals("annotation.andFT"))
			{
	            And newChild = factory.createAnd();			  
				if(attributeName.equals("")){
				  attributeName = annotationName;
				}
				newChild.setName(attributeName);			  
					  
				if(attributeMandatory.equals("true")){
				  newChild.setMandatory(true);	
				}
					  
				if(classParent.equals("and"))
				  andParent.getAndOrAltOrOr().add(newChild);
				else if(classParent.equals("or")){
					  orParent.getAndOrAltOrOr().add(newChild);
				} else if(classParent.equals("alt")){
					  altParent.getAndOrAltOrOr().add(newChild);
				} else {
					  fm.getStruct().getAnd().getAndOrAltOrOr().add(newChild);
				}			  
			}
			
			// Evaluamos si la anotacion es or
			if(annotation.getAnnotationType().toString().equals("annotation.orFT"))
			{		
			   Or newChild = factory.createOr();			  
			   if(attributeName.equals("")){
				   attributeName = annotationName;
			   }
			   newChild.setName(attributeName);
			  
			   if(attributeMandatory.equals("true")){
				   newChild.setMandatory(true);	
			   }
		  
			   if(classParent.equals("and")) {
				   andParent.getAndOrAltOrOr().add(newChild);
			   } else if(classParent.equals("or")){
				   orParent.getAndOrAltOrOr().add(newChild);
			   } else if(classParent.equals("alt")){
				   altParent.getAndOrAltOrOr().add(newChild);
			   } else {
				  fm.getStruct().getAnd().getAndOrAltOrOr().add(newChild);
			   }
			}

			// Evaluamos si la anotacion es feature
			if(annotation.getAnnotationType().toString().equals("annotation.featureFT"))
			{		
			   Feature newChild = factory.createFeature();			  
			   if(attributeName.equals("")){
				   attributeName = annotationName;
			   }
			   newChild.setName(attributeName);
			  
			   if(attributeMandatory.equals("true")){
				   newChild.setMandatory(true);	
			   }
			  
			   if(classParent.equals("and")){
				   andParent.getAndOrAltOrOr().add(newChild);
			   } else if(classParent.equals("or")){
				   orParent.getAndOrAltOrOr().add(newChild);
			   } else if(classParent.equals("alt")){
				   altParent.getAndOrAltOrOr().add(newChild);
			   } else {
				   fm.getStruct().getAnd().getAndOrAltOrOr().add(newChild);
			   }
			}
			
			// Evaluamos si la anotacion es alt
			if(annotation.getAnnotationType().toString().equals("annotation.altFT"))
			{				
			   Alt newChild = factory.createAlt();			  
			   if(attributeName.equals("")){
				  attributeName = annotationName;
			   }
			   newChild.setName(attributeName);
				  
			   if(attributeMandatory.equals("true")){
				  newChild.setMandatory(true);	
			   }
				  
			   if(classParent.equals("and")){
			  	   andParent.getAndOrAltOrOr().add(newChild);
			   } else if(classParent.equals("or")){
			  	   orParent.getAndOrAltOrOr().add(newChild);
			   } else if(classParent.equals("alt")){
			         altParent.getAndOrAltOrOr().add(newChild);
			   } else {
				  fm.getStruct().getAnd().getAndOrAltOrOr().add(newChild);
			   }
			}			
			System.out.println("Annotation: " + attributeName);
	}

	@Override
	public void processingDone() {
		fm.setComments("Diagrama de Caracterisiticas Bibilioteca");
		jaxbWriter(fm, "./resources/model.xml", "./resources/featureide.xsd");
		super.processingDone();
	}
}
