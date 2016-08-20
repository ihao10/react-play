package modules.bindings;

import com.google.inject.AbstractModule;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


// services单例用这个扫描，失败了没法用
// install(new ComponentScanModule("services", Singleton.class));
public class ComponentScanModule extends AbstractModule {
    private final String packageName;
    private final Set<Class<? extends Annotation>> bindingAnnotations;

    @SafeVarargs
    public ComponentScanModule(String packageName, final Class<? extends Annotation>... bindingAnnotations) {
        this.packageName = packageName;
        this.bindingAnnotations = new HashSet<>(Arrays.asList(bindingAnnotations));
    }

    @Override
    protected void configure() {
        Reflections packageReflections = new Reflections(packageName);
        bindingAnnotations.stream()
                .map(packageReflections::getTypesAnnotatedWith)
                .flatMap(Set::stream)
                .forEach(this::bind);
    }
}
