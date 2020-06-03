package ru.geekbrains.lesson3;
//абстрактный класс Animal, от которого будет наследования для классов Cat и Dog
public abstract class Animal {
    // Задаем ограничения действия для животного
    protected float maxRunDistance;
    protected float maxSwimDistance;
    protected float maxJumpDistance;
    //конструктор
    public Animal(float maxRunDistance, float maxSwimDistance, float maxJumpDistance)
    {
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.maxJumpDistance = maxJumpDistance;
    }
    // команда бежать
    public void run(float distance)
    {
        System.out.println(" бежит " + distance + " : " + canDo(distance, maxRunDistance));
    }
    // команда плыть
    public void swim(float distance)
    {
        System.out.println(" плывет " + distance + " : " + canDo(distance, maxSwimDistance));
    }
    // команда прыгать
    public void jump(float distance)
    {
        System.out.println(" прыгает " + distance + " : " + canDo(distance, maxJumpDistance));
    }
    //проверяем справится ли животное с поставленной командой
    private boolean canDo(float command, float maxCanDo)
    {
        if (command <= maxCanDo)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
