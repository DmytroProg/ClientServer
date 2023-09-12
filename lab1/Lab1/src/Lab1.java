import java.util.Date;
import java.io.*;
import java.util.*;

public class Lab1 {
    private double a;
    private double b;
    private double x;

    private final double e = 2.7182;

    public Lab1(double a, double b, double x){
        setStartValues(a, b, x);
    }

    /*
     * Method for setting start variables
     * @param a variable a for equation
     * @param b variable b for equation
     * @param x variable x for equation
     * */
    public void setStartValues(double a, double b, double x){
        this.a = a;
        this.b = b;
        this.x = x;
    }

    /*
    * Method for calculating the function Y()
    * */
    public double calculateEquationY(){
        return b * Math.pow(Math.tan(x), 2) - (a / Math.pow(Math.sin(x / a), 2));
    }

    /*
     * Method for calculating the function D()
     * */
    public double calculateEquationD(){
        return a * Math.pow(e, -Math.sqrt(a)) * Math.cos(b * x / a);
    }

    /*
    * Method for displaying the variables' values and the functions' results
    * */
    public void showCalculationResults(){
        showVariables();
        System.out.println("-------------------");
        showEquationResults();
    }

    /*
     * Method for displaying the variables' values
     * */
    private void showVariables(){
        System.out.printf("a = %f\n", a);
        System.out.printf("b = %f\n", b);
        System.out.printf("x = %f\n", x);
    }

    /*
     * Method for displaying the functions' results
     * */
    private void showEquationResults(){
        System.out.printf("y = %f\n", calculateEquationY());
        System.out.printf("d = %f\n", calculateEquationD());
    }

    /*
    * Method for inputting values to variables a, b, x and showing the results of the function y and d
    * */
    public void inputValuesAndDisplayResults() {
        boolean isInput = true;
        while (isInput){
            try {
                inputValues();
                isInput = false;
            } catch (Exception ex) {
                System.out.println("Some error occured while setting values to the variables");
            }
        }

        showCalculationResults();
    }

    private void inputValues(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter variable a: ");
        a = scanner.nextDouble();
        System.out.print("Enter variable b: ");
        b = scanner.nextDouble();
        System.out.print("Enter variable x: ");
        x = scanner.nextDouble();
    }

    /*
    * Method for displaying current date
    * */
    public void showCurrentDate(){
        Date date = new Date();
        System.out.printf("Today: %1$ta %1$td %1$tB %1$tY", date);
    }

    /*
    * @param args the command line arguments
    * */
    public static void main(String[] args){
        Lab1 lab1 = new Lab1(1, 1, 1);
        lab1.inputValuesAndDisplayResults();
        lab1.showCurrentDate();
    }
}
