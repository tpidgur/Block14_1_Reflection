package com.epam.reflection.tutorial;

import java.lang.annotation.*;

/**
 * Created by Зая on 28.07.2016.
 */

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldAnnotation {
    String author() default "Ivanov";

    String date();
}
