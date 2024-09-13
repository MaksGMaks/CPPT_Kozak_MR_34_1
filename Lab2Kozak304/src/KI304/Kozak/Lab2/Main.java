package KI304.Kozak.Lab2;

import KI304.Kozak.Lab2.*;

import java.io.*;
import java.util.Scanner;

/**
 * Main class of program
 * <pre><b>Parameters:</b></pre>
 * <li><b>fOutput</b> - file with program work result</li>
 * <li><b>fout</b> - file printer</li>
 * <li><b>mainLine</b> - main phone line, which provide connection between them</li>
 * <p></p>
 * <pre><b>Phones and their components:</b></pre>
 * <li><b>phone1</b> - first phone, construct from all parameters</li>
 * <li><b>phoneHandset2</b> - handset for phone2</li>
 * <li><b>phone2</b> - second phone, constructed with phoneHandset2</li>
 * <li><b>phoneHandset3</b> - handset for phone3</li>
 * <li><b>powerSupply3</b> - powersupply for phone3</li>
 * <li><b>phone3</b> - third phone, constructed with phoneHandset3 and powerSupply3</li>
 */
public class Main {

    static File fOutput = new File("DriverProtocol.txt");;
    static PrintWriter fout;

    static {
        try {
            fout = new PrintWriter(fOutput);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    static PhoneLine mainLine = new PhoneLine(fout);

    static Handset phoneHandset2 = new Handset(7, true);

    static Handset phoneHandset3 = new Handset(1, true);
    static PowerSupply powerSupply3 = new PowerSupply(false, true, 0, 0);

    public Main() throws FileNotFoundException {
    }

    /**
     * Initialize all variables and start menu loop
     * @param args default
     * @throws IOException to provide file write
     */
    public static void main(String[] args) throws IOException {
        PhoneLine mainLine = new PhoneLine(fout);
        // Phone 1 with all parameters
        Phone phone1 = new Phone(fout, 5, false, mainLine, true, false, 500, 250, "0968473646");

        // Phone 2 with prepared handset
        Handset phoneHandset2 = new Handset(7, true);
        Phone phone2 = new Phone(fout, phoneHandset2, mainLine, true, true, 300, 100, "0658324777");

        // Phone 3 with all prepared

        Phone phone3 = new Phone(fout, phoneHandset3, mainLine, powerSupply3, "0937363533");

        Phone[] phoneList = {phone1, phone2, phone3};

        System.out.print("\033[H\033[2J");
        System.out.flush();

        while (menuFunction(fout, phoneList)) {
            continue;
        }
        fout.close();
    }


    /**
     * Menu, which appears all time if you don't select exit
     * @param fout file printer
     * @param phones all phones
     * @return <b>true</b> if choose wrong
     * <b>false</b> if choose right to close loop
     * @throws FileNotFoundException to provide file write
     */
    private static boolean menuFunction(PrintWriter fout, Phone[] phones) throws FileNotFoundException {
        int selector = 0;
        System.out.println("\t\tSelect phone:");
        System.out.println("\t1 - Motorola DynaTAC 8000X");
        System.out.println("\t2 - Fe TAp 615");
        System.out.println("\t3 - Frankfurt \"Bauhaus\"");
        System.out.println("\t0 - Exit");

        Scanner inp = new Scanner(System.in);
        try {
            selector = Integer.parseInt(inp.nextLine());
        } catch (NumberFormatException e) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("\tWrong number occurs. Please enter correct one from list");
            return true;
        }
        switch (selector) {
            case 1:
                System.out.print("\033[H\033[2J");   
                System.out.flush();
                System.out.println("\n\t\tPhone \"Motorola DynaTAC 8000X\" selected\n");
                fout.println("\n\t\t\t- - - - - Phone \"Motorola DynaTAC 8000X\" selected - - - - -\n");
                while (phoneSubmenu(fout, phones[0], phones)) {
                    continue;
                }
                break;

            case 2:
                System.out.print("\033[H\033[2J");   
                System.out.flush();
                System.out.println("\n\t\tPhone \"Fe TAp 615\" selected\n");
                fout.println("\n\t\t\t- - - - - Phone \"Fe TAp 615\" selected - - - - -\n");
                while (phoneSubmenu(fout, phones[1], phones)) {
                    continue;
                }
                break;

            case 3:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("\n\t\tPhone \"Frankfurt \"Bauhaus\"\" selected\n");
                fout.println("\n\t\t\t- - - - - Phone \"Frankfurt \"Bauhaus\"\" selected - - - - -\n");
                while (phoneSubmenu(fout, phones[2], phones)) {
                    continue;
                }
                break;

            case 0:
                System.out.println();
                fout.println("\n\t\t\tX X X X X - Action \"Exit\" selected - X X X X X\n");
                return false;
            default:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("\tWrong number occurs. Please enter correct one from list");
        }
        System.out.println();
        return true;
    }

    /**
     *
     * @param fout file printer
     * @param sender phone which make call
     * @param phones all phones
     * @return <b>true</b> if choose wrong
     * <b>false</b> if choose right to close loop
     * @throws FileNotFoundException to provide file write
     */
    private static boolean phoneSubmenu(PrintWriter fout, Phone sender, Phone[] phones) throws FileNotFoundException {
        int selector = 0;
        System.out.println("\t\tSelect action:");
        System.out.println("\t1 - Status");
        System.out.println("\t2 - Call history");
        System.out.println("\t3 - Clear history");
        System.out.println("\t4 - Make call");
        System.out.println("\t5 - Mute microphone");
        System.out.println("\t6 - Unmute microphone");
        System.out.println("\t7 - Increase volume");
        System.out.println("\t8 - Decrease volume");
        System.out.println("\t9 - Connect");
        System.out.println("\t10 - Disconnect");
        System.out.println("\t11 - Change number");
        System.out.println("\t12 - Plug in");
        System.out.println("\t13 - Unplug");
        System.out.println("\t0 - Back");

        Scanner inp = new Scanner(System.in);
        try {
            selector = Integer.parseInt(inp.nextLine());
        } catch (NumberFormatException e) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("\tWrong number occurs. Please enter correct one from list");
            return true;
        }
        switch (selector) {
            case 1:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                fout.println("\n\t\tAction \"Status\" selected\n");
                sender.getStatus();
                break;

            case 2:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                fout.println("\n\t\tAction \"Call history\" selected\n");
                sender.getHistory();
                break;

            case 3:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                fout.println("\n\t\tAction \"Clear history\" selected\n");
                sender.clearHistory();
                break;

            case 4:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                fout.println("\n\t\tAction \"Make call\" selected\n");
                while (selectCaller(sender, phones)) {
                    continue;
                }
                break;

            case 5:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                fout.println("\n\t\tAction \"Mute microphone\" selected\n");
                sender.mute();
                break;

            case 6:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                fout.println("\n\t\tAction \"Unmute microphone\" selected\n");
                sender.unmute();
                break;

            case 7:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                fout.println("\n\t\tAction \"Increase volume\" selected\n");
                sender.increaseVolume();
                break;

            case 8:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                fout.println("\n\t\tAction \"Decrease volume\" selected\n");
                sender.decreaseVolume();
                break;

            case 9:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                fout.println("\n\t\tAction \"Connect\" selected\n");
                sender.setConnected();
                break;

            case 10:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                fout.println("\n\t\tAction \"Disconnect\" selected\n");
                sender.setDisconnected();
                break;

            case 11:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                fout.println("\n\t\tAction \"Change number\" selected\n");
                Scanner num = new Scanner(System.in);
                if(num.hasNext())
                    sender.changeNumber(num.next());
                break;

            case 12:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                fout.println("\n\t\tAction \"Plug in\" selected\n");
                sender.setPlugged();
                break;

            case 13:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                fout.println("\n\t\tAction \"Unplug\" selected\n");
                sender.setUnplugged();
                break;

            case 0:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                fout.println("\n\t\t\t- - - - - Action \"Back\" selected - - - - -\n");
                System.out.println();
                return false;
            default:
                System.out.println("\tWrong number occurs. Please enter correct one from list");
                fout.println("\tWrong number occurs. Action stopped");
        }
        System.out.println();
        return true;
    }

    /**
     * Call selection menu
     * @param sender phone which make call
     * @param phones all phones
     * @return <b>true</b> if choose wrong
     * <b>false</b> if choose right to close loop
     * @throws FileNotFoundException to provide file write
     */
    private static boolean selectCaller(Phone sender, Phone[] phones) throws FileNotFoundException {
        int selector = 0;
        boolean rightInp = false;

        while (!rightInp) {
            System.out.println("\t\tSelect receiver:");
            int numbers = 1;
            int sendNum = 0;
            for(Phone phone : phones) {
                if(phone != sender) {
                    System.out.println("\t" + numbers + " - " + phone.getNumber());
                } else {
                    sendNum = numbers;
                }
                numbers++;

            }
            System.out.println("\t0 - Back");

            Scanner inp = new Scanner(System.in);
            try {
                selector = Integer.parseInt(inp.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("\tWrong number occurs. Please enter correct one from list");
                return true;
            }

            if(selector > numbers || selector < 0 || selector == sendNum) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("\tWrong number occurs. Please enter correct one from list");
            } else {
                rightInp = true;
            }
        }
        System.out.println();

        if(selector == 0) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            return false;
        }


        System.out.print("\033[H\033[2J");
        System.out.flush();
        sender.makeCall(phones[selector - 1]);
        return false;
    }
}