package KI304.Kozak.Lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main class
 */
public class Main {
    public static void main(String[] args) {
        File fOutput = new File("Result.txt");
        PrintWriter fout = null;
        try {
            fout = new PrintWriter (fOutput);
            fout.flush();
        } catch (FileNotFoundException e) {
            try {
                fOutput.createNewFile();
                fout = new PrintWriter (fOutput);
                fout.flush();
            } catch (IOException ex) {
                System.err.println("Program can't create file to output result. Program is terminated");
                System.exit(-1);
            }
        }
        EquationResolver resolver = new EquationResolver();

        System.out.println("Input x: ");
        double x = 0;
        Scanner in1 = new Scanner(System.in);
        try {
            x = in1.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid value.");
            System.exit(-2);
        }
        double y = 0;
        try {
            y = resolver.calculate(x);
            BigDecimal bd = new BigDecimal(y).setScale(4, RoundingMode.HALF_UP);
            System.out.println("Result: y = " + bd);
            fout.println("Result: y = " + bd);
            fout.close();
        } catch (InfinityException e) {
            System.out.println("In value x equation reach infinity");
            fout.close();
        }
    }
}