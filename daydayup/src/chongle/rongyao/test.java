package chongle.rongyao;

import java.util.HashMap;

public class test {
    public static void main(String[] args) {
        HashMap< Music,Integer> map = new HashMap<>();
        Music music = new Music("a","a");
        map.put(music,1);
        Music music2 = new Music("a","a");
        System.out.println(map.get(music2));
        System.out.println(map.get(music));
    }
    static class Music{
        String name;
        String category;
        //String zhanshi;
        //int score;
        Music(String name,String category){
            this.name =name;
            this.category =category;
            //this.zhanshi = name+" "+category;
            //this.score = 0;
        }
    }
    //在Java中，HashMap使用键的hashCode()方法来确定键的存储位置。当您尝试将一个新的Music对象放入HashMap时，
    // HashMap首先会调用该键对象的hashCode()方法来计算哈希码，然后根据哈希码决定存储位置。
    //
    //在您的代码中，Music类没有重写hashCode()方法和equals()方法。因此，默认情况下，它们是使用Object类中的hashCode()方法和equals()方法。
    // Object类的hashCode()方法返回的哈希码是基于对象的内存地址的，而不是基于对象内容的。
    //
    //因此，虽然music和music2的内容相同，但它们是两个不同的对象，具有不同的内存地址，因此它们的哈希码也不同，导致它们被HashMap认为是不同的键。
    // 因此，map.get(music2)返回的是null，因为music2并没有被放入HashMap中。而map.get(music)返回的是1，因为music被放入了HashMap中，并且作为键对应的值是1。
}
