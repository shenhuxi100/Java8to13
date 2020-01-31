package com.study;

import org.w3c.dom.ls.LSOutput;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // default interface
        Animal dog = new Dog();
        dog.run();
        dog.breath();
        Animal.speak();

        //Date and Time
        LocalDate today = LocalDate.now();
        System.out.println(today);
        System.out.println(today.getMonth());
        System.out.println(today.getDayOfMonth());
        System.out.println(today.plusDays(1).isAfter(today.minusDays(1)));

        LocalDateTime todayTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
        System.out.println(dtf.format(todayTime));

        LocalDateTime changedTime = LocalDateTime.of(2099, 1,1,1,1,2 );
        System.out.println(changedTime);
        System.out.println(Duration.between(todayTime, changedTime).toDays());

        //Optional
        Animal animal = null;
        Animal a = Optional.ofNullable(animal).orElse(new Dog());
        a.run();
        Optional opt = Optional.ofNullable(new Dog());
        System.out.println(opt.isPresent());
    }
}
