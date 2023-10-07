import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FigureArrayCalculator implements ArrayProcessor, DoubleArrayReader{
    @Override
    public double calculate(double[] array) {
        return 0;
    }

    @Override
    public double calculate(double[][] array) {
        double sum = 0;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j <= i; j++){
                if(array[i][j] > 0){
                    sum += array[i][j];
                }
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
        return new double[0];
    }

    @Override
    public double[] readOneDimensionalArray(String fileName) {
        return new double[0];
    }

    @Override
    public double[][] readTwoDimensionalArray(File file) {
        try (Scanner in = new Scanner(file)) {
            int n = in.nextInt();
            double[][] arr = new double[n][];
            for (int i = 0; i < n; i++) {
                arr[i] = new double[n];
                for(int j = 0; j < n; j++) {
                    arr[i][j] = in.nextDouble();
                }
            }
            return arr;
        }
        catch (IOException ex) {
            System.err.println("Error reading file");
            return null;
        }
    }

    @Override
    public double[][] readTwoDimensionalArray(String fileName) {
        try (Scanner in = new Scanner(new File(fileName))) {
            int n = in.nextInt();
            double[][] arr = new double[n][];
            for (int i = 0; i < n; i++) {
                arr[i] = new double[n];
                for(int j = 0; j < n; j++) {
                    arr[i][j] = in.nextDouble();
                }
            }
            return arr;
        }
        catch (IOException ex) {
            System.err.println("Error reading file");
            return null;
        }
    }
}
