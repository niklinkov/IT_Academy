package Lesson_7;

class Theory {
    public static void main(String[] args) {
        int x,y;
//        try {
//            int [] mass = {1,2,3,4};
//            x=0;
//            y=11/x;
//            mass[20]=30;
//            System.out.println("Message to console");
//        } catch (ArrayIndexOutOfBoundsException e) {
//            e.printStackTrace();
//            System.out.println("Index out of bounds");
//        } catch (ArithmeticException e) {
//            e.printStackTrace();
//            System.out.println("Zero division");
//        }
//        System.out.println("Stop process");
        //a();

//        try {
//            System.out.println(calc(-10));
//        } catch (ArithmeticException e) {
//            System.out.println("Enter other number");
//        }




    }

    public static void a() {
        int a=11/0;
    }

    public static int calc (int n) {
        if (n>0) {
            return n*2;
        } throw new ArithmeticException("negative namber is prohibited");
    }
    

}
