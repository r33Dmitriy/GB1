package ru.geekbrains.lesson3;

import org.w3c.dom.ls.LSOutput;

import java.util.Random;
import java.util.Scanner;
/**
 1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку;
 2. Переделать проверку победы, чтобы она не была реализована просто набором условий, например, с использованием циклов.
 3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4. Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
 4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
 */

public class Homework {
    public static char[][] map;
    public static final int SIZE = 5;
    public static int DOT_TO_WIN = 4;
    public static final char DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static void main(String[] args)
    {
        System.out.println("КРЕСТИКИ НОЛИКИ");
        initMap();
        printMap();
        while (true)
        {
            doHumanTurn();
            printMap();
            if (checkWin(DOT_X))
            {
                System.out.println("Вы победили");
                break;
            }
            else if (isMapFull())
            {
                System.out.println("Игра закончилась ничьей");
                break;
            }
            doAiTurn();
            printMap();
            if (checkWin(DOT_O))
            {
                System.out.println("Победил Искуственный Интелект");
                break;
            }
            else if (isMapFull())
            {
                System.out.println("Игра закончилась ничьей");
                break;
            }
        }
        System.out.println("Игра закончена");
    }
    public static void initMap()
    {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < map.length; i++)
        {
            for (int j = 0; j < map.length; j++)
            {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    public static void printMap()
    {
        for (int i = 0; i <= map.length; i++)
        {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < map.length; i++)
        {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < map.length; j++)
            {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void doHumanTurn()
    {
        int x,y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x,y));
            map[y][x] = DOT_X;
    }
    public static boolean isCellValid(int x, int y)
    {
        if (x < 0 || x >=SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }
    public static void doAiTurn()
    {
        int x, y;
        do{
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x,y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }
    public static boolean checkWin ( char symb ) {
        int countX, countY, countD, countRD; //счетчик совпадений
        countD = 0; //счетчик совпадений по диагонали
        countRD = 0; //счетчик совпадений по обратной диагонали
        for (int i = 0; i < map.length; i++)
        {
            countX = 0; //счетчик совпадений по строкам
            countY = 0; //счетчик совпадений по столбцам
            for (int j = 0; j < map.length; j++)
            {
                if (map[i][j] == symb)
                {
                    countX++;
                    if (countX == DOT_TO_WIN) return true;
                }
                else countX = 0; //скидываем счетчик, если не подряд
                if (map[j][i] == symb)
                {
                    countY++;
                    if (countY == DOT_TO_WIN) return true;
                }
                else countY = 0; //скидываем счетчик, если не подряд
            }
            if (map[i][i] == symb) //проверки диагонали
            {
                countD++;
                if (countD == DOT_TO_WIN) return true;
            }
            else countD = 0; //скидываем счетчик, если не подряд
            if (map[i][map.length - i - 1] == symb) //проверка обратной диагонали
            {
                countRD++;
                if (countRD == DOT_TO_WIN) return true;
            }
            else countRD = 0; //скидываем счетчик, если не подряд
        }
        countD = 0; //счетчик совпадений по диагонали
        countRD = 0; //счетчик совпадений по диагонали
        for (int i = 0; i < 4 ; i++) //цикл проверки малых диагоналей
        {
            if (map[i][i + 1] == symb)
                {
                    countD++;
                    if (countD == DOT_TO_WIN) return true;
                }
                else countD = 0; //скидываем счетчик, если не подряд
                if (map[i + 1][i] == symb)
                {
                    countRD++;
                    if (countRD == DOT_TO_WIN) return true;
                }
                else countRD = 0; //скидываем счетчик, если не подряд

        }
        countD = 0; //счетчик совпадений по диагонали
        countRD = 0; //счетчик совпадений по диагонали
        for (int i = 0; i < 4 ; i++) //цикл проверки малых обратных диагоналей
        {
            if (map[i][map.length - i - 2] == symb) {
                countD++;
                if (countD == DOT_TO_WIN) return true;
            } else countD = 0; //скидываем счетчик, если не подряд
            if (map[i+1][map.length - i -1] == symb) {
                countRD++;
                if (countRD == DOT_TO_WIN) return true;
            } else countRD = 0; //скидываем счетчик, если не подряд
        }
        return false ;
    }

    public static boolean isMapFull()
    {
        for (int i = 0; i < map.length; i++)
        {
            for (int j = 0; j < map.length; j++)
            {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
}
