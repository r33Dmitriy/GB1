package ru.geekbrains.lesson3;

public class Pipkin
{
    private int food; //количество еды в миске

    public Pipkin(int food) //конструктор миски
    {
        this.food = food;
    }

    public void info() //метод вывода кол-ва еды в миске
    {
        System.out.println("Еды осталось:" + food);
    }

    public void decriseFood(int animalAppetite) //метод уменьшения еды в миске
    {
            food = food - animalAppetite;
    }
    public int getFood() //метод гет возвращает кол-во еды в миске
    {
        return food;
    }
    public void pourFood(int moreFood)//метод насыпать корма в миску. задаем количество сколько насыпать корма
    {
        food = food + moreFood;
    }
}
