package com.study;

public interface Animal {
    void run();
    default void breath() {
        System.out.println("Breathing oxygen");
    }

    static void speak() {
        System.out.println("i can speak");
    }
}
