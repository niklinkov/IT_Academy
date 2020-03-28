package Lesson_7;

public class AbsException extends Exception {
    private int[] mass;
    public int getValue(int x) {
        return mass[x];
    }
    public AbsException(String message, int[] mass) {
        super(message);
        this.mass=mass;
    }
}

class Abs {
    public static float getAbs (int[] mass) throws AbsException {
        int result=0;
        if (mass.length<1) throw new AbsException("Array is empty", mass);

        for (int value : mass) {
            result += value;
        }
        return (float)result/mass.length;
    }
}

class  MainEx {
    public static void main(String[] args) {
        try {
            double result = Abs.getAbs (new int[] {});
            System.out.println(result);
        } catch (AbsException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }
}
