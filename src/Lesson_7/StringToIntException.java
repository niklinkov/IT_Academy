package Lesson_7;

public class StringToIntException extends Exception {
    private String string;

    public StringToIntException(String message, String str) {
        super(message);
        this.string=str;
    }

    //вернуть строку приведшую к ошибке
    public String getString() {
        return string;
    }
}
