package leetcode400;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/**
 * 就是这样做!!!非常快
 */
public class l433 {

    HashSet<String> hasvisit;
    public int minMutation(String startGene, String endGene, String[] bank) {
        hasvisit= new HashSet<>();
        hasvisit.add(startGene);
        int res = get(startGene, endGene, bank, 0);
        return res==Integer.MAX_VALUE?-1:res;

    }
    public int get(String startGene, String endGene,String[] bank,int step){
        if(startGene.equals(endGene)){
            return step;
        }

        List<String> next = findNext(startGene, bank);
        System.out.println(startGene);
        System.out.println("next"+next);
        System.out.println(hasvisit);
        int minstep = Integer.MAX_VALUE;
        for (String s : next) {

            if(!hasvisit.contains(s)){
                hasvisit.add(s);
                int steps = get(s, endGene, bank, step + 1);
                minstep =Math.min(steps,minstep);
                hasvisit.remove(s);
            }
        }
        return minstep;
    }
    public List<String> findNext(String startGene,String[] bank){
        List<String> res = new ArrayList<>();
        for (String s : bank) {
            if(isnext(startGene,s)){
                res.add(s);
            }

        }
        return res;
    }

    private boolean isnext(String startGene, String s) {
        int num = 0;
        if(startGene.length()!=s.length())return false;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!=startGene.charAt(i)){
                num++;
                if(num>1)return false;
            }
        }
        return num == 1;
    }
}
