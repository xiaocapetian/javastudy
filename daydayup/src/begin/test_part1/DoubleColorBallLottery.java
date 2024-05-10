package begin.test_part1;

import java.util.Random;
import java.util.Scanner;

public class DoubleColorBallLottery {
    public static void main(String[] args) {
        int[] arr = createnumber();
        for (int i = 0; i < arr.length; i++) {
            //System.out.print(arr[i]+" ");
        }
        System.out.println("===========");
        int[] userinputarr = userinput();
        int redcount = 0,bluedcount = 0;
        for (int i = 0; i < userinputarr.length-1; i++) {
            int usernumber = userinputarr[i];
            for (int i1 = 0; i1 < arr.length-1; i1++) {
                if(usernumber==arr[i1]){redcount++;break;}
            }

        }
        if(userinputarr[userinputarr.length-1]==arr[arr.length-1]){bluedcount++;}
        //System.out.println(redcount);
        //System.out.println(bluedcount);
        //根据红色和蓝色的数据判断是否中奖

    }
    public static int[] userinput(){
        int arr[] = new int[7];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 6; ) {
            System.out.println("please input"+(i+1)+"red ball");
            int rednumber = sc.nextInt();
            if(rednumber>=1&&rednumber<=33){
                if(!contains(arr,rednumber)){
                    arr[i] = rednumber;
                    i++;
                }else{
                    System.out.println("repeat");
                }

            }else{
                System.out.println("Out of range, unreasonable");
            }
        }
        while (true) {
            System.out.println("input blue ball4");
            int bluenumber = sc.nextInt();
            if(bluenumber>=1&&bluenumber<=16){
                arr[arr.length - 1] = bluenumber;
                break;
            }else{
                System.out.println("Out of range, unreasonable");
            }
        }
        return arr;
    }
    public static int[] createnumber() {
        int arr[] = new int[7];
        Random r = new Random();
        for (int i = 0; i < 6; ) {
            int redNumber = r.nextInt(33)+1;
            boolean flag = contains(arr,redNumber);//注意这里不能写arr[]
            if(!flag){arr[i] = redNumber;
                i++;//只当成功添加完后，索引才添加，所以要把i++从循环出移动到下面来
            }
        }
        int blueNumber = r.nextInt(16)+1;
        arr[arr.length-1] = blueNumber;
        return arr;
    }
    public static boolean contains(int arr[],int redNumber){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==redNumber){
                return true;
            }
        }
        return false;
    }
}
