package KI304.Kozak.Lab2;

import java.io.PrintWriter;

/**
 * Class PpwerSupply for Phone
 * <p></p>
 * <pre><b>Parameters:</b></pre>
 * <li><b>hasBattery</b> - state if phone has a battery</li>
 * <li><b>isPlugged</b> - state if phone is plugged in</li>
 * <li><b>maxCapacity</b> - max capacity of battery</li>
 * <li><b>currentCapacity</b> - current capacity of battery</li>
 */
public class PowerSupply {
    private final boolean hasBattery;
    private boolean isPlugged;
    private final int maxCapacity;
    private int currentCapacity;

    /**
     * PowerSupply constructor
     * @param hasBattery state if phone has a battery
     * @param isPlugged state if phone is plugged in
     * @param maxCapacity max capacity of battery
     * @param currentCapacity current capacity of battery
     */
    PowerSupply(boolean hasBattery, boolean isPlugged, int maxCapacity, int currentCapacity) {
        if(hasBattery) {
            if(maxCapacity < currentCapacity) {
                System.err.println("\tCurrent capacity can't be greater than max capacity. Program terminated");
                System.exit(-3);
            }
        }
        this.currentCapacity = currentCapacity;
        this.maxCapacity = maxCapacity;
        this.isPlugged = isPlugged;
        this.hasBattery = hasBattery;
    }

    /**
     * Get current battery capacity
     * @return current battery capacity
     */
    public int getCurrentCapacity() {
        if(hasBattery) {
            return currentCapacity;
        } else {
            System.out.println("\tPhone doesn't have battery");
        }
        return 0;
    }

    /**
     * Get max battery capacity
     * @return max battery capacity
     */
    public int getMaxCapacity() {
        if(hasBattery) {
            return maxCapacity;
        } else {
            System.out.println("\tPhone doesn't have battery");
        }
        return 0;
    }

    /**
     * Get if PowerSupply has battery
     * @param fout file printer
     * @return <b>true</b> if it has a battery <p></p>
     * <b>false</b> if it doesn't have a battery
     */
    public boolean getHasBattery(PrintWriter fout) {
        fout.println(hasBattery ? "\tCapacity: " + getCurrentCapacity() + "/" + getMaxCapacity() : "Phone doesn't have a battery");
        return hasBattery;
    }

    /**
     * Get if PowerSupply is plugged in
     * @param fout file printer
     * @return <b>true</b> if it's plugged in <p></p>
     * <b>false</b> if it isn't plugged
     */
    public boolean getPluggedState(PrintWriter fout) {
        fout.println(isPlugged ? "\tPhone is plugged" : "Phone is unplugged");
        return isPlugged;
    }

    /**
     * Try to use energy for action
     * @return <b>true</b> if it can provide energy <p></p>
     * <b>false</b> if it can't provide energy
     */
    public boolean useEnergy(int amount, PrintWriter fout) {
        if(!hasBattery) {
            if(!isPlugged) {
                System.out.println("\tPhone is unplugged. Please plug it in");
                fout.println("\tPhone is unplugged. Please plug it in");
            }
            return isPlugged;
        }
        if(isPlugged) {
            currentCapacity += 5;
            return true;
        }
        if((currentCapacity - amount) < 0) {
            System.out.println("\tNot enough energy. Required: " + amount + ". Has: " + currentCapacity + "/" + maxCapacity);
            fout.println("\tNot enough energy. Required: " + amount + ". Has: " + currentCapacity + "/" + maxCapacity);
            return false;
        }
        currentCapacity -= amount;
        return true;
    }

    /**
     * Set PowerSupply plugged in
     * @param fout file printer
     */
    public void plugIn(PrintWriter fout) {
        if(isPlugged) {
            System.out.println("\tPhone is already plugged");
            fout.println("\tPhone is already plugged");
            return;
        }
        isPlugged = true;
        System.out.println("\tPhone was plugged successfully");
        fout.println("\tPhone was plugged successfully");
    }

    /**
     * Set PowerSupply unplugged
     * @param fout file printer
     */
    public void unPlug(PrintWriter fout) {
        if(!isPlugged) {
            System.out.println("\tPhone is already unplugged");
            fout.println("\tPhone is already unplugged");
            return;
        }
        isPlugged = false;
        System.out.println("\tPhone was unplugged successfully");
        fout.println("\tPhone was unplugged successfully");
    }
}
