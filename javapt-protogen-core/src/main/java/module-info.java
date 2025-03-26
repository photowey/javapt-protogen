/**
 * {@code module-info}
 *
 * @author photowey
 * @since 2025/03/27
 */
module io.github.photowey.javapt.protogen.core {

    exports io.github.photowey.javapt.protogen.core.annotation;
    exports io.github.photowey.javapt.protogen.core.context;

    requires static lombok;
    requires java.compiler;
}
