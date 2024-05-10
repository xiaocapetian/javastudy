package kama;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class k17 {
    //学到了set.add(in[i]);  set用add,不用put!!
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = Integer.parseInt(sc.nextLine());
            if(n==0){break;}
            int[] in = new int[n];
            for(int i = 0;i<n;i++){
                in[i] = sc.nextInt();
            }
            sc.nextLine();
            if(discrimination(in)){System.out.println("Yes");}
            else{System.out.println("No");}
        }
    }
    public static boolean discrimination(int[] in){
        Set<Integer> set = new HashSet<>();
        set.add(in[0]);
        for(int i= 1;i<in.length;i++){
            int now = in[i];
            if(in[i-1]>in[i]){
                for(int j = in[i]+1;j<in[i-1];j++){
                    if(!set.contains(j)){
                        //System.out.println("noin[i]"+i);
                        return false;
                    }
                    //else{System.out.println("yesin[i]"+i);}
                }
            }
            set.add(in[i]);
        }
        return true;
    }
}
