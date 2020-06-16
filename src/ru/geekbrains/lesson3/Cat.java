package ru.geekbrains.lesson3;

import javax.swing.*;

public class Cat
{
    private String name; //имя кошки
    private int appetite; //апетит кошки. сколько он ест из миски
    private boolean isFull; //сытость кошки. изначально false

    public Cat(String name, int appetite) //конструктор кошки
    {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Pipkin pipkin) //метод. кошка ест из миски
    {
        if ((pipkin.getFood() >= appetite) && !isFull)
        {
            pipkin.decriseFood(appetite);
            isFull = true;
            System.out.println(name + " поела");
        }
        else if (isFull)
        {
            System.out.println("Кошка уже сыта");
        }
        else
        {
            System.out.println("Не достаточно еды в миске для " + name );
        }
    }

}
