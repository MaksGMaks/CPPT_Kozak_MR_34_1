package KI304.Kozak.Lab3;

import KI304.Kozak.Lab3.Handset;
import KI304.Kozak.Lab3.PhoneLine;
import KI304.Kozak.Lab3.PowerSupply;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;


/**
 * Class Phone
 * <p></p>
 * <pre><b>Parameters:</b></pre>
 * <li><b>handset</b> - store volume and microphone settings and provide actions with them</li>
 * <li><b>powerSupply</b> - provide energy for actions</li>
 * <li><b>phoneLine</b> - provide connection between phones to make them able to call to each other</li>
 */
public abstract class Phone {

    protected final Handset handset;
    protected final PowerSupply powerSupply;
    protected final PhoneLine phoneLine;
    
    PrintWriter fout;

    protected Vector<String> callHistory;
    protected String number;
    protected boolean isConnected;

    /**
     * Phone constructor (all parameters input manually)
     * @param fileOut file printer
     * @param currentVolume current volume of phone
     * @param isMutedState state of phones microphone
     * @param line network line; connect all phones
     * @param hasBattery indicates if phone has battery
     * @param isPlugged indicates if phone is plugged
     * @param maxCapacity max battery capacity
     * @param currentCapacity current battery capacity
     * @param number phone number
     * @throws IOException to provide file write
     */
    Phone(PrintWriter fileOut, int currentVolume, boolean isMutedState, PhoneLine line, boolean hasBattery, boolean isPlugged, int maxCapacity, int currentCapacity, String number) throws IOException {
        handset = new Handset(currentVolume, isMutedState);
        phoneLine = line;
        powerSupply = new PowerSupply(hasBattery, isPlugged, maxCapacity, currentCapacity);
        this.number = number;
        isConnected = phoneLine.addPhone(this.number);

        fout = fileOut;
        callHistory = new Vector<String>();
    }

    /**
     * Phone constructor (from ready Headset; rest parameters input manually)
     * @param fileOut file printer
     * @param handset handset; store volume and microphone settings and provide actions with them
     * @param line network line; connect all phones
     * @param hasBattery indicates if phone has battery
     * @param isPlugged indicates if phone is plugged
     * @param maxCapacity max battery capacity
     * @param currentCapacity current battery capacity
     * @param number phone number
     * @throws IOException to provide file write
     */
    Phone(PrintWriter fileOut, Handset handset, PhoneLine line, boolean hasBattery, boolean isPlugged, int maxCapacity, int currentCapacity, String number) throws IOException {
        this.handset = handset;
        phoneLine = line;
        powerSupply = new PowerSupply(hasBattery, isPlugged, maxCapacity, currentCapacity);
        this.number = number;
        isConnected = phoneLine.addPhone(this.number);

        fout = fileOut;
        callHistory = new Vector<String>();
    }

    /**
     * Phone constructor (all parameters are ready)
     * @param fileOut file printer
     * @param handset handset; store volume and microphone settings and provide actions with them
     * @param line network line; connect all phones
     * @param powerSupply powersupply; control energy consumption and recharging
     * @param number phone number
     * @throws IOException to provide file write
     */
    Phone(PrintWriter fileOut, Handset handset, PhoneLine line, PowerSupply powerSupply, String number) throws IOException {
        this.handset = handset;
        phoneLine = line;
        this.powerSupply = powerSupply;
        this.number = number;
        isConnected = phoneLine.addPhone(this.number);

        fout = fileOut;
        callHistory = new Vector<String>();
    }

    /**
     * Change current phone number
     * @param newNumber new phone number
     * @return <b>true</b> if number changed successfully
     * <p></p>
     * <b>false</b> if number wasn't change due to errors in it
     * @throws FileNotFoundException to provide file write
     */
    public boolean changeNumber(String newNumber) throws FileNotFoundException {
        if(!phoneLine.addPhone(newNumber)) {
            System.out.println("\tNew number is incorrect. Operation failed");
            fout.println("\tNew number is incorrect. Operation failed");
            return false;
        }
        if(!phoneLine.removePhone(number)) {
            System.out.println("\tSeems like your number isn't in base. Skip step");
            fout.println("\tSeems like your number isn't in base. Skip step");
        }
        number = newNumber;
        System.out.println("\tNew number is added successfully. New number: " + number);
        fout.println("\tNew number is added successfully. New number: " + number);
        return true;
    }

    /**
     * Receive call from another phone
     * @param number phone number
     * @return <b>true</b> if call was made
     * <p></p>
     * <b>false</b> if error occurs when try to call (not enough energy, number doesn't exist)
     * @throws FileNotFoundException to provide file write
     */
    private boolean getCall(String number) throws FileNotFoundException {
        if(powerSupply.useEnergy(10, fout)) {
            if (!isConnected) {
                return false;
            }
            if (!phoneLine.searchNumber(number)) {
                return false;
            }
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd_HH:mm:ss").format(Calendar.getInstance().getTime());
            callHistory.add("\tNumber " + number + " call to you at " + timeStamp);
            return true;
        }
        return false;
    }

    /**
     * Make call to another phone
     * @param receiver Phone which receive message about call from another phone
     * @throws FileNotFoundException to provide file write
     */
    public void makeCall(Phone receiver) throws FileNotFoundException {
        if(powerSupply.useEnergy(10, fout)) {
            if (!isConnected) {
                System.out.println("\tYou phone isn't connected");
                return;
            }
            if (!phoneLine.searchNumber(receiver.number)) {
                System.out.println("\tNumber which you call doesn't exist");
                fout.println("\tNumber which you call doesn't exist");
                return;
            }
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd_HH:mm:ss").format(Calendar.getInstance().getTime());
            if (receiver.getCall(number)) {
                callHistory.add("\tYou called to number " + receiver.number + " at " + timeStamp);
            } else {
                callHistory.add("\tYou tried to call to number " + receiver.number + " at " + timeStamp + " but he is unreachable");
            }
            System.out.println("\tYou history was updated");
            fout.println("\tYou history was updated");
        }
    }

    /**
     * Clear call history for this call
     * @throws FileNotFoundException to provide file write
     */
    public void clearHistory() throws FileNotFoundException {
        if(powerSupply.useEnergy(2, fout)) {
            callHistory.clear();
            System.out.println("\tYou history was updated");
            fout.println("\tYou history was updated");
        }
    }

    /**
     * Print call history for this phone
     * @throws FileNotFoundException to provide file write
     */
    public void getHistory() throws FileNotFoundException {
        if(powerSupply.useEnergy(2, fout)) {
            if (callHistory.isEmpty()) {
                System.out.println("\tCall history is empty");
                fout.println("\tCall history is empty");
            } else {
                System.out.println("\tCall history:");
                fout.println("\t\tCall history:");
                for (String call : callHistory) {
                    System.out.println(call);
                    fout.println(call);
                }
            }
        }
    }

    /**
     * Increase volume of phone
     * @throws FileNotFoundException to provide file write
     */
    public void increaseVolume() throws FileNotFoundException {
        if(powerSupply.useEnergy(1, fout)) {
            handset.increaseVolume(fout);
        }
    }

    /**
     * Decrease volume of phone
     * @throws FileNotFoundException to provide file write
     */
    public void decreaseVolume() throws FileNotFoundException {
        if(powerSupply.useEnergy(1, fout)) {
            handset.decreaseVolume(fout);
        }
    }

    /**
     * Mute microphone of phone
     * @throws FileNotFoundException to provide file write
     */
    public void mute() throws FileNotFoundException {
        if(powerSupply.useEnergy(1, fout)) {
            handset.muteMicrophone(fout);
        }
    }

    /**
     * Unmute microphone of phone
     * @throws FileNotFoundException to provide file write
     */
    public void unmute() throws FileNotFoundException {
        if(powerSupply.useEnergy(1, fout)) {
            handset.unmuteMicrophone(fout);
        }
    }

    /**
     * Connect phone to phone line
     * @throws FileNotFoundException to provide file write
     */
    public void setConnected() throws FileNotFoundException {
        if(!phoneLine.connectPhone(number)) {
            System.out.println("\tCan't connect this phone. Number doesn't exist in base. Maybe you input wrong number");
            fout.println("\tCan't connect this phone. Number doesn't exist in base. Maybe you input wrong number");
            return;
        }
        isConnected = true;
        System.out.println("\tPhone was connected successfully");
        fout.println("\tPhone was connected successfully");
    }

    /**
     * Disconnect phone from phone line
     * @throws FileNotFoundException to provide file write
     */
    public void setDisconnected() throws FileNotFoundException {
        if(!phoneLine.disconnectPhone(number)) {
            System.out.println("\tCan't disconnect this phone. Number doesn't exist in base. Maybe you input wrong number");
            fout.println("\tCan't disconnect this phone. Number doesn't exist in base. Maybe you input wrong number");
            return;
        }
        isConnected = false;
        System.out.println("\tPhone was disconnected successfully");
        fout.println("\tPhone was disconnected successfully");
    }

    /**
     * Get status of phone and print it
     * @throws FileNotFoundException to provide file write
     */
    public abstract void getStatus() throws FileNotFoundException;

    /**
     * Get phone number
     * @return number of phone
     */
    public String getNumber() {
        return number;
    }

    /**
     * Plug phone in
     */
    public void setPlugged() {
        powerSupply.plugIn(fout);
    }

    /**
     * Unplug phone
     */
    public void setUnplugged() {
        powerSupply.unPlug(fout);
    }
}
