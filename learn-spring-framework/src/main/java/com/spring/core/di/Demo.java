package com.spring.core.di;


class DependencyA{}
class DependencyB{}
class DependencyC{}
public class Demo {
    private final DependencyA dependencyA;
    private final DependencyB dependencyB;
    private final DependencyC dependencyC;

    public Demo(DependencyA dependencyA, DependencyB dependencyB, DependencyC dependencyC) {
        this.dependencyA = dependencyA;
        this.dependencyB = dependencyB;
        this.dependencyC = dependencyC;
    }
}
