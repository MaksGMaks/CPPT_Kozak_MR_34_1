import KI304.Kozak.Lab6.Dictionary;

public class Main {
    private static Dictionary<Character, String> englishDictionary = null;
    private static Dictionary<String, String> roomDictionary = null;
    public static void main(String[] args) {
        englishDictionary = new Dictionary<Character, String>();
        roomDictionary = new Dictionary<String, String>();



        englishDictionary.putValueToKey('C', "Cut");
        englishDictionary.putValueToKey('C', "Cinema");
        System.out.println("Value C: " + englishDictionary.getValuesByKey('C'));
        System.out.println("Max value " + englishDictionary.findMax());
    }
}