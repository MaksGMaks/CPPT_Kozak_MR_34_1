package KI304.Kozak.Lab5;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Scanner;

import KI304.Kozak.Lab5.FileOperations;

/**
 * Main class
 */
public class Main {
    public static void main(String[] args) {
        EquationResolver resolver = new EquationResolver();
        FileOperations operator = new FileOperations();
        try {
            operator.clearTxt();
            operator.clearBin();
        } catch (IOException e) {
            System.err.println("Can't clear file. Program is terminated");
            System.exit(-5);
        }

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
            try {
                operator.writeLineTxt("Result: y = " + bd);
                operator.writeLineBin("Result: y = " + bd);
            } catch (IOException e) {
                System.err.println("Can't write to files");
            }
        } catch (InfinityException e) {
            System.out.println("In value x equation reach infinity");
        }

        try {
            System.out.println("TXT Output:");
            operator.readTxt();
            System.out.println("BIN Output:");
            operator.readBin();
        } catch (IOException e) {
            System.err.println("Can't read from files");
        }
    }
}