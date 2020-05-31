package ru.geekbrains.lesson3;

/**
 * Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
 * Конструктор класса должен заполнять эти поля при создании объекта;
 * Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
 * Создать массив из 5 сотрудников
 Пример:
 Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
 persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
 persArray[1] = new Person(...);
 ...
 persArray[4] = new Person(...);

 * С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
 */

public class Homework {
    public static void main(String[] args)
    {
       Employee[] empArray = new Employee[5]; //создаем массив сотрудников
        // заполняем массив сотрудников
       empArray[0] = new Employee("Semenov Semen Semenovich", "director", "director@ya.ru", "+7-777-777-77-77", 100000, 60);
       empArray[1] = new Employee("Kirilov Kiril Kirilovich", "foreman", "foreman@ya.ru", "+7-777-777-77-76", 70000, 54);
       empArray[2] = new Employee("Ivanov Ivan Ivanopich", "engineer", "engineer@ya.ru", "+7-777-777-77-75", 50000, 42);
       empArray[3] = new Employee("Petrov Petr Petrovich", "assistant", "assistant@ya.ru", "+7-777-777-77-74", 35000, 27);
       empArray[4] = new Employee("Vasileva Vasilisa Vasilevna", "cleaner", "cleaner@ya.ru", "+7-777-777-77-73", 15000, 19);
       //цикл вывода сотрудников старше 40 лет
        for (int i = 0; i < empArray.length; i++)
        {
            if (empArray[i].getAge() > 40)
            {
                empArray[i].getInfo();
            }
        }
    }
}
