package Lesson_5;

interface BuildMaterial {
    void build();
}

abstract class Shape {
    public void draw() {

    }
}

//наследник квадрат
class Square extends Shape implements BuildMaterial {

    @Override
    public void draw() {
        System.out.println("Квадрат");
    }

    @Override
    public void build() {
        System.out.println("Строим квадрат");
    }
}

//наследник круг
class Circle extends Shape implements BuildMaterial {
    @Override
    public void draw() {
        System.out.println("Круг");
    }

    @Override
    public void build() {
        System.out.println("Строим Круг");
    }
}

//класс треугольник
class Triangle extends Shape implements BuildMaterial {
    @Override
    public void draw() {
        System.out.println("Треугольник");
    }

    @Override
    public void build() {
        System.out.println("Строим Треугольник");
    }
}