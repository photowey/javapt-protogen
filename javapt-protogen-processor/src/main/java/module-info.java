/**
 * {@code module-info}
 *
 * @author photowey
 * @since 2025/03/27
 */
module io.github.photowey.javapt.protogen.processor {

    exports io.github.photowey.javapt.protogen.processor.auto;

    requires io.github.photowey.javapt.protogen.core;

    requires java.compiler;
}
