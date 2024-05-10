package day33socketnet.a12test6;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class Runtt implements Runnable{
    Socket socket;

    public Runtt(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            //一旦接收到了
            //输入,那就是从哪读进来?
            BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
            //写出去,要随机id uuid
            String uuid = UUID.randomUUID().toString().replace("-", "");
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(
                    "D:\\IdeaProjects\\javastudy\\Takeoff\\src\\day33socketnet\\a11test5\\"+uuid+".jpg"));

            int len;
            byte[] bytes = new byte[1024];
            while ((len = bis.read(bytes))!=-1){
                bos.write(bytes,0,len);
            }
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write("保存完毕");
            //bw.close();
            bw.newLine();
            bw.flush();//别忘了!!!
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
