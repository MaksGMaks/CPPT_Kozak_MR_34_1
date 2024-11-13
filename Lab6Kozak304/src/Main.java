import KI304.Kozak.Lab6.Dictionary;

public class Main {

    /**
     * The main method serves as the entry point for the program.
     * It demonstrates the usage of the Dictionary class with different key-value pairs.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Create a dictionary where keys are Characters and values are Strings
        Dictionary<Character, String> englishDictionary = new Dictionary<Character, String>();

        // Create a dictionary where keys are Strings and values are Integers
        Dictionary<String, Integer> numberClass = new Dictionary<String, Integer>();

        // Add values to the englishDictionary
        englishDictionary.putValueToKey('C', "Cinema");
        englishDictionary.putValueToKey('C', "Cut");
        englishDictionary.putValueToKey('E', "Eat");
        englishDictionary.putValueToKey('D', "Dog");

        // Add values to the numberClass
        numberClass.putValueToKey("Ones", 1);
        numberClass.putValueToKey("Ones", 2);
        numberClass.putValueToKey("Ones", 5);
        numberClass.putValueToKey("Ones", 7);
        numberClass.putValueToKey("Ones", 3);

        // Retrieve and print the values associated with key 'C' in englishDictionary
        System.out.println("Values for key 'C': " + englishDictionary.getValuesByKey('C'));

        // Find and print the maximum value in englishDictionary
        System.out.println("Max value in englishDictionary: " + englishDictionary.findMax());

        // Find and print the maximum value in numberClass
        System.out.println("Max value in numberClass: " + numberClass.findMax());
    }
}
