/**
 * Import requirement packages.
 */
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Declaration of main class.
 */

public class Lab1Kozak304 {
    /**
     * Main function of class; implements input logic from user and prepare data to generate matrix.
     * <p></p>
     * <b>It has 4 parameters inside</b>:
     * <li><b>rows</b> - amount of rows (get from user)</li>
     * <li><b>symbol</b> - character to fill matrix (get from user)</li>
     * <li><b>fOutput</b> - file, where program print result</li>
     * <li><b>fout</b> - file printer to print result</li>
     * <p></p>
     * Program output result in console and file.<p></p>
     * <pre><b>First step - prepare file</b></pre>
     * <p></p>
     * Program connects file to PrintWriter. If it doesn't exist, program try to create new file. If creating was failed, program exits with code -4. <p></p>
     * <pre><b>Second step - get data from user</b></pre>
     * <p></p>
     * Program informs user to input amount of rows and check if his input is correct and checks if input data is an int and only one int.
     * If user input more int data or it has one char, program exit with code -1.<p></p>
     * Next program checks if number of rows is bigger than 1.
     * <p></p>
     * After successfully rows input, program informs user to input symbol to fill matrix.
     * If user input more symbols or single word, program will exit with code -3.
     * @param args default for main
     * @throws IOException required to output data in file
     */
    public static void main(String[] args) throws IOException {
        int rows = 0;
        String symbol = "";

        File fOutput = new File("Matrix.txt");
        PrintWriter fout;
        if(fOutput.exists()) {
            fout = new PrintWriter (fOutput);
            fout.flush();
        } else {
            if(!fOutput.createNewFile()) {
                System.err.println("Program can't create file to output result. Program is terminated");
                System.exit(-4);

            }
            fout = new PrintWriter(fOutput);
            fout.flush();
        }

        System.out.println("Input number of rows");
        Scanner in1 = new Scanner(System.in);
        if(in1.hasNextLine()) {
            try {
                rows = Integer.valueOf(in1.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Program expect one int argument. You input too many arguments or another datatype. Program is terminated");
                fout.println("Program expect one int argument. You input too many arguments or another datatype. Program is terminated");
                fout.close();
                System.exit(-1);
            }

            if(rows <= 1) {
                System.err.println("Cannot generate pattern in matrix with " + rows + " rows. Amount should be divisible by 6. Program is terminated");
                fout.println("Cannot generate pattern in matrix with " + rows + " rows. Amount should be divisible by 6. Program is terminated");
                fout.close();
                System.exit(-2);
            }

        }

        System.out.println("Input symbol");
        Scanner in2 = new Scanner(System.in);
        if(in2.hasNextLine()) {
            symbol = in2.nextLine();
            if(symbol.length() > 1) {
                System.err.println("You input a word but program expects a char. Program is terminated");
                fout.println("You input a word but program expects a char. Program is terminated");
                fout.close();
                System.exit(-3);
            }
        }
        genMatrix(rows, symbol, fout);
        fout.close();
    }

    /**
     * Function, that generate and print matrix.
     * <p></p>
     * <b>It has 3 parameters inside</b>:
     * <li>matrix - jagged array with filled regions (it contains empty arrays for empty space)</li>
     * <li>size - width of filled region </li>
     * <li>column - const array of filled region (width 1)</li>
     * <p></p>
     * Because matrix must be jagged and contains only filled regions, it saves rotated data.
     * <br>
     * After matrix creating, program print data in right way into console and file
     * @param rows amount of rows in matrix (column too)
     * @param sym symbol of matrix filled regions
     * @param filePrinter printer to output data in file. Parameter because it needed to get error messages from main
     * @throws IOException required to output data in file
     */
    public static void genMatrix(int rows, String sym, PrintWriter filePrinter) throws IOException {
        String[][] matrix = new String[rows][];
        int size = rows / 2;
        String[] column = new String[size];

        for(int i = 0; i < size; i++)
        {
            column[i] = sym;
        }

        for(int i = 0; i < rows; i++) {
            matrix[i] = Arrays.copyOf(column, column.length);
        }

        System.out.println("Matrix:");
        filePrinter.println("Matrix:");
        for(int i = 0; i < rows; i++) {
            for(int j = 0, k = 0; j < rows; j++) {
                if(j % 2 == 0) {
                    System.out.print(" ");
                    filePrinter.print(" ");
                } else {
                    System.out.print(matrix[i][k]);
                    filePrinter.print(matrix[i][k]);
                    k++;
                }
            }
            System.out.println();
            filePrinter.println();
        }
    }
}