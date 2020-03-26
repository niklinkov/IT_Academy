package Lesson_1;

public class MainClass {
    public static void main(String[] args) {
        long res = calcTwoNumber(21000000, 21000000);
        System.out.println(res);

    }

    public static long calcTwoNumber(int a, int b) {
        long res = a + b;
        return res;
    }

}
