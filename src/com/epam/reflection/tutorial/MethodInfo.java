package com.epam.reflection.tutorial;

import java.lang.annotation.*;

/**
 * Created by Зая on 28.07.2016.
 */
@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {
    String author() default "Ivanov";
    String date();
    int revision () default 1;
    String comments();
}
