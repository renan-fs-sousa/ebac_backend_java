package anotacao;

import java.lang.annotation.*;

/**
 * @author renan.sousa
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TipoChave {

    String value();
}
