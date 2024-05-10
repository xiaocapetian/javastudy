package nowcoder.huawei;

import java.util.Scanner;

public class hj4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
           String s = in.nextLine();
           int item = 0;
           while (item+7<s.length()){//[易错]:这里写item+8的话不对! 想象一下12345678,长度为8应该直接进去才对
               System.out.println(s.substring(item,item+8));
               item+=8;
           }
           if(s.length()%8!=0){
               int num = 8-s.length()%8;
               StringBuilder sb = new StringBuilder();
               sb.append(s.substring(item,s.length()));
               for (int i = 0; i < num; i++) {
                   sb.append("0");
               }
               System.out.println(sb.toString());
           }
        }
    }
    private void f2(){
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder();//牢记字符串缓冲区的建立语法
            sb.append(str);//字符串缓冲区的加入
            int size = str.length();
            int addZero = 8 - size%8;//addzero的可能值包括8
            while((addZero > 0)&&(addZero<8)){//注意边界调节，避免addzero=8
                sb.append("0");//使用‘’或“”都可
                addZero--;
            }
            String str1 = sb.toString();
            while(str1.length()>0){
                System.out.println(str1.substring(0,8));
                str1 = str1.substring(8);
            }

        }
    }
}
