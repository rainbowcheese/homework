package org.ji23.code;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5550);
            System.out.println("等待连接...");
            ExecutorService service = Executors.newFixedThreadPool(10);
            while (true){
                Socket accept = serverSocket.accept();
                service.submit(()->{
                   io(accept);
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void io(Socket accept) {
        try {
            InputStream in = accept.getInputStream();
            OutputStream out = accept.getOutputStream();
            int len=0;
            byte[] bytes = new byte[1024 * 8];
            while ((len=in.read(bytes))!=-1){
                String s = new String(bytes, 0, len,"utf-8");
                System.out.println(s);
                //out.write(s.getBytes("utf-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
