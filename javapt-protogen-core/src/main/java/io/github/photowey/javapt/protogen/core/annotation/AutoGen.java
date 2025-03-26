package io.github.photowey.javapt.protogen.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

// @formatter:off

/**
 * {@code AutoGen}
 *
 * @author photowey
 * @version 1.0.0
 * @since 2025/03/26
 */
@Documented
@Target(TYPE)
@Retention(RUNTIME)
public @interface AutoGen { }

// @formatter:on
