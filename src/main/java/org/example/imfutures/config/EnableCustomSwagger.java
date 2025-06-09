package org.example.imfutures.config;

import kotlin.annotation.Retention;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Documented
@Inherited
@Import({SwaggerConfig.class})
public @interface EnableCustomSwagger {
}
