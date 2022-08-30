package main.java.com.numberOfLuke;

public class Main {
    public static void main(String[] args) {
        NumberOfLuke number = new NumberOfLuke();
        number.LukeNumbers();
        number.findSum(3);
        System.out.println(number);

        NumberOfLuke number2 = new NumberOfLuke(8);
        number2.LukeNumbers();
        number2.findSum(5);
        System.out.println(number2);
    }
}