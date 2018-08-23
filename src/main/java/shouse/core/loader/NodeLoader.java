package shouse.core.loader;

import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import shouse.core.api.Notifier;
import shouse.core.communication.NodeCommunicator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Maks on 26.06.2018.
 */
public class NodeLoader {

    private Set<NodeCommunicator> nodeCommunicators;
    private Set<Notifier> notifiers;

    public NodeLoader(Set<NodeCommunicator> nodeCommunicators, Set<Notifier> notifiers) {
        this.nodeCommunicators = nodeCommunicators;
        this.notifiers = notifiers;
    }

    public Map<String, NodeFactory> loadNodes(){

        Set<Class<?>> annotatedClasses = new HashSet<>();
        new FastClasspathScanner()
                .matchClassesWithAnnotation(NodeConfig.class, annotatedClasses::add)
                .scan();

        return annotatedClasses.stream()
                .map(this::instantiateFactory)
                .map(this::actualizeFactory)
                .collect(Collectors.toMap(NodeFactory::getTypeName, factory-> factory));
    }

    private NodeFactory instantiateFactory(Class<?> aClass) {

        if (NodeFactory.class.isAssignableFrom(aClass)){
            try {
                Constructor constructor =  aClass.getConstructor();
                return (NodeFactory) constructor.newInstance();
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
                throw new RuntimeException("Impossible to instantiate Node Factory. Class must have no arguments constructor", e);
            }
        }

        throw new RuntimeException("Annotated class should implement NodeFactory interface");
    }

    private NodeFactory actualizeFactory(NodeFactory factory) {
        factory.setNodeCommunicators(nodeCommunicators);
        factory.setNotifiers(notifiers);
        return factory;
    }

}
