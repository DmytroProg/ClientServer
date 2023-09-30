import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a text:");
        String inputText = scanner.nextLine();

        System.out.println("The text before changing: " + inputText);
        inputText = TextManager.replace(inputText);
        System.out.println("The text after changing: " + inputText);
    }
}