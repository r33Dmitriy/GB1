package ru.geekbrains.lesson3;

import java.util.Random;

/**
 1. Создать классы Собака и Кот с наследованием от класса Животное.
 2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие. В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания), или высоту (для прыжков).
 3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; прыжок: кот 2 м., собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.).
 4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль. (Например, dog1.run(150); -> результат: run: true)
 5. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.
 */

public class Homework {
    public static void main(String[] args)
    {
        //создаем объекты кошек и собак с заданными вручную параметорами
        Cat cat1 = new Cat(200, 2);
        Dog dog1 = new Dog(500, 10, 0.5f);
        //даем команды кошке
        System.out.println("Кошка. Ограничения: бег - " + cat1.maxRunDistance + ", прыжок - " + cat1.maxJumpDistance + ", не умеют плавать.");
        cat1.run(100);
        cat1.run(300);
        cat1.swim(3);
        cat1.jump(1);
        cat1.jump(2.5f);
        //даем команды собаке
        System.out.println("Собака. Ограничения: бег - " + dog1.maxRunDistance + ",плавание - " + dog1.maxSwimDistance + ", прыжок - " +  + dog1.maxJumpDistance );
        dog1.run(450);
        dog1.run(700);
        dog1.swim(6);
        dog1.swim(11);
        dog1.jump(0.5f);
        dog1.jump(1);
        //созаем кошку срандомными ограничениями и даем команды
        Animal cat2 = buildCat();
        System.out.println("Кошка. Ограничения: бег - " + cat2.maxRunDistance + ", прыжок - " + cat2.maxJumpDistance + ", не умеют плавать.");
        cat2.run(100);
        cat2.run(300);
        cat2.swim(3);
        cat2.jump(1);
        cat2.jump(2.5f);
        //созаем собаку срандомными ограничениями и даем команды
        Animal dog2 = buildDog();
        System.out.println("Собака. Ограничения: бег - " + dog2.maxRunDistance + ",плавание - " + dog2.maxSwimDistance + ", прыжок - " +  + dog2.maxJumpDistance );
        dog2.run(450);
        dog2.run(700);
        dog2.swim(6);
        dog2.swim(11);
        dog2.jump(0.5f);
        dog2.jump(1);
    }
    //метод создания кошки с рандомными ограничениями действий
    static Animal buildCat()
    {
        Random random = new Random();
        float maxRunDistance = random.nextInt(350) + random.nextFloat();
        float maxJumpDistance = random.nextInt(5) + random.nextFloat();
        Cat cat = new Cat(maxRunDistance, maxJumpDistance);
        return cat;
    }
    //метод создания собаки с рандомными ограничениями действий
    static Animal buildDog()
    {
        Random random = new Random();
        float maxRunDistance = random.nextInt(700) + random.nextFloat();
        float maxSwimDistance = random.nextInt(30) + random.nextFloat();
        float maxJumpDistance = random.nextInt(3) + random.nextFloat();
        Dog dog = new Dog(maxRunDistance, maxSwimDistance, maxJumpDistance);
        return dog;
    }
}
