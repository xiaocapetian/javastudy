package chongle.meituan;

import java.util.Scanner;

public class Mt2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (sc.hasNextInt()) { // 注意 while 处理多个 case
            int n = Integer.parseInt(sc.nextLine());
            int[] arr =new int[n];
            String in = sc.nextLine();
            int max = Integer.MIN_VALUE;
            for(int i = 0;i<n;i++){
                arr[i] = Integer.parseInt(in.split(" ")[i]);
                if(max<arr[i]){max=arr[i];}
            }

            int[] res =new int[n];
            for(int i = 0;i<n;i++){
                if(arr[i]*2>max){
                    res[i] = arr[i]*2;
                    //max = arr[i]*arr[i];
                }else {
                    res[i] = max;
                }


            }
            StringBuilder sb =new StringBuilder();
            for(int i = 0;i<n-1;i++){
                sb.append(res[i]).append(" ");
                //System.out.print(res[i]+" ");
            }
            //System.out.print(res[n-1]);
            sb.append(res[n-1]);
            System.out.println(sb);
        }

    }
}
