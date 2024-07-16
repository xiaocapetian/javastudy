package leetcode2000;

import java.util.*;

public class l2182 {
    public String repeatLimitedString(String s, int repeatLimit) {


        //int[] map = new int[26];

        StringBuilder sb = new StringBuilder();
        TreeMap<Character,Integer> treeMap = new TreeMap<>((o1, o2) -> {
            return o2-o1;
        });
        for (int i = 0; i < s.length(); i++) {
            treeMap.put(s.charAt(i),treeMap.getOrDefault(s.charAt(i),0)+1);
        }
        System.out.println(treeMap);
        Set<Character> treekeyset = treeMap.keySet();
        List<Character> treekeyList=new ArrayList<>(treekeyset);

        for(int i = 1;i<treekeyList.size();i++){
            int repeatcount = 0;
            Map.Entry<Character, Integer> e1 = treeMap.pollFirstEntry();
            Integer e1Value = e1.getValue();
            Character e1key = e1.getKey();
            while (e1Value>0){
                if(repeatcount<repeatLimit){
                    e1Value--;
                    repeatcount++;
                    sb.append(e1key);
                }else {

                    treeMap.put(treekeyList.get(i),treeMap.get(treekeyList.get(i))-1);
                    if(treeMap.get(treekeyList.get(i))==0){
                        treeMap.pollFirstEntry();
                    }
                    repeatcount = 0;
                    sb.append(treekeyList.get(i));
                }
            }

        }
        if(!treeMap.isEmpty()){
            Map.Entry<Character, Integer> e1 = treeMap.pollFirstEntry();
            Integer e1Value = e1.getValue();
            Character e1key = e1.getKey();
            int min = Math.min(e1Value,repeatLimit);
            sb.append(String.valueOf(e1key).repeat(Math.max(0, min)));

        }

        System.out.println(treeMap);


        return sb.toString();
    }
}
