package Lesson_3;

import java.util.ArrayList;
import java.util.List;

public class test_1 {
    public static void main(String[] args) {

        System.out.println(new test_1());
        int i = 9;

        System.out.println(i++);  //сначала выводит i потом увеличивает значение переменной на 1

        System.out.println(i+1);  //выводит на косноль результат математической операции 10+1

        System.out.println(i);  //выводит на экран хранящуюся в стеке 10

        int[] mass = {1, 2};

        List<String> list = new ArrayList(10);

        list.add("03");

        list.add("04");

        System.out.println(mass.length + list.size() + ".");

//        double d = Math.sqrt(-1);
//
//        System.out.println(Double.NaN == d);  //d - ссылка на объект
//
//        d = d / 0;
//
//        System.out.println(Double.isNaN(d));
//
//        System.out.println("Hello");
//
//        http://www.java.ru
//
//        return;

        Long a = 111L;

        Long b = 111L;

        Long c = 222L;

        Long d = 222L;


        System.out.println(a);
        System.out.println(b);
        System.out.println(a == b);

        System.out.println(c);
        System.out.println(d);
        System.out.println(c == d);

    }


}
