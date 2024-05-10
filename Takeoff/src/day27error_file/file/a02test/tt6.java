package day27error_file.file.a02test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class tt6 {

    public static void main(String[] args) {
               /*
            需求：统计一个文件夹中每种文件的个数并打印。（考虑子文件夹）
            打印格式如下：
            txt:3个
            doc:4个
            jpg:6个
        */
        File file = new File("E:\\flanlin\\picture\\playboy\\pussy\\fanny") ;

        Map<String,Integer> map = serch(file);
        System.out.println(map);

    }
    public static Map<String,Integer> serch(File file){
        Map<String,Integer> map = new HashMap<>();
        File[] files = file.listFiles();
        for (File file1 : files) {
            if(file1.isDirectory()){
                Map<String, Integer> sonmap = serch(file1);
                sonmap.forEach(new BiConsumer<String, Integer>() {
                    @Override
                    public void accept(String s, Integer num) {
                        if(map.containsKey(s)){//总集包含子集
                            int count = map.get(s);
                            map.put(s,count+num);
                        }else {//总集不包含
                            map.put(s,num);
                        }
                    }
                });
            }else {//是文件
                String name = file1.getName();//这一步想不到!
                String[] n = name.split("\\.");
                if(n.length>=2){
                    String endName = n[n.length-1];
                    if(!map.containsKey(endName)){
                        map.put(endName,1);
                    }else {
                        int count = map.get(endName);
                        map.put(endName,count+1);
                    }
                }


                System.out.println(file1);
            }
        }
        return map;
    }
}
