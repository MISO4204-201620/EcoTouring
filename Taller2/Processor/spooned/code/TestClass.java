package code;


@annotation.featureFT(name = "TestClassClass")
public class TestClass {
    int i;

    java.lang.Object o;

    java.lang.String s;

    @annotation.andFT(andName = "TestClassmethod1", mandatory = "true")
    public TestClass() {
    }

    @annotation.orFT(andName = "TestClassMethod2")
    private void foo() {
        (code.TestClass.this.i)++;
    }
}

