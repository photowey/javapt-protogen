package io.github.photowey.javapt.protogen.core.context;

import java.io.Serial;
import java.io.Serializable;

import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {@code ProcessContext}
 *
 * @author photowey
 * @version 1.0.0
 * @since 2025/03/27
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcessContext implements Serializable {

    @Serial
    private static final long serialVersionUID = 1944658199693691899L;

    private Filer filer;
    private Messager messager;
    private Types types;
    private Elements elements;

    // ----------------------------------------------------------------

    public Filer filer() {
        return filer;
    }

    public Messager messager() {
        return messager;
    }

    public Types types() {
        return types;
    }

    public Elements elements() {
        return elements;
    }
}
