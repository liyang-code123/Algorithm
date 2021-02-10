package javaregular;

public class Enum {

    enum RainbowColor { RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE }



    public static void main(String[] args) {
        RainbowColor color = RainbowColor.RED;
        RainbowColor color1 = RainbowColor.valueOf("RED");
        int i = RainbowColor.BLUE.ordinal();
        System.out.println(color == color1);
        System.out.println(i);
    }
}
