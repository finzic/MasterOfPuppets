package it.finzicontini.pm_compiler;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

import it.finzicontini.pm_annotations.GraphArc;
import it.finzicontini.pm_annotations.GraphNode;

public class Processor extends AbstractProcessor {

    private Filer filer;
    private Messager messager;
    private Elements elementUtils;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        filer = processingEnv.getFiler();
        messager = processingEnv.getMessager();
        elementUtils = processingEnv.getElementUtils();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        // all the magic happens in this block
        return true;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return new TreeSet<>(Arrays.asList(
                GraphNode.class.getCanonicalName(),
                GraphArc.class.getCanonicalName()));
    }
}

