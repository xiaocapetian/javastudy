package leetcode300;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 怎么没想到用dfs呢？
 */
public class l386 {

    List<Integer> res = new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {

        for(int i=1;i<10;i++){//难点注意这里是从1开始
            dfs(i,n);
        }
        return res;
    }
    private void dfs(int now,int n){
        if(now>n)return;
        res.add(now);
        for(int i=0;i<10;i++){
            dfs(now*10+i,n);
        }
    }

    /**
     * 速度太慢了
     */
    public List<Integer> lexicalOrder2(int n) {

        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < n+1; i++) {
            res.add(i);
        }
        Collections.sort(res,(o1, o2) -> {
            String s1 = Integer.toString(o1);
            String s2 = Integer.toString(o2);
            int index=0;
            while (index<s1.length()||index<s2.length()){
                int i1 = index<s1.length()?s1.charAt(index):0;
                int i2 = index<s2.length()?s2.charAt(index):0;
                if(i1!=i2){return i1-i2;}
                index++;
            }
            return 0;
        });
        return res;
    }
}
