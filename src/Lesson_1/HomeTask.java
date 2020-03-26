package Lesson_1;

public class HomeTask {
    public static void main(String[] args) {
        int a =5;
        int b=-1;
        int c=20;
        int year=2100;

        String msg = "wonderful language";

        System.out.println("(a+b)/c="+calc(a, b, c)+";");
        System.out.println("(a+b) > 0: "+compareZero(a, b)+";");
        System.out.println("В "+year+" количество дней в феврале равно "+  dayInFebruary(year)+";");
        strMessage(msg);
    }

    //вычисение результата выражения (а+в)\с
    public static float calc(float a, float b, float c) {
        return ((c != 0) ? (a + b) /(float) c : 0);
    }
    //метод проверяет что сумма чисел на входе больше 0
    public static boolean compareZero(int a, int b) {
        return (((a + b) > 0 ? true : false));
    }
    //Выводит на консоль Java + сообщение на входе метода
    public static void strMessage(String msg) {
        System.out.println("Java, " + msg + "!");
    }
    //метод возвращающий кол-во дней в феврале
    public static int dayInFebruary(int year) {
        return (((year % 4 == 0) && ((year % 100 > 0) || (year % 100 == 0) && year % 400 == 0)) ? 29 : 28);
    }
}
