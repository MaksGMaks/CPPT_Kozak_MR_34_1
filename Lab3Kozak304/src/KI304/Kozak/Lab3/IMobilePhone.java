package KI304.Kozak.Lab3;

import java.io.FileNotFoundException;
import java.sql.Struct;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public interface IMobilePhone {
    /**
     * Change current phone number
     * @param newNumber new phone number
     * @return <b>true</b> if number changed successfully
     * <p></p>
     * <b>false</b> if number wasn't change due to errors in it
     * @throws FileNotFoundException to provide file write
     */
    public boolean changeNumber(String newNumber) throws FileNotFoundException;

    /**
     * Make call to another phone
     * @param receiver Phone which receive message about call from another phone
     * @throws FileNotFoundException to provide file write
     */
    public void makeCall(Phone receiver) throws FileNotFoundException;

    /**
     * Clear call history for this call
     * @throws FileNotFoundException to provide file write
     */
    public void clearHistory() throws FileNotFoundException;

    /**
     * Print call history for this phone
     * @throws FileNotFoundException to provide file write
     */
    public void getHistory() throws FileNotFoundException;

    /**
     * Increase volume of phone
     * @throws FileNotFoundException to provide file write
     */
    public void increaseVolume() throws FileNotFoundException;

    /**
     * Decrease volume of phone
     * @throws FileNotFoundException to provide file write
     */
    public void decreaseVolume() throws FileNotFoundException;

    /**
     * Mute microphone of phone
     * @throws FileNotFoundException to provide file write
     */
    public void mute() throws FileNotFoundException;

    /**
     * Unmute microphone of phone
     * @throws FileNotFoundException to provide file write
     */
    public void unmute() throws FileNotFoundException;

    /**
     * Connect phone to phone line
     * @throws FileNotFoundException to provide file write
     */
    public void setConnected() throws FileNotFoundException;

    /**
     * Disconnect phone from phone line
     * @throws FileNotFoundException to provide file write
     */
    public void setDisconnected() throws FileNotFoundException;

    /**
     * Get status of phone and print it
     * @throws FileNotFoundException to provide file write
     */
    public abstract void getStatus() throws FileNotFoundException;

    /**
     * Get phone number
     * @return number of phone
     */
    public String getNumber();

    /**
     * Plug phone in
     */
    public void setPlugged();

    /**
     * Unplug phone
     */
    public void setUnplugged();

    /**
     * Send message to another phone
     *
     * @param receiver receiver of message
     * @param message message from this phone
     * @throws FileNotFoundException to provide file write
     * @return true if message was sent successfully <p>
     *     false if error occurs
     * </p>
     */
    public boolean sendMessage(MobilePhone receiver, String message) throws FileNotFoundException;

    /**
     * Get message history
     * @throws FileNotFoundException to provide file write
     */
    public void getMessageHistory() throws FileNotFoundException;

    /**
     * Clear message history
     * @throws FileNotFoundException to provide file write
     */
    public void clearMessageHistory() throws FileNotFoundException;

    /**
     * Update message history
     * @throws FileNotFoundException to provide file write
     */
    public void updateMessage() throws FileNotFoundException;
}
