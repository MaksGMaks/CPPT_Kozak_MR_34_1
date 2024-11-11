package KI304.Kozak.Lab6;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Dictionary<Key, Value extends Comparable<? super Value>> {
    private Map<Key, Value> data = null;
    public Dictionary() {
        data = new HashMap<Key, Value>();
    }

    public Value getValuesByKey(Key key) {
        return data.get(key);
    }

    public void putValueToKey(Key key, Value value) {
        data.put(key, value);
    }

    public void removeKey(Key key) {
        if(data.containsKey(key))
            data.remove(key);
        else
            System.out.println("Key " + key + " doesn't exist in dictionary");
    }

    public Value findMax() {
        if(data.isEmpty()) {
            System.err.println("Dictionary");
            System.exit(-1);
        }

        return data.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                .orElseThrow(NoSuchElementException::new)
                .getValue();
    }
}
