package Lesson_4;

import java.util.Arrays;
import java.util.Random;

public class Caller {

    static Random random = new Random();

    public static void main (String [] args ){
        String [] fio = {"Petrov V.V.", "Sidorov P.P.", "Ivanov A.A.", "Chenov T.F.", "Fedorov F.F.", "Ulyanov V.A.", "Smirnova I.P."};
        Worker [] staff = new Worker[7];

        for (int i = 0; i < staff.length; i++) {
            staff[i]=new Worker(fio[i], 20000+random.nextInt(20000),18+random.nextInt(45));
//            System.out.println(staff[i].toString());
        }
        getListHighSalsryWorkers(staff, 30000);

    }

    public static void getListHighSalsryWorkers (Worker [] list, int maxSalary) {
        for (Worker i:list
        ) {
            if (i.getSalary() > maxSalary ) {
                System.out.println(i.toString());
            }

        }
    }

}
