package annotation;

public @interface orFT {

	String name() default "";
	String mandatory() default "";
	String parent() default "";
}
