package shouse.core.loader;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created by Maks on 01.07.2018.
 */
@Target(ElementType.TYPE)
public @interface NodeConfig {

    String name();
}
