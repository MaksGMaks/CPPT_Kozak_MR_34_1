package KI304.Kozak.Lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

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
    static PowerSupply powerSupply3 = new PowerSupply(true, true, 0, 0);

    /**
     * Initialize all variables and start menu loop
     * @param args default
     * @throws IOException to provide file write
     */
    public static void main(String[] args) throws IOException {
        MobilePhone mobilePhone1 = new MobilePhone(fout, 5, false, mainLine, true, false, 500, 250, "0968473646");
        MobilePhone mobilePhone2 = new MobilePhone(fout, phoneHandset2, mainLine, true, true, 300, 100, "0658324777");
        MobilePhone mobilePhone3 = new MobilePhone(fout, phoneHandset3, mainLine, powerSupply3, "0937363533");

        MobilePhone[] phoneList = {mobilePhone1, mobilePhone2, mobilePhone3};

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
    private static boolean menuFunction(PrintWriter fout, MobilePhone[] phones) throws FileNotFoundException {
        int selector = 0;
        System.out.println("\t\tSelect phone:");
        System.out.println("\t1 - Samsung");
        System.out.println("\t2 - Iphone");
        System.out.println("\t3 - LG");
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
                System.out.println("\n\t\tPhone \"Samsung\" selected\n");
                fout.println("\n\t\t\t- - - - - Phone \"Samsung\" selected - - - - -\n");
                while (phoneSubmenu(fout, phones[0], phones)) {
                    continue;
                }
                break;

            case 2:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("\n\t\tPhone \"Iphone\" selected\n");
                fout.println("\n\t\t\t- - - - - Phone \"Iphone\" selected - - - - -\n");
                while (phoneSubmenu(fout, phones[1], phones)) {
                    continue;
                }
                break;

            case 3:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("\n\t\tPhone \"LG\" selected\n");
                fout.println("\n\t\t\t- - - - - Phone \"LG\" selected - - - - -\n");
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
    private static boolean phoneSubmenu(PrintWriter fout, MobilePhone sender, MobilePhone[] phones) throws FileNotFoundException {
        int selector = 0;
        System.out.println("\t\tSelect action:");
        System.out.println("\t1 - Status");
        System.out.println("\t2 - Call history");
        System.out.println("\t3 - Clear call history");
        System.out.println("\t4 - Message history");
        System.out.println("\t5 - Update message history");
        System.out.println("\t6 - Clear message history");
        System.out.println("\t7 - Make call");
        System.out.println("\t8 - Mute microphone");
        System.out.println("\t9 - Unmute microphone");
        System.out.println("\t10 - Increase volume");
        System.out.println("\t11 - Decrease volume");
        System.out.println("\t12 - Connect");
        System.out.println("\t13 - Disconnect");
        System.out.println("\t14 - Change number");
        System.out.println("\t15 - Plug in");
        System.out.println("\t16 - Unplug");
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
                fout.println("\n\t\tAction \"Clear call history\" selected\n");
                sender.clearHistory();
                break;

            case 4:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                fout.println("\n\t\tAction \"Message history\" selected\n");
                sender.getMessageHistory();
                break;

            case 5:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                fout.println("\n\t\tAction \"Update message history\" selected\n");
                sender.updateMessage();
                break;

            case 6:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                fout.println("\n\t\tAction \"Clear message history\" selected\n");
                sender.clearMessageHistory();
                break;

            case 7:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                fout.println("\n\t\tAction \"Make call\" selected\n");
                while (selectCaller(sender, phones)) {
                    continue;
                }
                break;

            case 8:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                fout.println("\n\t\tAction \"Mute microphone\" selected\n");
                sender.mute();
                break;

            case 9:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                fout.println("\n\t\tAction \"Unmute microphone\" selected\n");
                sender.unmute();
                break;

            case 10:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                fout.println("\n\t\tAction \"Increase volume\" selected\n");
                sender.increaseVolume();
                break;

            case 11:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                fout.println("\n\t\tAction \"Decrease volume\" selected\n");
                sender.decreaseVolume();
                break;

            case 12:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                fout.println("\n\t\tAction \"Connect\" selected\n");
                sender.setConnected();
                break;

            case 13:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                fout.println("\n\t\tAction \"Disconnect\" selected\n");
                sender.setDisconnected();
                break;

            case 14:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                fout.println("\n\t\tAction \"Change number\" selected\n");
                Scanner num = new Scanner(System.in);
                if(num.hasNext())
                    sender.changeNumber(num.next());
                break;

            case 15:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                fout.println("\n\t\tAction \"Plug in\" selected\n");
                sender.setPlugged();
                break;

            case 16:
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
    private static boolean selectCaller(MobilePhone sender, MobilePhone[] phones) throws FileNotFoundException {
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