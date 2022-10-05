package com.fico;

public interface Dog extends Animal{

    static boolean isAnimal() {
        System.out.println("Dog interface static method");
        return true;
    }

    void whichBreed();
}
