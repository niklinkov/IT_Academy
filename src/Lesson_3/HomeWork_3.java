package Lesson_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class HomeWork_3 {
    static Scanner sc = new Scanner(System.in);  //сканер для ввода данных с консоли
    static String filePath = "E:\\ОбучениеJava\\Тема3\\ТестовыйМассив.txt";
    static File file = new File(filePath);
    static Scanner scFile;

    static {
        try {
            scFile = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static int[] testArray = {1, 2, 3,2,3,1,1,1,1,3};  //тестовый массив
    static int[] foresterArray = {5, 1, 5, 2, 2, 4, 1, 4, 5, 1, 5, 3, 2, 4, 4, 4, 5, 1, 3, 4,
            2, 2, 1, 2, 4, 4, 4, 5, 4, 3, 5, 4, 4, 5, 5, 1, 4, 1, 5, 3, 1, 4, 5, 3, 3, 4, 2, 2,
            4, 4, 5, 5, 1, 1, 1, 4, 5, 5, 4, 4, 2, 4, 3, 1, 3, 3, 1, 1, 3, 1, 3, 4, 4, 3, 2, 2,
            1, 3, 4, 4, 2, 3, 4, 2, 4, 4, 1, 4, 4, 4, 2, 1, 2, 4, 1, 5, 2, 2, 5, 4, 2, 2, 3, 1,
            5, 5, 3, 5, 3, 1, 4, 5, 4, 2, 1, 3, 1, 2, 1, 4, 1, 3, 4, 2, 2, 5, 2, 3, 1, 1, 2, 3,
            3, 4, 4, 2, 4, 1, 2, 2, 2, 5, 1, 5, 1, 2, 2, 1, 3, 3, 4, 3, 5, 3, 5, 1, 2, 1, 3, 3,
            2, 4, 1, 4, 3, 5, 1, 2, 1, 2, 3, 2, 1, 3, 2, 2, 4, 3, 2, 1, 5, 1, 4, 5, 4, 4, 5, 5,
            4, 2, 3, 5, 1, 3, 4, 3, 2, 4, 5, 2, 5, 2, 4, 1, 4, 5, 2, 3, 3, 4, 4, 3, 5, 2, 2, 3,
            5, 1, 2, 4, 3, 4, 4, 3, 2, 2, 1, 4, 5, 5, 1, 5, 2, 4, 5, 5, 4, 2, 2, 1, 5, 1, 3, 4,
            2, 4, 2, 2, 4, 3, 5, 2, 2, 4, 4, 4, 5, 5, 2, 5, 5, 2, 5, 1, 1, 5, 5, 4, 1, 2, 4, 1,
            2, 2, 5, 4, 5, 1, 5, 4, 4, 5, 5, 5, 3, 3, 4, 3, 3, 5, 3, 2, 2, 2, 2, 2, 1, 2, 5, 2,
            3, 4, 3, 5, 5, 2, 4, 5, 3, 4, 3, 1, 3, 2, 1, 1, 5, 4, 4, 2, 3, 1, 3, 4, 2, 4, 1, 3,
            5, 1, 5, 3, 5, 2, 3, 4, 4, 1, 3, 1, 5, 5, 1, 2, 2, 1, 3, 1, 5, 1, 2, 2, 1, 5, 1, 3,
            3, 2, 1, 3, 2, 5, 1, 1, 2, 3, 5, 5, 4, 3, 1, 3, 3, 1, 5, 4, 2, 3, 4};
//    static File file = new File();
//    static int[] testArray2 = {1, 2, 3,2,3,1,1,1,1,3};  //доступные операции

    public static void main (String [] args) {
        //вывод тестового массива
        System.out.println(Arrays.toString(numbersInArray(testArray,1,3)));
        //получение массива с консоли
        //int[] testArray2 = getArrayFromConsole("введите массив для вычисления");
        //получение массива из файла
//        int[] testArray2 = getArrayFromFile("введите массив для вычисления");
//        arrayTtoString(numbersInArray(testArray2,1,20),1,20);
        //обработка маасива лесника (статический массив)
        arrayTtoString(numbersInArray(foresterArray,1,20),1,20);

        //        for (int numbers:(result)
//             ) {
//            System.out.println(numbers);
//        }
        //System.out.println(Arrays.toString(numbersInArray(testArray2,20)));

    }

    //Метод считающий кол-во чисел в массиве, на вход подается массив и максимальное число. Например массив чисел от 1 до maxN.
    public static int[] numbersInArray (int [] inputArray, int minN, int maxN) {
        int [] numbersInArray = new int[maxN-minN+1]; //Создаем массив для подсчета элекментов
        //заполняем массив, увеличивая счетчик для каждого числа в диапазоне от min до max
        for (int i = 0; i < inputArray.length; i++) {
            numbersInArray[inputArray[i]-1]=numbersInArray[inputArray[i]-1]+1;
//            System.out.println(numbersInArray[inputArray[i]-1]);
        }

//        return arrayWithoutZeros(numbersInArray);
        return numbersInArray;
    }

    //Метод получающий строку из консоли
    public static int[] getArrayFromConsole (String msg) {
        System.out.println(msg);  //сообщение для пользователя

        //формируем массив чисел из введеной строки
        //в идеале нужена проверка введенных символов и выход за границу отдельных элементов массива
        int [] inputArry = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        //String [] stringFromConsole = sc.nextLine().split(" ");  //получение строки с консоли
        //Анализ полеченной строки

        // System.out.println(Arrays.toString(inputArry));
        return inputArry;
    }

    //Метод получающий строку из файла
    public static int[] getArrayFromFile (String msg) {
        //System.out.println(msg);  //сообщение для пользователя
        //формируем массив чисел из введеной строки
        //в идеале нужена проверка введенных символов и выход за границу отдельных элементов массива
        int [] inputArry = Arrays.stream(scFile.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        //String [] stringFromConsole = sc.nextLine().split(" ");  //получение строки с консоли
        //Анализ полеченной строки

        System.out.println(Arrays.toString(inputArry));
        return inputArry;
    }

    //метод вывода форматированного массива с числами, без нулевых значений
    public static void arrayTtoString (int [] inArray, int minN, int maxN) {
        for (int i = 0; i < inArray.length; i++) {
            if (inArray[i] > 0) {
                System.out.println(minN + i + "=" + inArray[i]);
            }
        }
    }


//    static Scanner sc = new Scanner(System.in);  //сканер для ввода данных с консоли
//    static int[] testArray = {1, 2, 3,2,3,1,1,1,1,3};  //доступные операции
//    static String filePath = "E:\\ОбучениеJava\\Тема3";
//    static File file = new File(filePath);
////    static int[] testArray2 = {1, 2, 3,2,3,1,1,1,1,3};  //доступные операции
//
//    public static void main (String [] args) {
//
//    int[] testArray2 = getArryFromConsole("введите массив для вычисления");
//        System.out.println(Arrays.toString(numbersInArray(testArray,3)));
//        System.out.println(Arrays.toString(numbersInArray(testArray2,20)));
//}
////Метод считающий кол-во чисел в массиве, на вход подается массив и максимальное число. Например массив чисел от 1 до maxN.
//    public static int[] numbersInArray (int [] inputArray, int maxN) {
//        int [] numbersInArray = new int[maxN]; //Создаем массил для подсчета элекментов
////        for (int i:inputArray
////             ) {
////            numbersInArray[inputArray[i]-1]=numbersInArray[inputArray[i]-1]+1;
////        }
//        for (int i = 0; i < inputArray.length; i++) {
//            numbersInArray[inputArray[i]-1]=numbersInArray[inputArray[i]-1]+1;
////            System.out.println(numbersInArray[inputArray[i]-1]);
//        }
//        return numbersInArray;
//    }
//
//    //Метод получающий строку из консоли
//    public static int[] getArryFromConsole (String msg) {
//        System.out.println(msg);  //сообщение для пользователя
//        int [] inputArry = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        //String [] stringFromConsole = sc.nextLine().split(" ");  //получение строки с консоли
//        //Анализ полеченной строки
//
//        System.out.println(Arrays.toString(inputArry));
//        return inputArry;
//    }
}
