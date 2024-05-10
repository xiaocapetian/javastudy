package chongle.meituan;

import java.util.*;

public class Mt3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (sc.hasNextLine()) { // 注意 while 处理多个 case

            //
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            char[] arr1 = str1.toCharArray();
            char[] arr2 = str2.toCharArray();
            HashMap<Character,Integer> hash1 = new HashMap<>();
            for (char c : arr1) {
                hash1.put(c,hash1.getOrDefault(c,0)+1);
            }
            HashMap<Character,Integer> hash2 = new HashMap<>();
            for (char c : arr1) {
                hash2.put(c,hash2.getOrDefault(c,0)+1);
            }

            int countgai = 0;
            List<String> res=new ArrayList<>();
            for (int i =arr1.length-1;i>0;i--){
                if(arr1[i]==arr2[i]){
                    System.out.println("等");
                    continue;
                }
                else {
                    int deng1 = getdeng(arr1, i);
                    int deng2 = getdeng(arr2, i);
                    if(deng1<deng2){

                        res.add("1 "+i+" "+arr2[i]);
                        countgai++;
                        for (int j = 0;j<i;j++){
                            arr1[j] = arr2[i];
                        }
                    }
                    else {
                        res.add("2 "+i+" "+arr2[i]);
                        countgai++;
                        for (int j = 0;j<i;j++){
                            arr2[j] = arr1[i];
                        }
                    }







                }

            }
            System.out.println(countgai);
            for (String re : res) {
                System.out.println(re);
            }


        }

    }
    public static int getdeng(char[] arr,int start){
        int i = start-1;
        int count=0;
        while (i>0&&arr[i]==arr[i+1]){
            i--;
            count++;
        }
        return count;
    }
}


/*                    int max1 =0;
                    char maxkey1;
                    for (Map.Entry<Character, Integer> characterIntegerEntry : hash1.entrySet()) {
                        if(characterIntegerEntry.getValue()>max1){
                            max1=characterIntegerEntry.getValue();
                            maxkey1 = characterIntegerEntry.getKey();
                        }
                    }
                    int max2 =0;
                    char maxkey2;
                    for (Map.Entry<Character, Integer> characterIntegerEntry : hash2.entrySet()) {
                        if(characterIntegerEntry.getValue()>max1){
                            max2=characterIntegerEntry.getValue();
                            maxkey2 = characterIntegerEntry.getKey();
                        }
                    }
                                        if(max1<max2){
                        res.add()
                    }
                    */