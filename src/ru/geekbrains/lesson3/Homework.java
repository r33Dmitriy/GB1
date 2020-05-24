package ru.geekbrains.lesson3;

import java.util.Random;
import java.util.Scanner;
/**
 1. Написать программу, которая загадывает случайное число от 0 до 9,
 и пользователю дается 3 попытки угадать это число.
 При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
 После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
 2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
 При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
 сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
 apple – загаданное
 apricot - ответ игрока
 ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
 Для сравнения двух слов посимвольно, можно пользоваться:
 String str = "apple";
 str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
 Играем до тех пор, пока игрок не отгадает слово
 Используем только маленькие буквы
 */
public class Homework {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.println("Выберите игру:");
        System.out.println("1. Угадай число");
        System.out.println("2. Угадай слово");
        int select = sc.nextInt();
        switch (select)
        {
            case 1:
                playGameGuessTheNumber();
                break;
            case 2:
                playGameGuessTheWord();
                break;
        }

    }

    static void playGameGuessTheNumber()
    {
        int maxCount = 3; // максимальное количество попыток, чтобы угадать число
        int cont = 0; // номер попытки
        Random rand = new Random();
        int randNumber = rand.nextInt(10);
        System.out.println("Загаданное число - " + randNumber); // для самопроверки
        for (int i = 0; i < maxCount; i++)
        {
            System.out.println("Угадайте число от 0 до 9");
            int userNumber = sc.nextInt();
            if (userNumber == randNumber)
            {
                System.out.println("Победа! Вы угадали.");
                break;
            }
            else if (userNumber > randNumber)
            {
                System.out.println("Загаданное число меньше");
            }
            else
            {
                System.out.println("Загаданное число больше");
            }
        }
        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        int nextGame = sc.nextInt();
        if (nextGame == 1)
        {
            playGameGuessTheNumber();
        }
    }
    static void playGameGuessTheWord()
    {
        String[] word = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random rand = new Random();
        int randWordIndex = rand.nextInt(word.length);
        String randWord = word[randWordIndex];
        System.out.println("Загаданное слово - " + randWord); //вывод загаданного числа для проверки
        char[] randWordArr = new char[15]; // массив для рандомно загаданного слова
        char[] userWordArr = new char[15]; // массив для слова, введенного пользователем
        for (int i = 0; i < randWordArr.length; i++)  //цикл заполнения массива randWordArr
        {
            if (i < randWord.length())
            {
                randWordArr[i] = randWord.charAt(i);
            }
            else
            {
                randWordArr[i] = '#';
            }
        }
        System.out.println("Угадайте какое слово загадано среди этих: ");
        for (int i = 0; i < word.length; i++) //цикл вывода массива word(варианты для выбора слова игроку)
        {
            System.out.print(word[i] + ", ");
        }
        System.out.println(); // переход на другую строчку после print
        boolean exit = true; //условия выхода из цикла while. по умолчанию true
        do
        {
            int ex = 0; //метка не изменения массива userWordArr
            Scanner scanner = new Scanner(System.in);
            String userWord = scanner.nextLine(); //читаем введенное пользователем слово
            for (int i = 0; i < userWordArr.length; i++) //заполняем массив пользователя
            {
                if (i < userWord.length())
                {
                    userWordArr[i] = userWord.charAt(i);
                }
                else
                {
                    userWordArr[i] = '#';
                }
            }
            for (int i = 0; i < userWordArr.length; i++) //цикл сравнения массивов
            {
                if (userWordArr[i] != randWordArr[i])
                {
                    userWordArr[i] = '#';
                    ex = 1; //если меняем ex, значит слово не угадали целиком
                }
                else if ((userWordArr[i] == '#') && (ex == 0))
                {
                    exit = false;
                }
            }
            System.out.println(userWordArr);
        } while (exit);
        System.out.println("Вы угадали");
    }

}
