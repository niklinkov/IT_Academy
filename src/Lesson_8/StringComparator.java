package Lesson_8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class StringComparator {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        //получить первую строку
        list.add(getString());
        list.add(getString());


        System.out.println(list.get(0).equalsIgnoreCase(list.get(1)));

    }

    public static String getString (){
        System.out.println("Vvedirte stroku");
        return sc.nextLine();
    }

}
