package KI304.Kozak.Lab5;

import java.io.*;

/**
 * Class for file operations
 */
public class FileOperations {
    private final File txtOutput = new File("Result.txt");
    private RandomAccessFile txtout = null;
    private final File binOutput = new File("Result.bin");
    private RandomAccessFile binout = null;

    /**
     * Initialize operator. Find files or create new if they don't exist.
     */
    public FileOperations() {
        try {
            txtout = new RandomAccessFile(txtOutput, "rw");
            try{
                txtout.close();
            } catch (IOException close) {
                System.err.println("Program can't close txt file. Program is terminated");
                System.exit(-1);
            }
        } catch (FileNotFoundException e) {
            try {
                if(txtOutput.createNewFile()) {
                    txtout = new RandomAccessFile(txtOutput, "rw");
                    txtout.close();
                }
            } catch (IOException ex) {
                System.err.println("Program can't create txt file to output result. Program is terminated");
                System.exit(-2);
            }
        }

        try {
            binout = new RandomAccessFile(binOutput, "rw");
            try{
                binout.close();
            } catch (IOException close) {
                System.err.println("Program can't close bin file. Program is terminated");
                System.exit(-3);
            }
        } catch (FileNotFoundException e) {
            try {
                if(binOutput.createNewFile()) {
                    binout = new RandomAccessFile(txtOutput, "rw");
                    binout.close();
                }
            } catch (IOException ex) {
                System.err.println("Program can't create bin file to output result. Program is terminated");
                System.exit(-4);
            }
        }
    }

    /**
     * Clear data from TXT file
     * @throws IOException to inform about exception
     */
    public void clearTxt() throws IOException {
        txtout = new RandomAccessFile(txtOutput, "rw");
        txtout.setLength(0);
        txtout.close();
    }

    /**
     * Clear data from BIN file
     * @throws IOException to inform about exception
     */
    public void clearBin() throws IOException {
        binout = new RandomAccessFile(txtOutput, "rw");
        binout.setLength(0);
        binout.close();
    }

    /**
     * Write text from message continuously to TXT
     * @param message message to write into
     * @throws IOException to inform about exception
     */
    public void writeTxt(String message) throws IOException {
        txtout = new RandomAccessFile(txtOutput, "rw");
        txtout.seek(txtout.length());
        txtout.writeBytes(message);
        txtout.close();
    }

    /**
     * Write text from message to TXT file from last place but at the end start new line
     * @param message message to write into
     * @throws IOException to inform about exception
     */
    public void writeLineTxt(String message) throws IOException {
        txtout = new RandomAccessFile(txtOutput, "rw");
        txtout.seek(txtout.length());
        txtout.writeBytes(message + "\n");
        txtout.close();
    }

    /**
     * Write text from message continuously to BIN
     * @param message message to write into
     * @throws IOException to inform about exception
     */
    public void writeBin(String message) throws IOException {
        binout = new RandomAccessFile(binOutput, "rw");
        binout.seek(binout.length());
        binout.writeBytes(message);
        binout.close();
    }

    /**
     * Write text from message to BIN file from last place but at the end start new line
     * @param message message to write into
     * @throws IOException to inform about exception
     */
    public void writeLineBin(String message) throws IOException {
        binout = new RandomAccessFile(binOutput, "rw");
        binout.seek(binout.length());
        binout.writeBytes(message + "\n");
        binout.close();
    }

    /**
     * Read all data from TXT file and output it to console
     * @throws IOException to inform about exception
     */
    public void readTxt() throws IOException {
        txtout = new RandomAccessFile(txtOutput, "r");
        txtout.seek(0);
        String line;
        while ((line = txtout.readLine()) != null) {
            System.out.println(line);
        }
        txtout.close();
    }

    /**
     * Read all data from BIN file and output it to console
     * @throws IOException to inform about exception
     */
    public void readBin() throws IOException {
        binout = new RandomAccessFile(binOutput, "r");
        binout.seek(0);
        String line;
        while ((line = binout.readLine()) != null) {
            System.out.println(line);
        }
        binout.close();
    }
}
