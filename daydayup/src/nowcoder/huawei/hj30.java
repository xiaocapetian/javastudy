package nowcoder.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class hj30 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.nextLine();
            String s = str.split(" ")[0]+str.split(" ")[1];
            
            List<Character> list1 = new ArrayList<>();
            List<Character> list2 = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                if(i%2==0){
                    list1.add(s.charAt(i));
                }else {
                    list2.add(s.charAt(i));
                }
            }
            Collections.sort(list1);
            Collections.sort(list2);
            //<Character> list = new ArrayList<>();

            StringBuilder sb =new StringBuilder();
            for (int i = 0; i < list1.size(); i++) {
                //list.add(list1.get(i));
                sb.append(transfer(list1.get(i)));
                if(i < list2.size()){
                    //list.add(list2.get(i));
                    sb.append(transfer(list2.get(i)));
                }
            }


//            for (int i = 0; i < list.size(); i++) {
//                sb.append(transfer(list.get(i)));
//            }
            System.out.println(sb);

        }

    }

    private static Character transfer(Character character) {
        if(character=='0')return '0';
        if(character=='1')return '8';
        if(character=='2')return '4';
        if(character=='3')return 'C';
        if(character=='4')return '2';
        if(character=='5')return 'A';
        if(character=='6')return '6';
        if(character=='7')return 'E';
        if(character=='8')return '1';
        if(character=='9')return '9';
        if(character=='A'||character=='a')return '5';
        if(character=='B'||character=='b')return 'D';
        if(character=='C'||character=='c')return '3';
        if(character=='D'||character=='d')return 'B';
        if(character=='E'||character=='e')return '7';
        if(character=='F'||character=='f')return 'F';
        return character;//题目说:第三步：对排序后的字符串中的'0'~'9'、'A'~'F'和'a'~'f'字符，需要进行转换操作。
        //意思就是不在这里面的不用动的意思,直接返回不变的
    }


}
