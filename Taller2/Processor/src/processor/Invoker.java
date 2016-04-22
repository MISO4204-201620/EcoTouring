package processor;

import spoon.Launcher;

public class Invoker {

	public static void main(String[] args) {
		Invoker invoker = new Invoker();
		//invoker.invokeSpoon("./src/code/", "processor.FeatureProcessor");
		
		invoker.invokeSpoon("./../n15_biblioteca/source/", "processor.FeatureProcessor");
	}

	/**
	 * Invokes a spoon processor individually
	 * 
	 * @param source
	 *            sources to be processed by spoon
	 * @param processor
	 *            spoon processor to execute
	 */
	protected void invokeSpoon(String source, String processor) {
		// Invoke spoon processor for methods
		String[] spoonArgs = new String[6];
		spoonArgs[0] = "-i";
		spoonArgs[1] = source;
		spoonArgs[2] = "-p";
		spoonArgs[3] = processor;
		spoonArgs[4] = "--compliance";
		//spoonArgs[5] = "8";
		// spoonArgs[6] = "-o";
		// spoonArgs[7] = "./src/main/java";
		try {
			Launcher.main(spoonArgs);
		} catch (Exception e) {
			System.err.println("Error while executing spoon launcher " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
	}
}