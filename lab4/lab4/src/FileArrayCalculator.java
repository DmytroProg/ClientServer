import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileArrayCalculator implements ArrayProcessor, DoubleArrayReader{

    @Override
    public double calculate(double[] array) {
        double sum = 0;
        for(double number : array){
            sum += Math.pow(number, 2);
        }

        return sum;
    }

    @Override
    public double calculate(double[][] array) {
        double sum = 0;
        for(double[] subArray : array){
            for(double number : subArray){
                sum += Math.pow(number, 2);
            }
        }

        return sum;
    }

    @Override
    public void processArray(double[] array) {
        for(double number : array){
            System.out.print(number + " ");
        }
    }

    @Override
    public void processArray(double[][] array) {
        for(double[] subArray : array){
            for(double number : subArray){
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    @Override
    public double[] readOneDimensionalArray(File file) {
        try (Scanner in = new Scanner(file)) {
            int n = in.nextInt();
            double[] arr = new double[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = in.nextDouble();
            }
            return arr;
        }
        catch (IOException ex) {
            System.err.println("Error reading file");
            return null;
        }
    }

    @Override
    public double[] readOneDimensionalArray(String fileName) {
        try (Scanner in = new Scanner(new File(fileName))) {
            int n = in.nextInt();
            double[] arr = new double[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = in.nextDouble();
            }
            return arr;
        }
        catch (IOException ex) {
            System.err.println("Error reading file");
            return null;
        }
    }

    @Override
    public double[][] readTwoDimensionalArray(File file) {
        return new double[0][];
    }

    @Override
    public double[][] readTwoDimensionalArray(String fileName) {
        return new double[0][];
    }
}
