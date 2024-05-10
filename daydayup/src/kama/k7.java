package kama;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class k7 {
    public static void main (String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("A",4);
        map.put("B",3);
        map.put("C",2);
        map.put("D",1);
        map.put("F",0);

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            String[] ss = s.split(" ");
            int sum = 0;boolean flag = true;
            for(int i = 0;i<ss.length;i++){

                if(!map.containsKey(ss[i])){
                    //System.out.println("Unknown");
                    flag = false;
                    //break;
                }else{
                    sum += map.get(ss[i]);
                }
            }
            if(flag){
                double res = (double)sum/ss.length;
                System.out.printf("%.2f\n",res);
            }else{
                System.out.println("Unknown");
            }

        }
    }
}
