package leetcode300;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class l380 {
}
//自己写的,慢的很
class RandomizedSet2 {

    HashSet<Integer> set;
    public RandomizedSet2() {
        set = new HashSet<>();
    }

    public boolean insert(int val) {
        if(set.contains(val))return false;
        set.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!set.contains(val))return false;
        set.remove(val);
        return true;
    }

    public int getRandom() {
        Random random = new Random();
        int suijishu = random.nextInt(set.size());
        //int[] arr = new int[set.size()];
        List<Integer> list = new ArrayList<>(set);
        return list.get(suijishu);

    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */