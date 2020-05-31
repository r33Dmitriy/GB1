package ru.geekbrains.lesson3;

public class Employee
{
    private String FIO;
    private String position;
    private String email;
    private String phone;
    private float salary;
    private int age;
    //единственный конструктор класса, в котором заполняем все поля при создании
    public Employee(String FIO, String position, String email, String phone, float salary, int age)
    {
        this.FIO = FIO;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
    //метод выводит полную информацию о сотруднике
    public void getInfo()
    {
        System.out.println("ФИО - " + FIO);
        System.out.println("Должность - " + position);
        System.out.println("Почта - " + email);
        System.out.println("Телефон - " + phone);
        System.out.println("Зарплата - " + salary);
        System.out.println("Возраст - " + age);
    }
    //метод возвращает возраст сотрудника
    public int getAge()
    {
        return age;
    }
}
