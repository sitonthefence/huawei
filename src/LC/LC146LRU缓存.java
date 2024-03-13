package LC;

import java.util.LinkedHashMap;
import java.util.Map;

public class LC146LRU缓存 extends LinkedHashMap<Integer,Integer> {
    int capacity;
    public LC146LRU缓存(int capacity) {
       super(capacity,0.75F,true);
       this.capacity=capacity;
    }

    public int get(int key) {
        return getOrDefault(key,-1);
    }


    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size()>capacity;
    }



}
