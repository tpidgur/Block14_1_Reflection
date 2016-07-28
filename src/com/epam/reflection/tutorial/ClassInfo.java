package com.epam.reflection.tutorial;

import java.lang.annotation.*;

/**
 * Created by Зая on 28.07.2016.
 */
@Documented
@Target(ElementType.TYPE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface ClassInfo {
    String author() default "Ivanov";
    String date();
}
