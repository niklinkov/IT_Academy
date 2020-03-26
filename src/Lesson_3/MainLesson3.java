package Lesson_3;

import java.util.Random;
import java.util.Scanner;

public class MainLesson3 {
//    static Scanner sc = new Scanner(System.in);
    static Random rnd = new Random();
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        String b = sc.nextLine();
//        String c = sc.next();
//
//        System.out.println(a + " " + b + " " + c);

//        String res = String.format("Строка %ы дробь %f дробь %d символ %c", "Java", 4.5f, 55, 'y');
//System.out.println(res);
//        }
//        public static int getNumberFromSc (String msg, int min, int max) {
//        int x;
//
//        do {System.out.println(msg);
//        x = sc.nextInt();
//        } while (x < min || x> max);
//        return x;
//        }

        Random random = new Random();

        String[] colors = {"red", "green"};



        System.out.println(random.nextInt());


    }

    public static int[] getTicket() {
        int[] mass = new int[6];

        for (int i =0; i<mass.length; i++ ){}
        return mass;
    }

}
