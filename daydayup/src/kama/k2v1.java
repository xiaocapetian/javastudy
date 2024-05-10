package kama;

import java.util.Scanner;

public class k2v1 {

    public static void main(String[] args){
        Solution solution = new Solution();

        Scanner sc = new Scanner(System.in);
        sc.hasNext();sc.hasNextInt();sc.hasNextLine();
        while(sc.hasNextInt()){
            int numlen = sc.nextInt();

            for(int i = 0;i < numlen; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();

                int result = solution.sumInt(a, b);

                System.out.println(result);
            }
        }
    }

}

class Solution{
    public int sumInt(int a,int b){
        return a + b;
    }
}