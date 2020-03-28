package Lesson_7;

public class HomeTask7 {
    public static void main(String[] args) {
        Worker[] staff = new Worker[]{new Worker("Petrov", "20"), new Worker("Sidorov", "39"),
                new Worker("Ivanova", "twenty five"), new Worker("Smirnova", "56"), new Worker("Gorkiy", "125")};
        int[] ages = new int[staff.length];
        for (int i = 0; i < staff.length; i++) {
            System.out.println("surname: " + staff[i].getName() + ", age: " + staff[i].getAge());
            try {
                ages[i] = staff[i].ageToInt();
                System.out.println(ages[i]);
            } catch (StringToIntException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }
}
