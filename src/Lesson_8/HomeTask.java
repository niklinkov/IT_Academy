package Lesson_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class HomeTask {

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add(0,"Petr");
        names.add(1,"Lisa");
        names.add(2,"Lev");
        names.add(3,"Nina");
        names.add(4,"Lev");
        names.add(5,"Nina");
        names.add(6,"Ilia");
        names.add(7,"Nina");


        Integer item;

        HashMap<String, Integer> hm = new HashMap<>();

        for (String wrd : names) {

            //System.out.println("++++++"+hm.get(wrd));
            item=hm.get(wrd);
            if (!hm.containsKey(wrd)) {
                hm.put(wrd, 1);
            } else
                hm.put(wrd, item+=1);

//            item = hm.get(wrd);
//            if (item == null) hm.put(wrd, 1); // если нет в списке то добавить со значением 1
//            else hm.put(wrd, item + 1); // если есть такая фамилия(Key), то +1
        }


        System.out.println(" ");
        System.out.println("Всего фамилий в списке: " + names.size());
        System.out.println("Всего уникальных фамилий в списке: " + hm.size());
        System.out.println("Имена и колличество раз их упоминания:");
        System.out.println(hm);



//        for (String s: names
//             ) {
//            System.out.println(s.hashCode());
//        }


    }



}
