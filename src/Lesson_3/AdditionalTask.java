package Lesson_3;

public class AdditionalTask {

    public static void main (String [] args) {
        String testSentense="Предложение    один     Предложение    два    Предложение    три.";
        String modifiedSentence = stringToNormal(testSentense);
        System.out.println(modifiedSentence);
    }

    public static String stringToNormal (String sourse) {
        //убираем пробелы
        String onlyOneSpace = sourse.replaceAll(" +"," ");
        //создаем строку для изменений
        StringBuilder modifyString = new StringBuilder(onlyOneSpace);
//        char testChar = modifyString.charAt(0);
        //созадем переменную, которая учитывает кол-во добавленных символов
        int offset=0;
        //в цикле ищем заглавные буквы и вставляем точки перед ними. До пробела
        for (int i=1; i<onlyOneSpace.length(); i++) {
            //условие принадлежност символаа заглавным буквам
            if (onlyOneSpace.charAt(i)>='А' && onlyOneSpace.charAt(i)<='Я') {
                //modifyString.setCharAt(i-1, '.');
                //вставить пробел
                modifyString.insert(i+offset-1,'.');
                //если вставили символ увеличить смещение
                offset=offset+1;
            }
        }
//        System.out.println(testChar);
        String out = new String(modifyString);
        return out;
    }
}



