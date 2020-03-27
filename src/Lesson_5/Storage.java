package Lesson_5;

public class Storage {

    private int triangleQuantity; //кол-во хранящихся треугольников
    private int circleQuantity; //кол-во хранящихся кругов
    private int squareQuantity; //кол-во храняцихся квадратов
    Circle circle;
    Square square;
    Triangle triangle;

    public Storage () {
        setCircleQuantity(0);
        setSquareQuantity(0);
        setTriangleQuantity(0);

    }

    public boolean checkMatrials () {
        return (getCircleQuantity() > 0 && getSquareQuantity() > 0 && getTriangleQuantity() > 0);
    }

    public void addMaterial (Circle material, int quantity) {
        circleQuantity+=quantity;
        this.circle=material;
    }

    public void addMaterial (Triangle material, int quantity) {
        triangleQuantity+=quantity;
        this.triangle=material;
    }

    public void addMaterial (Square material, int quantity) {
        squareQuantity+=quantity;
        this.square=material;
    }


    public void removeMaterial (Square material, int quantity) {
        squareQuantity-=quantity;
        if (squareQuantity<=0) square=null;
    }

    public void removeMaterial (Triangle material, int quantity) {
        triangleQuantity-=quantity;
        if (triangleQuantity<=0) triangle=null;
    }

    public void removeMaterial (Circle material, int quantity) {
        circleQuantity-=quantity;
        if (circleQuantity<=0) circle=null;
    }

    public void setCircleQuantity(int circleQuantity) {
        this.circleQuantity = circleQuantity;
    }

    public void setSquareQuantity(int squareQuantity) {
        this.squareQuantity = squareQuantity;
    }


    public void setTriangleQuantity(int triangleQuantity) {
        this.triangleQuantity = triangleQuantity;
    }

    public int getCircleQuantity() {
        return circleQuantity;
    }

    public int getSquareQuantity() {
        return squareQuantity;
    }

    public int getTriangleQuantity() {
        return triangleQuantity;
    }

}
