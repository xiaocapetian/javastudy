package kama;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//居然连scanner都没有!
public class k16v1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while((str = reader.readLine())!= null){
            StringTokenizer tokenizer = new StringTokenizer(str);
            int n = Integer.parseInt(tokenizer.nextToken());
            for(int i = 0; i < n; i++){
                String s = reader.readLine();
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < s.length(); j+= 2){
                    sb.append(s.charAt(j +1)).append(s.charAt(j));
                }
                System.out.println(sb.toString());
            }
        }
    }
}
