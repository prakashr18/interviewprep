package com.fico;

import java.util.stream.Stream;

public class Main1 {

    public static void main(String[] args) {
        Animal lab = new Labrador();
        lab.whichBreed();
        Animal.isAnimal();
        Dog.isAnimal();
        Parent p = new Parent();
        p.getName();
        Parent q = new Child();
        q.getName();
    }
}

class Parent {

    void getName() {
        System.out.println("parent getName");
    }

}

class Child extends Parent {

    void getName() {
        System.out.println("child getName");
    }
}