package kama;

import java.util.Scanner;

public class k11 {
    /*千万别想着什么弄一个class, 用数组就可以映射了!*/
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt();
            int[] tree = new int[21];
            for(int i = 0;i<N;i++){
                int child = sc.nextInt();
                int father = sc.nextInt();
                tree[child]  = father ;
            }
            int ming = 1;
            int yu = 2;
            //System.out.println(find(tree,ming,yu));
            find(tree,ming,yu);
        }
    }
    public static void find(int[] tree,int ming, int yu  ){
        int mingnum = findfather(tree,ming);
        int yunum = findfather(tree,yu);
        if(mingnum>yunum){System.out.println("You are my elder");}
        else if(mingnum<yunum){System.out.println("You are my younger");}
        else{System.out.println("You are my brother");}

    }
    public static int findfather(int[] tree,int peo){
        int res = 0;

        while(tree[peo]!=0){
            peo = tree[peo];
            res++;
        }
        return res;
    }
}
