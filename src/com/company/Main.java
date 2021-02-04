package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        runTask1();
        runTask2();
        runTask3();
    }

    //Задание 1.
    //Реализовать класс Человек (Human) из урока у себя в проекте.
    //Переописать логику таким образом чтобы до 25 росли на 12, а после 60 уменьшались на 2.
    //Добавить логику чтоб после 150 была смерть и рост останавливался.
    //Вырастить Олега и Дашу на 120 и 200 соответственно.
    //Сделать возможность сменить имя.
    public static void runTask1() {
        Human oleg = new Human("Олег");
        int oleg_years_prediction = 120;
        Human dasha = new Human("Даша");
        int dasha_years_prediction = 200;

        dasha.setName("Дарина");

        System.out.println(oleg.getPrediction(oleg_years_prediction));
        System.out.println(dasha.getPrediction(dasha_years_prediction));
        System.out.println();
    }

    //Задание 2.
    //Сделать класс Машина(Car).
    //У него должны быть 3 поля: модель(String), кол-во литров бензина в км(int), кол-во бензина в баке(float).
    //Сделать метод заправки бензина в машину.
    //Сделать метод проезда n км. В нем описать следующую логику:
    //Если бензина хватает то проехать и написать в чат что поехали, остаток столько то бензина.
    //Если бензина не хватает то проехать сколько хватит и написать сколько проехали и что бензин закончился.
    public static void runTask2() {
        Car bmw = new Car("BMW", 13, 17F, 68F);

        System.out.println("Объём бака до заправки " + bmw.getCurrentTankVolume() + " л.");
        bmw.fueling(25);
        System.out.println("Объём бака после заправки " + bmw.getCurrentTankVolume() + " л.");

        bmw.trip(800);
        System.out.println();
    }

    //Задание 3.
    //Палиндром – число которое пишется и читается одинаково как слева направо так и справа налево.
    //Написать программу которая будет выяснять является ли число палиндромом.
    public static void runTask3() {
        System.out.println("Введите число, чтобы проверить является ли оно палиндромом: ");
        Scanner sc = new Scanner(System.in);
        String input_string = sc.nextLine();

        //-вариант 1: - решение с помощью строк
        String reverse_string = (new StringBuilder(input_string)).reverse().toString();
        System.out.println("Число " + input_string + (reverse_string.equals(input_string) ? "" : " не")
                + " является палиндромом. Использованы методы класса StringBuilder.");

        //-вариант 2: - решение с помощью арифметических операций
        long number = Long.parseLong(input_string);
        long reversed_number = 0;
        for (long n = number; n > 0L; n = n / 10) {
            reversed_number = 10 * reversed_number + (n % 10);
        }

        System.out.println("Число " + number + (reversed_number == number ? "" : " не")
                + " является палиндромом. Использованы арифметические операции.");
    }

}