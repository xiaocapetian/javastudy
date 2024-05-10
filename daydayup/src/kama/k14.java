package kama;

import java.util.Scanner;

public class k14 {

    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = Integer.parseInt(sc.nextLine());
            for (int i = 0;i<n;i++){
                String ss = sc.nextLine();
                shouzimu(ss);
                System.out.println();
            }
        }
    }
    public static void shouzimu(String ss){
        int fast = 0;int slow = 0;
        for(;fast<ss.length();fast++){
            if(ss.charAt(fast)==' '){
                if(ss.charAt(slow)!=' '){
                    //String str = ss.subString(slow,fast);
                    char a = ss.charAt(slow)>='a'&&ss.charAt(slow)<='z'?(char)(ss.charAt(slow)-'a'+'A'):ss.charAt(slow);
                    System.out.print(a);
                }
                slow = fast;
            }
            if(ss.charAt(slow)==' '){slow++;}

        }
        char a = ss.charAt(slow)>='a'&&ss.charAt(slow)<='z'?(char)(ss.charAt(slow)-'a'+'A'):ss.charAt(slow);
        System.out.print(a);
    }
}
