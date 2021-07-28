package ov;

//public class ChristmasTree {
//    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10 - i; j++) {
//                System.out.println(" ");
//            }
//            for (int k = 0; k < (2 * i + 1); k++) {
//                System.out.println("*");
//            }
//            System.out.println();
//        }
//    }
//}

public class ChristmasTree {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10 - i; j++)
                System.out.print(" ");
            for (int k = 0; k < (2 * i + 1); k++)
                System.out.print("*");
            System.out.println();
        }
    }
}
