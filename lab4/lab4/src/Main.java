
public class Main {
    public static void main(String[] args){
        FileArrayCalculator fileArrayCalculator = new FileArrayCalculator();
        double[] array = fileArrayCalculator.readOneDimensionalArray("lab4Text.txt");
        fileArrayCalculator.processArray(array);
        double sum = fileArrayCalculator.calculate(array);
        System.out.println("\nSum = " + sum);

        FigureArrayCalculator figureArrayCalculator = new FigureArrayCalculator();
        double[][] figureArray = figureArrayCalculator.readTwoDimensionalArray("lab4_2Text.txt");
        figureArrayCalculator.processArray(figureArray);
        double figureSum = figureArrayCalculator.calculate(figureArray);
        System.out.println("\nSum = " + figureSum);
    }
}