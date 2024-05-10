package day30_IO_test.A01io_test.myiotest1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class tt1 {
    public static void main(String[] args) throws IOException {
        /*
         制造假数据：
             获取姓氏：https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&from=kg0
             获取男生名字：http://www.haoming8.cn/baobao/10881.html
             获取女生名字：http://www.haoming8.cn/baobao/7641.html
        */

        //1.定义变量记录网址
        String familyNameNet = "https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&from=kg0";
        String boyNameNet = "http://www.haoming8.cn/baobao/10881.html";
        String girlNameNet = "http://www.haoming8.cn/baobao/7641.html";

        //2.爬取数据,把网址上所有的数据拼接成一个字符串
        String familyNameStr = webCrawler(familyNameNet);
        String boyNameStr = webCrawler(boyNameNet);
        String girlNameStr = webCrawler(girlNameNet);
        //System.out.println(boyNameStr);

        //3.通过正则表达式，把其中符合要求的数据获取出来
        ArrayList<String> familylist1 = getData(familyNameStr,"(.{4})(，|。)",1);
        ArrayList<String> boyNamlist1 = getData(boyNameStr,"([\\u4E00-\\u9FA5]{2})(、|。)",1);
        ArrayList<String> girlNamelist1 = getData(girlNameStr,"(.. ){4}..",0);
        //System.out.println(familylist1);//[赵钱孙李, 周吴郑王, 冯陈褚卫, 蒋沈韩杨,
        //System.out.println(boyNamlist1);//[大气, 美好, 特色, 大气, 美好, 特色,
        //System.out.println(girlNamelist1);//[彤舞 芊静 艾丝 惠蕙 语月, 依莹 瑶馨 曼珍 逸云 微婉, 芳诗 逸抒 半烟 花依 绮灵,

        //4.处理
        ArrayList<String> familylist2 = familylistprocess(familylist1);
        ArrayList<String> boyNamelist2 = boylistprocess(boyNamlist1);
        ArrayList<String> girlNamelist2 = girllistprocess(girlNamelist1);
        //System.out.println(familylist2);//[赵, 钱, 孙, 李, 周, 吴, 郑, 王, 冯,
        //System.out.println(boyNamelist2);//[大气, 美好, 特色, 月星, 弘城, 雨国, 思明, 圣恩, 浩恒,
        //System.out.println(girlNamelist2);//[彤舞, 芊静, 艾丝, 惠蕙, 语月, 依莹, 瑶馨, 曼珍, 逸云,

        //5.生成数据
        //姓名（唯一）-性别-年龄
        ArrayList<String> list = getinfo(familylist2, boyNamelist2, girlNamelist2, 70, 50);
        Collections.shuffle(list);
        //System.out.println(list);//[拓智凯-男-45, 宰浩博-男-68, 黄昕莹-女-25, 籍黛梦-女-26, 项德宇-男-35, 韦世恒-男-77,

        BufferedWriter bw = new BufferedWriter(new FileWriter(
                "Takeoff\\src\\day30\\A01io_test\\myiotest1\\info.txt"));
        for (String s : list) {
            bw.write(s);
            bw.newLine();
        }
        bw.close();
    }
    public static ArrayList<String> getinfo(ArrayList<String> familylist2, ArrayList<String> boyNamelist2,
                                            ArrayList<String> girlNamelist2,int boycount,int girlcount){
        //名字不重复,所以用hashSet
        HashSet<String> boyh = new HashSet<>();
        while (boyh.size()<boycount){
            //想实现随机,可以打乱集合
            Collections.shuffle(familylist2);
            Collections.shuffle(boyNamelist2);
            boyh.add(familylist2.get(0)+boyNamelist2.get(0));
        }
        HashSet<String> girlh = new HashSet<>();
        while (girlh.size()<girlcount){
            //想实现随机,可以打乱集合
            Collections.shuffle(familylist2);
            Collections.shuffle(girlNamelist2);
            girlh.add(familylist2.get(0)+girlNamelist2.get(0));
        }
        //System.out.println(boyh);
        //System.out.println(girlh);
        ArrayList<String> arrayList = new ArrayList<>();
        Random r = new Random();
        for (String boyname : boyh) {
            //如果要18-80岁怎么办?
            int age = r.nextInt(63) + 18; //随机年龄
            arrayList.add(boyname+"-男-"+age);
        }
        for (String girlname: girlh) {
            int age = r.nextInt(18) + 12;
            arrayList.add(girlname+"-女-"+age);
        }
        return arrayList;
    }
    private static ArrayList<String> boylistprocess(ArrayList<String> boyNamlist1) {
        ArrayList<String>boyNamelist2 = new ArrayList<>();
        for (String s : boyNamlist1) {
            if(!boyNamelist2.contains(s)){
                boyNamelist2.add(s);
            }
        }
        return boyNamelist2;

    }


    private static ArrayList<String> girllistprocess(ArrayList<String> girlNamelist1) {
        //处理女生名字
        ArrayList<String> arrayList = new ArrayList<>();
        girlNamelist1.forEach(s -> {
                    for (String s1 : s.split(" ")) {
                        arrayList.add(s1);
                    }
                }
                );
        return arrayList;

    }

    private static ArrayList<String> familylistprocess(ArrayList<String> familylist1) {
        ArrayList<String> arrayList = new ArrayList<>();
        familylist1.forEach(s -> {
            // 将字符串转换为字符数组
            char[] charArray = s.toCharArray();
            for (char c:charArray){
                arrayList.add(String.valueOf(c));
            }
        });
        return arrayList;
    }

    private static ArrayList<String> getData(String str, String regex,int index) {
        ArrayList<String> arrayList = new ArrayList<>();
        //2.按照正则表达式的规则，去获取数据
        Pattern pattern = Pattern.compile(regex);
        //按照pattern的规则，到str当中获取数据
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()){
            arrayList.add(matcher.group(index));
        }
        return arrayList;
    }

    private static String webCrawler(String net) throws IOException {
        StringBuilder sb = new StringBuilder();
        URL url = new URL(net);
        URLConnection ucon = url.openConnection();

        InputStreamReader isr = new InputStreamReader(ucon.getInputStream());
        int ch;
        while ((ch = isr.read()) != -1){
            sb.append((char)ch);
        }
        //5.释放资源
        isr.close();
        //6.把读取到的数据返回
        return sb.toString();


    }

}
