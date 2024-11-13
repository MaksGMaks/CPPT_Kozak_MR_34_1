package KI304.Kozak.Lab6;

import java.util.*;

/**
 * Dictionary that maps keys to lists of comparable values.
 *
 * @param <Key> The type of keys maintained by this dictionary
 * @param <Value> The type of values maintained by this dictionary, which must
 *        be comparable to each other
 */
public class Dictionary<Key, Value extends Comparable<? super Value>> {

    // Storage for the dictionary's data
    private Map<Key, ArrayList<Value>> data = null;

    /**
     * Constructs a new, empty Dictionary.
     */
    public Dictionary() {
        data = new HashMap<Key, ArrayList<Value>>();
    }

    /**
     * Retrieves the list of values associated with the specified key.
     *
     * @param key the key whose associated values are to be returned
     * @return a list of values associated with the specified key, or null if the
     *         key is not present in the dictionary
     */
    public List<Value> getValuesByKey(Key key) {
        return data.get(key);
    }

    /**
     * Associates the specified value with the specified key in this dictionary.
     * If the dictionary previously contained values for the key, the new value is
     * added to the list of existing values.
     *
     * @param key the key with which the specified value is to be associated
     * @param value the value to be associated with the specified key
     */
    public void putValueToKey(Key key, Value value) {
        ArrayList<Value> val = new ArrayList<Value>();
        if (!data.containsKey(key)) {
            val.add(value);
            data.put(key, val);
        } else {
            data.get(key).add(value);
        }
    }

    /**
     * Removes the mapping for a key from this dictionary if it is present.
     *
     * @param key the key whose mapping is to be removed from the dictionary
     */
    public void removeKey(Key key) {
        if (data.containsKey(key)) {
            data.remove(key);
        } else {
            System.out.println("Key " + key + " doesn't exist in dictionary");
        }
    }

    /**
     * Finds and returns the maximum value stored in the dictionary. If the
     * dictionary is empty, the method prints an warning message
     *
     * @return the maximum value stored in the dictionary
     */
    public Value findMax() {
        if (data.isEmpty()) {
            System.out.println("Dictionary is empty");
        }

        Value max = null;
        for (Key key : data.keySet()) {
            for (Value val : data.get(key)) {
                if (max == null || val.compareTo(max) > 0) {
                    max = val;
                }
            }
        }
        return max;
    }
}
