package KI304.Kozak.Lab3;

import java.io.PrintWriter;

/**
 * Class Handset for Phone
 * <p></p>
 * <pre><b>Parameters:</b></pre>
 * <li><b>volume</b> - volume of handset</li>
 * <li><b>isMuted</b> - state of microphone</li>
 */
public class Handset {
    private int volume;
    private boolean isMuted;

    /**
     * Handset constructor
     * @param volume volume of handset
     * @param isMuted state of microphone
     */
    Handset(int volume, boolean isMuted) {
        this.isMuted = isMuted;
        if(volume < 0 || volume > 10) {
            System.err.println("\tVolume can't be less then 0 or higher then 10. Program terminated");
            System.exit(-2);
        }
        this.volume = volume;
    }

    /**
     * Get current volume
     * @param fout file printer
     * @return current volume of handset
     */
    public int currentVolume(PrintWriter fout) {
        fout.println("\tCurrent volume is: " + volume);
        return volume;
    }

    /**
     * Get current microphone state
     * <p></p>
     * <li><b>true</b> - microphone is muted</li>
     * <li><b>false</b> - microphone is unmuted</li>
     * @param fout file printer
     * @return current state of microphone
     */
    public boolean microphoneState(PrintWriter fout) {
        fout.println(isMuted ? "\tMicrophone is muted" : "\tMicrophone is unmuted");
        return isMuted;
    }

    /**
     * Increase volume of handset by 1
     * @param fout file printer
     */
    public void increaseVolume(PrintWriter fout) {
        if((volume + 1) > 10) {
            System.out.println("\tCan't increase volume. Max volume reached");
            fout.println("\tCan't increase volume. Max volume reached");
        }
        else {
            volume++;
            System.out.println("\tVolume was increased");
            fout.println("\tVolume was increased");
        }
    }

    /**
     * Decrease volume of handset by 1
     * @param fout file printer
     */
    public void decreaseVolume(PrintWriter fout) {
        if((volume - 1) < 0) {
            System.out.println("\tCan't decrease volume. Min volume reached");
        }
        else {
            volume--;
            System.out.println("\tVolume was decreased");
            fout.println("\tVolume was decreased");
        }
    }

    /**
     * Set <b>isMuted</b> to true; mute microphone
     * @param fout file printer
     */
    public void muteMicrophone(PrintWriter fout) {
        if(isMuted) {
            System.out.println("\tMicrophone is already muted");
            fout.println("\tMicrophone is already muted");
        } else {
            isMuted = true;
            System.out.println("\tMicrophone was muted");
            fout.println("\tMicrophone was muted");
        }
    }

    /**
     * Set <b>isMuted</b> to false; unmute microphone
     * @param fout file printer
     */
    public void unmuteMicrophone(PrintWriter fout) {
        if(!isMuted) {
            System.out.println("\tMicrophone is already unmuted");
            fout.println("\tMicrophone is already unmuted");
        } else {
            isMuted = false;
            System.out.println("\tMicrophone was unmuted");
            fout.println("\tMicrophone was unmuted");
        }
    }
}
