package app.web.pavelk.annotation1;


//@Target применение field поле method метод type клас
//@Retention удержание source - при компиляции class - в байты runtime - во время работы

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Annotation1 {
    String author() default "Cat0";

    int dateOf() default 01012000;
}
