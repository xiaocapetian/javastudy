package chongle.XiaoHongShu;

import java.util.*;

public class tt3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            int n = Integer.parseInt(sc.nextLine());//笔记数量

            String s2 = sc.nextLine();
            int[] arr = new int[n];
            int max = 0;
            int min = Integer.MAX_VALUE;
            int sum = 0;
            for(int i = 0;i<n;i++){
                 arr[i]=Integer.parseInt(s2.split(" ")[i]);
                 if(min>arr[i]){min = arr[i];}
                 if(max<arr[i]){max = arr[i];}
                 sum+= arr[i];
            }
            int[] res = new int[n];
            for(int i =0;i<n;i++){
                if(arr[i]==max){res[i]=sum;}
                else if(arr[i]!=min){res[i] = sum+2*(max-arr[i])-1;}
                else {
                    int get = getnum(arr,max);
                }
            }
            //System.out.println("sum"+sum);
            //System.out.println(Arrays.toString(arr));
            System.out.println(Arrays.toString(res));

        }
    }
    public static int getnum(int[] arr,int max){
        //int[] arrfu =new int[arr.length];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            //arrfu[i] = arr[i];
            list.add(arr[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        if(list.get(0)==list.get(1)){return 2*(max-list.get(0))-1;}
        else {
            int[] count = new int[arr.length];
            for (int i = 0; i < count.length; i++) {
                count[i] = max-list.get(i);
            }
            int sum = 0;
            for (int i = 1; i < count.length; i++) {
                sum= sum+count[i];
            }
            if(count[0]<sum){
                return 2*(max-list.get(0))-1;
            }
            else {
                int cha = count[0]-sum;
                int shang = cha/(count.length-1);
                int yu =  cha%(count.length-1);
                return 2*(max-list.get(0))+shang*count.length+yu;//.......
            }
        }

    }
    //public static int[] tomax(int[] arr){

    //}
}
