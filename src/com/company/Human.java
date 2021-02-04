package com.company;

public class Human {

    private double height;
    private int age;
    private String name;
    private boolean death;
    private boolean changedName;

    public Human() {
        age = 1;
        height = 50;
    }

    public Human(String name) {
        this();
        this.name = name;
    }

    public void grow() {
        if (age < 25 && !death) {
            height += 12;
        } else if (age > 60 && height > 2 && !death) {
            height -= 2;
        }

        if (age >= 150) {
            death = true;
        } else {
            age++;
        }

        if (age == 100 && !death) {
            System.out.println("Поздравляю, " + name + " – долгожитель!");
        }
    }

    public String getPrediction(int years_prediction) {

        if (years_prediction < 0) {
            return "Введено отрицательное значение!";
        }

        for (int i = 0; i < years_prediction; i++) {
            grow();
        }

        return getName() + (isChangedName() ? " (человек изменил своё имя)" : "")
                + ", его(её) прогнозируемое состояние через " + years_prediction + " лет(год):\n"
                + "- " + (isDeath() ? "мертв(-а)" : "жив") + ";\n"
                + "- возраст " + getAge() + " лет(год)" + (isDeath() ? " (на момент смерти)" : "") + ";\n"
                + "- рост " + getHeight() + " см" + (isDeath() ? " (на момент смерти)" : "") + ".";
    }

    public double getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
        this.changedName = true;
    }

    public String getName() {
        return name;
    }

    public boolean isDeath() {
        return death;
    }

    public boolean isChangedName() {
        return changedName;
    }

}