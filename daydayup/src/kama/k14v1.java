package kama;

import java.util.Scanner;

public class k14v1 {
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
        char[] arr = ss.toCharArray();
        StringBuilder sb = new StringBuilder();
        int j = 0;
        while (j < arr.length) {
            if (arr[j] <= 'z' && arr[j] >= 'a') {
                //arr[j] = Character.toUpperCase(arr[j]);
                arr[j] = (char)(arr[j]-'a'+'A');
            }
            sb.append(arr[j]);
            while (j < arr.length && arr[j] != ' ') {
                j++;
            }
            while (j < arr.length && arr[j] == ' ') {
                j++;
            }
        }
        System.out.println(sb.toString());
    }
}
