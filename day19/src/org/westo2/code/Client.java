package org.westo2.code;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5550);
            OutputStream out = socket.getOutputStream();
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入你的聊天昵称：");
            String name = sc.next();
            System.out.println("-------请输入聊天内容-------");
            new Thread(()->{
                Scanner scanner = new Scanner(System.in);
                try {
                    out.write((name+"上线").getBytes("utf-8"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                while (scanner.hasNextLine()){
                    String s = scanner.nextLine();
                    try {
                        out.write((name+"说："+s).getBytes("utf-8"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            InputStream in = socket.getInputStream();
            int len;
            byte[] bytes = new byte[1024 * 8];
            while((len=in.read(bytes))!=-1){
                String s = new String(bytes, 0, len, "utf-8");
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
