package com.study;


import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.*;
import java.util.stream.Collectors;

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

        LocalDateTime changedTime = LocalDateTime.of(2099, 1, 1, 1, 1, 2);
        System.out.println(changedTime);
        System.out.println(Duration.between(todayTime, changedTime).toDays());

        //Optional
        Animal animal = null;
        Animal a = Optional.ofNullable(animal).orElse(new Dog());
        a.run();
        Optional opt = Optional.ofNullable(new Dog());
        System.out.println(opt.isPresent());

        //Function
        test("123", new FunctionObj());
        Function<Integer, Integer> func = p -> p * 100;
        System.out.println(func.apply(2));
        BiFunction<Integer, Integer, Integer> bf = (p1, p2) -> p1 * p2;
        System.out.println(bf.apply(3, 2));

        //Consumer
        Consumer con = p -> System.out.println(p);
        Consumer then = p -> System.out.println("after: " + p);
        con.accept("accept test");
        con.andThen(then).accept("123");
        List<String> list = Arrays.asList("abc", "afg", "qwe");
        list.forEach(l -> System.out.println(l));

        //Supplier
        Supplier<Dog> supplier = () -> { Dog d = new Dog(); return d; };
        supplier.get().run();

        //Predicate
        System.out.println(filter(list, obj -> obj.startsWith("a")));


        //总价 35
        List<VideoOrder> videoOrders1 = Arrays.asList(
                new VideoOrder("20190242812", "springboot教程", 3),
                new VideoOrder("20194350812", "微服务SpringCloud", 5),
                new VideoOrder("20190814232", "Redis教程", 9),
                new VideoOrder("20190523812", "⽹网⻚页开发教程", 9),
                new VideoOrder("201932324", "百万并发实战Netty", 9));
        //总价 54
        List<VideoOrder> videoOrders2 = Arrays.asList(
                new VideoOrder("2019024285312", "springboot教程", 3),
                new VideoOrder("2019081453232", "Redis教程", 9),
                new VideoOrder("20190522338312", "⽹网⻚页开发教程", 9),
                new VideoOrder("2019435230812", "Jmeter压⼒力力测试", 5),
                new VideoOrder("2019323542411", "Git+Jenkins持续集成", 7),
                new VideoOrder("2019323542424", "Idea全套教程", 21));
        List<VideoOrder> xx = videoOrders1.stream().filter(obj -> {
            return videoOrders2.stream().anyMatch(o2 -> o2.getTitle().equals(obj.getTitle()));
        }).collect(Collectors.toList());

        xx.forEach(obj -> System.out.println(obj.getTitle()));
    }

    static void test(String input, Function f) {
        System.out.println(f.apply(input));
    }

    static List<String> filter(List<String> input, Predicate<String> predicate){
        List<String> startWithA = new ArrayList<String>();
        for(String i : input) {
            if(predicate.test(i)) {
                startWithA.add(i);
            }
        }
        return startWithA;
    }
}

