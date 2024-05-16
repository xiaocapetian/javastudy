package chongle.rongyao;

import java.util.*;

public class tt3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //while (in.hasNextLine()) { // 注意 while 处理多个 case
        //List<Music> list = new ArrayList<>();
        HashMap<String,Music> map = new HashMap<>();
        HashMap<String,List<Music>> zhongleimap = new HashMap<>();
        String preB="";//上一个打断的的种类
        String preP = "";//上一个播放完的种类
        while (in.hasNextLine()){
            String s = in.nextLine();
            // if(s.isEmpty()){
            //     break;
            // }
            String[] sarr = s.split(" ");
            if(sarr[0].equals("I")){
                Music music = new Music(sarr[1],sarr[2]);
                map.put(sarr[1],music);
                if(zhongleimap.containsKey(sarr[2])){
                    List<Music> list = zhongleimap.get(sarr[2]);
                    list.add(music);
                    zhongleimap.put(sarr[2],list);
                }else {
                    List<Music> list =new ArrayList<>();
                    list.add(music);
                    zhongleimap.put(sarr[2],list);
                }
            }
            if(sarr[0].equals("P")){//播放完了一个
                //Music music = new Music(sarr[1],sarr[2]);
                //这首歌+3
                map.get(sarr[1]).score+=3;
                String cate = map.get(sarr[1]).category;
                if(!cate.equals("UnkownStyle")&&preP.equals(cate)){

                    List<Music> list = zhongleimap.get(cate);
                    for (int i = 0; i < list.size(); i++) {
                        if(!list.get(i).name.equals(sarr[1])){list.get(i).score ++;}
                    }
                }
                preP = cate;
            }
            if(sarr[0].equals("B")){
                map.get(sarr[1]).score-=2;
                String cate = map.get(sarr[1]).category;
                if(!cate.equals("UnkownStyle")&&preB.equals(cate)){

                    List<Music> list = zhongleimap.get(cate);
                    for (int i = 0; i < list.size(); i++) {
                        if(!list.get(i).name.equals(sarr[1])){list.get(i).score --;}
                    }
                }
                preB = cate;
            }
            //System.out.println(s);
        }
        Collection<Music> values = map.values();
        List<Music> list = new ArrayList<>();
        for (Music m : values) {
            list.add(m);
        }
        Collections.sort(list,(o1, o2) -> {
            return o2.score-o1.score;
        });
        for (Music music : list) {
            System.out.println(music.zhanshi);
        }
        //System.out.println("gg");
        //}

    }
    static class Music{
        String name;
        String category;
        String zhanshi;
        int score;
        Music(String name,String category){
            this.name =name;
            this.category =category;
            this.zhanshi = name+" "+category;
            this.score = 0;
        }
    }
}
/*
输入样例
 I MusicA Pop
 I MusicB Pop
 I MusicC Blue
 I MusicD Blue
 I MusicE UnkownStyle
 I MusicF Pop
 P MusicA
 P MusicB
 B MusicC
 P MusicF
 B MusicD
 B MusicE

 */