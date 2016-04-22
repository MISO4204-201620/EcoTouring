package annotation;

public @interface featureFT {

	String name() default "";
	String mandatory() default "";
	String parent() default "";
}
