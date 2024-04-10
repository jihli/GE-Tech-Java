package HW2;
import java.util.Scanner;

public class FahrenheitToCelsius {
    public static void main(String[] args) {
        final int MAX_TEMP = 140;
        final int MIN_PARK_TEMP = 70;
        final int MAX_PARK_TEMP = 90;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Fahrenheit value: ");
        int fahrenheit = input.nextInt();

        System.out.println(fahrenheit >= MAX_TEMP);

    }
}
