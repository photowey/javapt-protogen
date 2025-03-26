package io.github.photowey.javapt.protogen.processor.auto;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedOptions;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;

import io.github.photowey.javapt.protogen.core.annotation.AutoProto;
import io.github.photowey.javapt.protogen.core.context.ProcessContext;

/**
 * {@code AutoProtoProcessor}
 *
 * @author photowey
 * @version 1.0.0
 * @since 2025/03/27
 */
@SupportedOptions({"debug", "verify"})
public class AutoProtoProcessor extends AbstractLoggingProcessor {

    private ProcessingEnvironment penv;
    private ProcessContext ctx;

    @Override
    public void doInit(ProcessingEnvironment env, ProcessContext ctx) {
        this.penv = env;
        this.ctx = ctx;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return new HashSet<>(Collections.singletonList(
            AutoProto.class.getName()
        ));
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.RELEASE_17;
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment env) {
        return true;
    }

    // ----------------------------------------------------------------
}
