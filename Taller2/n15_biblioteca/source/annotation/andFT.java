package annotation;

public @interface andFT {

	String name() default "";
	String mandatory() default "";
	String parent() default "";
}