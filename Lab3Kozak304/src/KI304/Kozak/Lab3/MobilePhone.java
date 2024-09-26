package KI304.Kozak.Lab3;

import KI304.Kozak.Lab3.Phone;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

public class MobilePhone extends Phone implements IMobilePhone{
    private Vector<String> messageHistory;
    private Vector<String> unreceivedMessage;
    /**
     * Phone constructor (all parameters input manually)
     *
     * @param fileOut         file printer
     * @param currentVolume   current volume of phone
     * @param isMutedState    state of phones microphone
     * @param line            network line; connect all phones
     * @param hasBattery      indicates if phone has battery
     * @param isPlugged       indicates if phone is plugged
     * @param maxCapacity     max battery capacity
     * @param currentCapacity current battery capacity
     * @param number          phone number
     * @throws IOException to provide file write
     */
    MobilePhone(PrintWriter fileOut, int currentVolume, boolean isMutedState, PhoneLine line, boolean hasBattery, boolean isPlugged, int maxCapacity, int currentCapacity, String number) throws IOException {
        super(fileOut, currentVolume, isMutedState, line, hasBattery, isPlugged, maxCapacity, currentCapacity, number);
        messageHistory = new Vector<String>();
        unreceivedMessage = new Vector<String>();
    }

    /**
     * Phone constructor (from ready Headset; rest parameters input manually)
     *
     * @param fileOut         file printer
     * @param handset         handset; store volume and microphone settings and provide actions with them
     * @param line            network line; connect all phones
     * @param hasBattery      indicates if phone has battery
     * @param isPlugged       indicates if phone is plugged
     * @param maxCapacity     max battery capacity
     * @param currentCapacity current battery capacity
     * @param number          phone number
     * @throws IOException to provide file write
     */
    MobilePhone(PrintWriter fileOut, Handset handset, PhoneLine line, boolean hasBattery, boolean isPlugged, int maxCapacity, int currentCapacity, String number) throws IOException {
        super(fileOut, handset, line, hasBattery, isPlugged, maxCapacity, currentCapacity, number);
        messageHistory = new Vector<String>();
        unreceivedMessage = new Vector<String>();
    }

    /**
     * Phone constructor (all parameters are ready)
     *
     * @param fileOut     file printer
     * @param handset     handset; store volume and microphone settings and provide actions with them
     * @param line        network line; connect all phones
     * @param powerSupply powersupply; control energy consumption and recharging
     * @param number      phone number
     * @throws IOException to provide file write
     */
    MobilePhone(PrintWriter fileOut, Handset handset, PhoneLine line, PowerSupply powerSupply, String number) throws IOException {
        super(fileOut, handset, line, powerSupply, number);
        messageHistory = new Vector<String>();
        unreceivedMessage = new Vector<String>();
    }

    /**
     * Get the status of the mobile phone
     * @throws FileNotFoundException to provide file write
     */
    @Override
    public void getStatus() throws FileNotFoundException {
        System.out.println("\n\t\tStatus");
        fout.println("\n\t\tStatus");
        System.out.println("\tCurrent volume is: " + handset.currentVolume(fout));
        System.out.println(handset.microphoneState(fout) ? "\tMicrophone is muted" : "\tMicrophone is unmuted");
        System.out.println(powerSupply.getPluggedState(fout) ? "\tPhone is plugged" : "\tPhone is unplugged");
        System.out.println(powerSupply.getHasBattery(fout) ? "\tCapacity: " + powerSupply.getCurrentCapacity() + "/" + powerSupply.getMaxCapacity() : "\tPhone doesn't have a battery");
        System.out.println("\tNumber: " + number);
        fout.println("\tNumber: " + number);
        System.out.println(isConnected ? "\tPhone is connected" : "\tPhone is disconnected");
        fout.println(isConnected ? "\tPhone is connected" : "\tPhone is disconnected");
    }

    /**
     * Make a call to another phone
     * @param receiver Phone which receive message about call from another phone
     * @throws FileNotFoundException to provide file write
     */
    @Override
    public void makeCall(Phone receiver) throws FileNotFoundException {
        super.makeCall(receiver);
    }

    /**
     * Clear call history for this phone
     * @throws FileNotFoundException to provide file write
     */
    @Override
    public void clearHistory() throws FileNotFoundException {
        super.clearHistory();
    }

    /**
     * Print call history for this phone
     * @throws FileNotFoundException to provide file write
     */
    @Override
    public void getHistory() throws FileNotFoundException {
        super.getHistory();
    }

    /**
     * Increase the volume of the phone
     * @throws FileNotFoundException to provide file write
     */
    @Override
    public void increaseVolume() throws FileNotFoundException {
        super.increaseVolume();
    }

    /**
     * Decrease the volume of the phone
     * @throws FileNotFoundException to provide file write
     */
    @Override
    public void decreaseVolume() throws FileNotFoundException {
        super.decreaseVolume();
    }

    /**
     * Mute the microphone of the phone
     * @throws FileNotFoundException to provide file write
     */
    @Override
    public void mute() throws FileNotFoundException {
        super.mute();
    }

    /**
     * Unmute the microphone of the phone
     * @throws FileNotFoundException to provide file write
     */
    @Override
    public void unmute() throws FileNotFoundException {
        super.unmute();
    }

    /**
     * Connect the phone to the phone line
     * @throws FileNotFoundException to provide file write
     */
    @Override
    public void setConnected() throws FileNotFoundException {
        super.setConnected();
    }

    /**
     * Disconnect the phone from the phone line
     * @throws FileNotFoundException to provide file write
     */
    @Override
    public void setDisconnected() throws FileNotFoundException {
        super.setDisconnected();
    }

    /**
     * Get the phone number
     * @return number of phone
     */
    @Override
    public String getNumber() {
        return number;
    }

    /**
     * Plug the phone in
     */
    @Override
    public void setPlugged() {
        super.setPlugged();
    }

    /**
     * Unplug the phone
     */
    @Override
    public void setUnplugged() {
        super.setUnplugged();
    }


    /**
     * Send message to another phone
     * @param receiver receiver of message
     * @param message message from this phone
     * @throws FileNotFoundException to provide file write
     * @return true if message was sent successfully <p>
     *     false if error occurs
     * </p>
     */
    @Override
    public boolean sendMessage(MobilePhone receiver, String message) throws FileNotFoundException {
        if(powerSupply.useEnergy(10, fout)) {
            if (!isConnected) {
                System.out.println("\tYou phone isn't connected");
                return false;
            }
            if (!phoneLine.searchNumber(receiver.number)) {
                System.out.println("\tNumber which you message doesn't exist");
                fout.println("\tNumber which you message doesn't exist");
                return false;
            }
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd_HH:mm:ss").format(Calendar.getInstance().getTime());
            if (receiver.getMessage(number, message)) {
                callHistory.add("\tYou sent message to " + receiver.number + " at " + timeStamp + ". MESSAGE:\n" + message + "\nENEMESSAGE");
            } else {
                callHistory.add("\tYou tried to send message to number " + receiver.number + " at " + timeStamp + " but he is unreachable");
            }
            System.out.println("\tYou history was updated");
            fout.println("\tYou history was updated");
            return true;
        }
        return false;
    }

    /**
     * Get message history
     * @throws FileNotFoundException to provide file write
     */
    @Override
    public void getMessageHistory() throws FileNotFoundException {
        if(powerSupply.useEnergy(2, fout)) {
            if (messageHistory.isEmpty()) {
                System.out.println("\tMessage history is empty");
                fout.println("\tMessage history is empty");
            } else if(!unreceivedMessage.isEmpty()) {
                System.out.println("\tYou have unreceived messages. Update message history");
                fout.println("\tYou have unreceived messages. Update message history");
            } else {
                System.out.println("\tMessage history:");
                fout.println("\t\tMessage history:");
                for (String message : messageHistory) {
                    System.out.println(message);
                    fout.println(message);
                }
            }
        }
    }

    /**
     * Clear message history
     * @throws FileNotFoundException to provide file write
     */
    @Override
    public void clearMessageHistory() throws FileNotFoundException {
        if(powerSupply.useEnergy(2, fout)) {
            messageHistory.clear();
            unreceivedMessage.clear();
            System.out.println("\tYour message history was updated");
            fout.println("\tYour message history was updated");
        }
    }

    /**
     * Update message history
     * @throws FileNotFoundException to provide file write
     */
    @Override
    public void updateMessage() throws FileNotFoundException {
        if(isConnected) {
            if(!unreceivedMessage.isEmpty()) {
                messageHistory.addAll(unreceivedMessage);
                unreceivedMessage.clear();
                System.out.println("\tMessage history was updated");
                fout.println("\tMessage history was updated");
            } else {
                System.out.println("\tMessage history is already updated");
                fout.println("\tMessage history is already updated");
            }
        } else {
            System.out.println("\tCan't receive messages. Phone isn't connected");
            fout.println("\tCan't receive messages. Phone isn't connected");
        }
    }

    /**
     * Receive message from another phone
     * @param number number of receiver
     * @param message message to send
     * @return true if phone exists in phone line<p>
     *     false if doesn't
     * </p>
     * @throws FileNotFoundException to provide file write
     */
    private boolean getMessage(String number, String message) throws FileNotFoundException {
        if(powerSupply.useEnergy(10, fout)) {
            if (!phoneLine.searchNumber(number)) {
                return false;
            }
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd_HH:mm:ss").format(Calendar.getInstance().getTime());

            if (!isConnected) {
                unreceivedMessage.add("\tNumber " + number + " sent message to you at " + timeStamp + ". MESSAGE:\n" + message + "\nENDMESSAGE");
            } else {
                messageHistory.add("\tNumber " + number + " sent message to you at " + timeStamp + ". MESSAGE:\n" + message + "\nENDMESSAGE");
            }
            return true;
        }
        return false;
    }
}
