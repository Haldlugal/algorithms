import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;

public class PriorityQueue {
    private TreeMap<Integer, Integer> map;

    public PriorityQueue() {
        map = new TreeMap<Integer, Integer>();
    }

    public void insert(int i) {
        if (map.containsKey(i)) {
            map.put(i, map.get(i) + 1);
        } else {
            map.put(i, 1);
        }
    }

    public Integer remove() throws Exception {
        if (map.isEmpty()) {
            throw new Exception("No elements");
        }
        Integer tmp = map.firstKey();
        if (map.get(tmp) == 1) {
            map.remove(tmp);
        } else {
            map.put(tmp, map.get(tmp) - 1);
        }
        return tmp;
    }

    public Integer peek() throws Exception {
        if (map.isEmpty()) {
            throw new Exception("No elements");
        }

        return map.firstKey();
    }

    @Override
    public String toString() {
        return "PriorityQueue{" +
                "map=" + map +
                '}';
    }


//    public int remove() {
//
//
//        currentSize--;
//    }
}
