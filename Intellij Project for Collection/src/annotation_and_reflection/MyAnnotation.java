package annotation_and_reflection;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value() default "";
    String name();
    int age();
    String[] newNames();
}
