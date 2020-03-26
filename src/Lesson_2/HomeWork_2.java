package Lesson_2;

import java.util.Scanner;

public class HomeWork_2 {

    static Scanner sc = new Scanner(System.in);  //сканер для ввода данных с консоли

    public static void main (String [] args) {

        int tries=5;
        String [] expression;
        float result=0;
        //вызов простого калькулятора
        calculator("введите выражение для вычисления, например \"2 + 2\"", tries,3);
        //вызов продвинутого калькулятора
        calculator("введите выражение для вычисления, например \"2 + 2 - 8 * 2 ...\"", tries,0);

    }


    public static void calculator (String msg, int tries, int maxLength) {
        boolean checkExpressionResult;
        String [] expression;
        do {
//            System.out.println(tries);
            expression=getExpressionFromConsole(msg);
            checkExpressionResult = checkExpression(expression, maxLength);
//            System.out.println(checkExpressionResult);
            tries=tries-1;
        }
        while (checkExpressionResult==false && tries>0);
        if (checkExpressionResult){
//            System.out.println("Длина массива="+expression.length);
            int i=0;
            float innerResult=Integer.parseInt(expression[i]);
            while (i+2<expression.length) {
                innerResult=calculateFloat(innerResult,Integer.parseInt(expression[i+2]),expression[i+1]);
                i=i+2;
            }
            StringBuilder stringForOut= new StringBuilder("");
            for (String s:expression) {stringForOut.append(s);}
//            System.out.println(stringForOut);
            System.out.println(stringForOut+"="+innerResult);

        }
        else System.out.println("Слишком много попыток ввода. Попробуйте в другой раз");
    }

    //Метод получающий выражение в виде массива строк из консоли
    public static String [] getExpressionFromConsole (String msg) {
        System.out.println(msg);  //сообщение для пользователя
        String scString = sc.nextLine(); //получение строки с консоли
        String [] stringFromConsole = scString.split(" ");  //формирование массива строк для анализа
       //        System.out.println(Arrays.toString(stringFromConsole));
        return stringFromConsole;
    }

    //метод анализирующий выражение с консоли
    //будет работать только если ввод начинается с числа и разделен пробелами
    public static boolean checkExpression (String [] rawExpression, int maxLength) {
        boolean checkResult=false;  //признак корректности введенного выражения
        //int [] numbers = new int[rawExpression.length];
        boolean arraySizeOK=false; //признак того что достаточно и не слишком много символов во введенном выражении
        boolean symbolsInArrayOK=false;  //признак корректности введенных символов
        //проверка размера массива
        if ((rawExpression.length>2 && (rawExpression.length<=maxLength) || maxLength==0)) {
            arraySizeOK=true;
//            System.out.println("size="+arraySizeOK);
            //проверка введенных символов, последовательность и значение
            //проверка что введено число
            for (int i=0; i<rawExpression.length; i++) {
                if (i==0 || (i % 2 == 0)) {
                    symbolsInArrayOK=rawExpression[i].matches("[-+]?\\d+");
                    //symbolsInArrayOK=isDigit(rawExpression[i]);
//                    System.out.println("digit("+i+")="+symbolsInArrayOK);
                    if (symbolsInArrayOK==false){
                        System.out.println("Не хватает чисел");
                    break;}}
                else {
            //проверка что введена доступная операция
                    if (rawExpression[i].matches("[+-/*]")) {
                        symbolsInArrayOK=true;
//                        System.out.println("symbol("+i+")="+symbolsInArrayOK);
                    }
                    else {
                        symbolsInArrayOK=false;
                        System.out.println("Недопустимая операция, доступные операции +, -, *,/");
                        break;}
                }
            }

        }
        else {
            arraySizeOK=false; //введенное выражение слишком короткое\длинное
            System.out.println("Не хватает операндов или слишком длинное выражение. Не забывайте ставить пробелы между чилсами");
        }

        checkResult=arraySizeOK && symbolsInArrayOK;  //елси все проверки пройдены вернуть 1
        //System.out.println("result="+checkResult);
        return checkResult;
    }


    //метод выччисляющий выражение
    public static float calculate (int a, int b, String operation) {
        float resultCalculation=0;
        switch (operation) {
            case "+" : resultCalculation=a+b; break;
            case "-" : resultCalculation=a-b; break;
            case "*" : resultCalculation=a*b; break;
            case "/" : resultCalculation=((b != 0) ? (a/(float)b) : 0);
        }
        return resultCalculation;
    }

    //метод позволяющий вычислять сложные выражения. На вход подается результат предыдущего вычисления (может быть не целым, если было деление) и следующее выражение
    public static float calculateFloat (float a, int b, String operation) {
        float resultCalculation=0;
        switch (operation) {
            case "+" : resultCalculation=a+b; break;
            case "-" : resultCalculation=a-b; break;
            case "*" : resultCalculation=a*b; break;
            case "/" : resultCalculation=((b != 0) ? (a/(float)b) : 0);
        }
        return resultCalculation;
    }
}
