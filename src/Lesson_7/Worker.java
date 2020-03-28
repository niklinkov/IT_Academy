package Lesson_7;

import javafx.css.Match;

public class Worker {
    private String name;  //фамилия сотрудника
    private String age;  //возраст сотрудника

    //конструктор
    public Worker (String name, String age) {
        this.name=name;
        this.age = age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

// метод возвращающий возраст сотрудниа в числовом виде
    public int ageToInt () throws StringToIntException {
        if (!age.matches("[0-9]+")) {
            //если возраст указан прописью вернуть исключение
            throw new StringToIntException("Невозможно преобразовать возраст к числу",age);
        } else return Integer.parseInt(age);
    }
}


