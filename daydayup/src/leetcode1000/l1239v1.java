package leetcode1000;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class l1239v1 {
    public static void main(String[] args) {
        l1239v1 s = new l1239v1();
        System.out.println(s.get(10));
    }
    int res=0;
    int len;
    int[] map;
    HashMap<Integer,Integer> hashMap = new HashMap<>();
    public int maxLength(List<String> arr) {
        Set<Integer> set = new HashSet<>();

        for (String s : arr) {
            char[] chars = s.toCharArray();
            int yanma=0;
            for (char c : chars) {
                int cnum = c - 'a';
                //if ((yanma & cnum) != 0) {
                /*[易错]这里首先不能这样,cnum是字母序号,不是位掩码,c是3,d是4,不是100,1000*/
                //if((yanma>>cnum)!=0){
                /*[易错]其次这里还需要和&1与&一下,因为右移cnum位后(后面的去掉了),应该和1与&才能把前面的去掉*/
                if(((yanma>>cnum)&1)!=0){

                    yanma = -1;
                    break;
                } else {
                    //yanma |= cnum;
                    yanma|=(1<<cnum);
                }
//                if (yanma != -1) {  set.add(yanma);  }
            }
            if (yanma != -1) {
                set.add(yanma);
            }
        }

        System.out.println(set);
        len = set.size();
        map = new int[len];
        int i = 0;
        int total = 0;
        for (Integer cint : set) {
            map[i] = cint;
            i++;
            total |=cint;
        }

        dfs(0,0,total);
        return res;
    }

    private void dfs(int item, int cur, int remain) {
        if(get(cur|remain)<=res)return;
        if(item==len){
            int curres = get(cur);
            res = Math.max(res,curres);
            return;
        }
        if((map[item]&cur)==0){
            dfs(item+1,cur|map[item],remain-(remain&map[item]));
        }
        dfs(item+1,cur,remain);
    }

    //cur里有多少个1?
    private int get(int cur) {
        if(hashMap.containsKey(cur)){
            return hashMap.get(cur);
        }
        int count = 0;
        int curtmp = cur;
        while (curtmp>0){
            curtmp-=(curtmp&(-curtmp));
            count++;
        }
        /*[易错]这里要弄个curtmp,因为cur还要放进map里*/
        hashMap.put(cur,count);
        return count;
    }

}
