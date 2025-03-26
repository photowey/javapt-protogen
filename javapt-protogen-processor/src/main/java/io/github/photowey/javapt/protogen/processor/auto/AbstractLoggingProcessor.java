package io.github.photowey.javapt.protogen.processor.auto;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;

import io.github.photowey.javapt.protogen.core.context.ProcessContext;

/**
 * {@code AbstractLoggingProcessor}
 *
 * @author photowey
 * @version 1.0.0
 * @since 2025/03/27
 */
public abstract class AbstractLoggingProcessor extends AbstractProcessor {

    @Override
    public synchronized void init(ProcessingEnvironment env) {
        super.init(env);

        Filer filer = processingEnv.getFiler();
        Messager messager = processingEnv.getMessager();
        Types types = processingEnv.getTypeUtils();
        Elements elements = processingEnv.getElementUtils();

        ProcessContext ctx = ProcessContext.builder()
            .filer(filer)
            .messager(messager)
            .types(types)
            .elements(elements)
            .build();

        this.doInit(env, ctx);
    }

    public abstract void doInit(ProcessingEnvironment env, ProcessContext ctx);

    protected void log(String message) {
        if (processingEnv.getOptions().containsKey("debug")) {
            processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, message);
        }
    }

    protected void warning(String message, Element element, AnnotationMirror annotation) {
        processingEnv.getMessager()
            .printMessage(Diagnostic.Kind.WARNING, message, element, annotation);
    }

    protected void error(String message, Element element, AnnotationMirror annotation) {
        processingEnv.getMessager()
            .printMessage(Diagnostic.Kind.ERROR, message, element, annotation);
    }

    protected void fatal(String message) {
        processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "FATAL ERROR: " + message);
    }
}
