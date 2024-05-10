package leetcode;

import java.util.*;
//无法解决有重复变量的
public class l30 {
    public List<Integer> findSubstring(String s, String[] words) {

        //HashSet<String> hash = new HashSet<>(Arrays.asList(words));
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i],i);
        }

        List<Integer> res =new ArrayList<>();
        int len = words[0].length();//y
        /*所以有len种划分方式*/
        int wide = words.length*len;
        //System.out.println("wide="+wide);
        for (int i = 0; i < len; i++) {
            int[] has = new int[words.length];
            int left = i;
            int right = i+len-1;
            //最后应该right=i+wide-1
            for(;right<i+wide;right+=len){
                String s2 = s.substring(right - len+1, right+1);
                if(map.containsKey(s2)){
                    has[map.get(s2)]++;
                }
                if(meiyou0(has)){
                    res.add(0);
                }
            }
            right-=len;
            //System.out.println("i+wide-1="+(i+wide-1));
            //System.out.println("left="+left);System.out.println("right="+right);
            //System.out.println(Arrays.toString(has));
//            for(;right<s.length();right+=len,left+=len){
//                if()
//            }
            while(right+len<s.length()){
                String qu = s.substring(left, left+len);
                if(map.containsKey(qu)){
                    has[map.get(qu)]--;
                }
                System.out.println("qu="+qu);
                String lai = s.substring(right+1, right+len+1);
                System.out.println("lai="+lai);
                if(map.containsKey(lai)){
                    has[map.get(lai)]++;
                }
                right+=len;
                left+=len;
                if(meiyou0(has)){
                    res.add(left);
                }
                System.out.println(Arrays.toString(has));
            }
        }

        return res;

    }

    private boolean meiyou0(int[] has) {
        for (int ha : has) {
            if(ha==0)return false;
        }
        return true;
    }
}
