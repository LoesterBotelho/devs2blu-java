package exercicios22082026parte0.oo.exercicio0;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Campo {

    String nome();

    TipoDado tipo();

    int tamanho() default 0;

    boolean nullable() default true;
}