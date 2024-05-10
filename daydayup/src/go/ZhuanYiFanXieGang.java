package go;

public class ZhuanYiFanXieGang {
    public static void main(String[] args) {
        String str = "C:\\Program Files\\Java";
        String[] parts = str.split("\\\\");
        for (String part : parts) {
            System.out.println(part);
        }
        //需要使用双反斜杠 \\\\ 来表示一个反斜杠，因为在 Java 中反斜杠本身是一个转义字符，所以需要双反斜杠来转义。
    }
}
