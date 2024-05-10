package leetcode300;

import java.util.HashMap;
import java.util.Random;

public class l380v1 {

}

/**
 * [难点]核心思想:数组和map,删除交换!
 * //键:val  值:数组的下标
 * //删的时候要把数组里的要删的位置改成数组现在的最后一位
 * [易错]map.put(arr[idx],loc);删数组要改最后一位在map里的值,这里put只可改,不可增!(防止删的就是最后一位)
 */
class RandomizedSet {

    HashMap<Integer,Integer> map;
    Random random = new Random();
    //键:val  值:数组的下标
    int idx=-1;//可使用的范围,初始的时候0是可使用的吗?不是啊,所以要初始化为-1
    int[] arr = new int[200010];
    public RandomizedSet() {
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if(map.containsKey(val))return false;
        idx++;//可使用+1
        map.put(val,idx);
        arr[idx] = val;
        return true;
    }

    public boolean remove(int val) {

        if(!map.containsKey(val))return false;
        //这里注意了.要删除交换
        //首先取出删除节点val的位置loc
        //int loc=map.get(val);
        //map删掉节点val
        int loc = map.remove(val);
        //数组中最后一位的值是arr[idx],现在把下标loc的改成arr[idx]
        arr[loc]=arr[idx];
        //map中这一位的下标要改成loc
        if(map.containsKey(arr[idx])){/*[易错]这里put的时候要注意,如果删的就是最后一位就不能put改了,
        换言之只有arr[idx]在map中存在,才可以改.put只可改,不可增*/
            map.put(arr[idx],loc);
        }
        idx--;
        return true;
    }

    public int getRandom() {

        int r = random.nextInt(idx+1);
        return arr[r];

    }
}


//作者：宫水三叶
//        链接：https://leetcode.cn/problems/insert-delete-getrandom-o1/solutions/1416888/by-ac_oier-tpex/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。