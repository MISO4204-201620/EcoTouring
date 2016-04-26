package code;

import annotation.andFT;
import annotation.featureFT;
import annotation.orFT;

@featureFT(name = "TestClassClass")
public class TestClass {

	int i;
	Object o;
	String s;

	@andFT(name = "TestClassmethod1", mandatory="true")
	public TestClass() {
	}

	@orFT(name = "TestClassMethod2")
	private void foo() {
		this.i++;
	}
}
