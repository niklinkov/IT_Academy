package Lesson_4;

public class Worker {
    private int salary;
    private int age;
    private String fio;

    public Worker(String fio, int salary, int age) {
        this.fio=fio;
        this.age=age;
        this.salary=salary;

    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public String getFio() {
        return fio;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String toString () {
        String out;
        out = "ФИО: "+ this.fio+", age:"+ this.age+" " +", salary: "+ this.salary;
        return out;
    }

}
