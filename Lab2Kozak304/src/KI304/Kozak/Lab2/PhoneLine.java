package KI304.Kozak.Lab2;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Class PhoneLine for Phone
 * <p></p>
 * <pre><b>Parameters:</b></pre>
 * <li><b>phones</b> - all phone numbers and their connection state</li>
 * <li><b>fout</b> - file printer</li>
 */
public class PhoneLine {
    private final Map<String, Boolean> phones;
    private final PrintWriter fout;

    /**
     * PhoneLine constructor
     * @param fOut file printer
     */
    PhoneLine(PrintWriter fOut) {
        phones = new HashMap<String, Boolean>();
        fout = fOut;
    }

    /**
     * Add phone number to network
     * @param phone phone number
     * @return <b>true</b> if number was added successfully,
     * <p></p>
     * <b>false</b> if number has a char; has more or less symbols than 10; it's already added
     */
    public boolean addPhone(String phone) {
        try {
            Integer.valueOf(phone);
        } catch (NumberFormatException e) {
            fout.println("\tNumber " + phone + " has char, phone isn't connected");
            System.out.println("\tNumber has char, phone isn't connected");
            return false;
        }
        if(phone.length() != 10) {
            System.out.println("\tNumber length isn't 10, phone isn't connected");
            fout.println("\tNumber " + phone + " length isn't 10, phone isn't connected");
            return false;
        }
        if(!phones.isEmpty()){
            for(Map.Entry<String, Boolean> number : phones.entrySet()) {
                if(number.getKey().equals(phone)) {
                    System.out.println("\tNumber is already taken, phone isn't connected");
                    fout.println("\tNumber " + phone + " is already taken, phone isn't connected");
                    return false;
                }
            }
        }
        phones.put(phone, true);
        fout.println("\tNew number " + phone + " is added successfully");
        return true;
    }

    /**
     * Remove number from network
     * @param phone phone number
     * @return <b>true</b> if number was removed successfully,
     * <p></p>
     * <b>false</b> if number wasn't removed
     */
    public boolean removePhone(String phone) {
        return phones.remove(phone);
    }

    /**
     * Search number in network
     * @param phone phone number
     * @return <b>true</b> if number was found successfully,
     * <p></p>
     * <b>false</b> if number wasn't found
     */
    public boolean searchNumber(String phone) {
        for(Map.Entry<String, Boolean> number : phones.entrySet()) {
            if(number.getKey().equals(phone)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Disconnect phone from network
     * @param phone phone number
     * @return <b>true</b> if number was disconnected successfully,
     * <p></p>
     * <b>false</b> if number wasn't disconnected
     */
    public boolean disconnectPhone(String phone) {
        for(Map.Entry<String, Boolean> number : phones.entrySet()) {
            if(number.getKey().equals(phone)) {
                number.setValue(false);
                return true;
            }
        }
        return false;
    }

    /**
     * Connect phone from network
     * @param phone phone number
     * @return <b>true</b> if number was connected successfully,
     * <p></p>
     * <b>false</b> if number wasn't connected
     */
    public boolean connectPhone(String phone) {
        for(Map.Entry<String, Boolean> number : phones.entrySet()) {
            if(number.getKey().equals(phone)) {
                number.setValue(true);
                return true;
            }
        }
        return false;
    }
}
