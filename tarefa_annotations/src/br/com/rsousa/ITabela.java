package br.com.rsousa;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.CONSTRUCTOR })
public @interface ITabela {
    String marca();

    String modelo();

}