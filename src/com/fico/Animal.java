package com.fico;

public interface Animal {

    static boolean isAnimal() {
        System.out.println("Animal interface static method");
        return true;
    }
    void whichBreed();
}
