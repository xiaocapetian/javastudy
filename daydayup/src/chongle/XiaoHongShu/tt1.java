package chongle.XiaoHongShu;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class tt1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            int n = Integer.parseInt(sc.nextLine());
            String[] str = new String[n];
            for(int i = 0;i<n;i++){
                str[i] = sc.nextLine();
            }
            Set<String> set = new HashSet<>();
            for (String s : str) {
                if(!set.contains(s)){
                    System.out.println(s);
                    set.add(s);
                }
            }
        }
    }
}
