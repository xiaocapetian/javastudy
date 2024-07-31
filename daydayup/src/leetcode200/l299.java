package leetcode200;

import java.util.HashMap;

/**
 * 虽然不快吧,但我nb的一遍过了
 * 思路正确,为什么第一遍不快啊?直接用int[]啊 要什么hashmap
 */
public class l299 {
    /**
     * 猜数字游戏
     * @param secret 你一个秘密数字 secret
     * @param guess 和朋友猜测的数字 guess ，请你返回对朋友这次猜测的提示。
     * @return 猜测数字中有多少位属于数字和确切位置都猜对了   有多少位属于数字猜对了但是位置不对
     */
    public String getHint(String secret, String guess) {
        int numA=0;
        int numB=0;
        int[] map1 = new int[10];
        int[] map2 = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)){
                numA++;
            }else {
                map1[secret.charAt(i)-'0']++;
                map2[guess.charAt(i)-'0']++;
            }
        }
        for(int i = 0; i < map1.length; i++) {
            numB+=Math.min(map1[i],map2[i]);
        }
        return numA+"A"+numB+"B";
    }


    public String getHintV1(String secret, String guess) {

        int numA=0;
        int numB=0;
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)){
                numA++;
            }else {
                map1.put(secret.charAt(i),map1.getOrDefault(secret.charAt(i),0)+1);
                map2.put(guess.charAt(i),map2.getOrDefault(guess.charAt(i),0)+1);
            }
        }
        for (Character c : map1.keySet()) {
            if(map2.containsKey(c)){
                numB+=Math.min(map1.get(c),map2.get(c));
            }
        }
        return numA+"A"+numB+"B";
    }

}
