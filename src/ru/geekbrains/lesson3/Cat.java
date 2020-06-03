package ru.geekbrains.lesson3;

public class Cat extends Animal
{
    //конструктор для класса Cat подразумевает, что коты не плавают
    public Cat(float maxRunDistance, float maxJumpDistance)
    {
        super(maxRunDistance, 0, maxJumpDistance);
    }

    //переопределяем метод swim. потому что коты не умею плавать
    @Override
    public void swim(float distance)
    {
        System.out.println("Кошки не умеют плавать");
    }
}
